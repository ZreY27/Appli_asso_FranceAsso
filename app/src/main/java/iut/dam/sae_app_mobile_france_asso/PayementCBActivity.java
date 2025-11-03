package iut.dam.sae_app_mobile_france_asso;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class PayementCBActivity extends AppCompatActivity {
    private int montant;
    private String type_don;
    private Association association;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payement_cbactivity);
        mAuth = FirebaseAuth.getInstance();
        montant = getIntent().getIntExtra("montant",-1);
        association = (Association) getIntent().getSerializableExtra("association");
        type_don = getIntent().getStringExtra("TYPE_DON");
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void clickGive(View view) {
        if (areFieldsFilled()) {
            if(type_don.equals("unique")){
                registerUniqueDonation();
            }else{
                registerRecurrentDonation();
            }

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }


    private boolean areFieldsFilled() {
        int[] fieldIds = {R.id.edt_titulaire, R.id.edt_numero_carte, R.id.edt_date_expiration, R.id.edt_cryptogramme};

        for (int id : fieldIds) {
            EditText field = findViewById(id);
            if (field.getText().toString().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }


    private void registerUniqueDonation() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        String annee = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        String documentId = annee + "_" + association.getId(); // Clé composite

        DocumentReference docRef = db.collection("dons_uniques").document(documentId);

        docRef.get().addOnSuccessListener(documentSnapshot -> {
                    long montantTotal = 0;
                    if (documentSnapshot.exists()) {
                        montantTotal = documentSnapshot.getLong("montantTotal") != null ? documentSnapshot.getLong("montantTotal") : 0;
                    }
                    montantTotal += montant;  // Ajouter le montant du don actuel

                    Map<String, Object> data = new HashMap<>();
                    data.put("montantTotal", montantTotal);

                    docRef.set(data)
                            .addOnSuccessListener(aVoid -> {
                                Toast.makeText(getApplicationContext(), "Don enregistré avec succès !", Toast.LENGTH_SHORT).show();
                            })
                            .addOnFailureListener(e -> {Toast.makeText(getApplicationContext(), "Erreur lors de l'enregistrement", Toast.LENGTH_SHORT).show();});
                })
                .addOnFailureListener(e -> Log.w("Firestore", "Erreur lors de la récupération du don", e));
    }

    private void registerRecurrentDonation() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String documentId = association.getId() + "_" + user.getUid(); // Clé composite

        DocumentReference docRef = db.collection("dons_recurrents").document(documentId);

        docRef.get().addOnSuccessListener(documentSnapshot -> {
                    Map<String, Object> data = new HashMap<>();
                    data.put("montant", montant);
                    data.put("periodicite",getIntent().getStringExtra("periodicite"));

                    docRef.set(data)
                            .addOnSuccessListener(aVoid -> {
                                Toast.makeText(getApplicationContext(), "Don enregistré avec succès !", Toast.LENGTH_SHORT).show();
                            })
                            .addOnFailureListener(e -> {Toast.makeText(getApplicationContext(), "Erreur lors de l'enregistrement", Toast.LENGTH_SHORT).show();});
                })
                .addOnFailureListener(e -> Log.w("Firestore", "Erreur lors de la récupération du don", e));
    }

}