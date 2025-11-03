package iut.dam.sae_app_mobile_france_asso;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iut.dam.sae_app_mobile_france_asso.adapter.HistDonRecurrentAdapter;

public class HistoriqueActivity extends AppCompatActivity {
    private String adminAssoID;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<DonRecurrent> donsRecurrents;
    private HistDonRecurrentAdapter adapter;
    private Map<String, String> users;
    private Map<String, String> donsUniques;
    private ListView histDonsList;
    private Spinner spinnerAnnee;
    private TextView montantTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_historique);

        adminAssoID = getIntent().getStringExtra("idAsso");

        donsRecurrents = new ArrayList<>();
        users = new HashMap<>();
        donsUniques = new HashMap<>();

        histDonsList = findViewById(R.id.hist_dons_list);
        adapter = new HistDonRecurrentAdapter(this, R.layout.item_hist_don, donsRecurrents);
        histDonsList.setAdapter(adapter);

        spinnerAnnee = findViewById(R.id.spinner_annee);
        montantTotal = findViewById(R.id.text_montant_total);

        fetchAllDonsUniquesASync();
        fetchAllDonsRecurrentsAndUsersASync();

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        });
    }



    public void fetchAllDonsRecurrentsAndUsersASync(){
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            users.clear();
                            for (QueryDocumentSnapshot document : task.getResult()){
                                String userId = document.getId();
                                String firstName = (String) document.getData().get("firstname");
                                String lastName = (String) document.getData().get("name");

                                users.put(userId, lastName.toUpperCase() + " " + firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase());
                            }
                            fetchAllDonsRecurrentsASync();
                        }else {
                            Log.d(this.getClass().getName(), "error");
                        }
                    }
                });
    }

    public void fetchAllDonsRecurrentsASync(){
        db.collection("dons_recurrents")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            donsRecurrents.clear();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String associationId = getFirstKeyFromDocumentId(document.getId());
                                if (associationId.equals(adminAssoID)) {
                                    String userName = users.get(getSecondKeyFromDocumentId(document.getId()));
                                    String montant = String.valueOf(document.getData().get("montant"));
                                    String periodicite = (String) document.getData().get("periodicite");

                                    DonRecurrent d = new DonRecurrent(associationId, userName, montant, periodicite);

                                    donsRecurrents.add(d);
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }else {
                            Log.d(this.getClass().getName(), "error");
                        }
                    }
                });
    }

    public void fetchAllDonsUniquesASync(){
        db.collection("dons_uniques")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            donsUniques.clear();
                            for (QueryDocumentSnapshot document : task.getResult()){
                                String annee = getFirstKeyFromDocumentId(document.getId());
                                String associationId = getSecondKeyFromDocumentId(document.getId());
                                String montant = String.valueOf(document.getData().get("montantTotal"));

                                if (associationId.equals(adminAssoID))
                                    donsUniques.put(annee, montant+" €");
                            }
                            setDonsUniques();
                        }else {
                            Log.d(this.getClass().getName(), "error");
                        }
                    }
                });
    }

    public String getFirstKeyFromDocumentId(String documentId) {
        if (documentId.contains("_")) {
            return documentId.split("_")[0]; // Prend la partie avant "_"
        }
        return null; // Retourne null si le format est incorrect
    }

    public String getSecondKeyFromDocumentId(String documentId) {
        if (documentId.contains("_")) {
            return documentId.split("_")[1]; // Prend la partie après "_"
        }
        return null; // Retourne null si le format est incorrect
    }

    public void setDonsUniques(){
        List<String> annees = new ArrayList<>(donsUniques.keySet());

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, annees);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAnnee.setAdapter(adapterSpinner);

        spinnerAnnee.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedYear = annees.get(position);
                montantTotal.setText(donsUniques.get(selectedYear));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                montantTotal.setText("");
            }
        });
    }
}