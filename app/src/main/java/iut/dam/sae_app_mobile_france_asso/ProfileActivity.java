package iut.dam.sae_app_mobile_france_asso;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.templates.TemperatureControlTemplate;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import android.widget.ImageButton;
import androidx.activity.OnBackPressedCallback;

public class ProfileActivity extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth;
    private TextView tvEmail, tvUserId;
    private boolean isAdmin;
    private Bundle bundle;
    private Button buttonHist;
    private TextView associationName;
    private TextView associationText;
    private TextView userName;
    private TextView userFirstname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bundle = new Bundle();

        buttonHist = findViewById(R.id.btnHist);

        mAuth = FirebaseAuth.getInstance();
        tvEmail = findViewById(R.id.profile_mail);
        tvUserId = findViewById(R.id.profile_id);
        userName = findViewById(R.id.profile_name);
        userFirstname = findViewById(R.id.profile_firstname);

        associationText = findViewById(R.id.profile_asso_text);
        associationName = findViewById(R.id.profile_asso);

        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            tvEmail.setText(user.getEmail());
            tvUserId.setText(user.getUid());

            DocumentReference userRef = db.collection("users").document(user.getUid());
            userRef.get().addOnSuccessListener(documentSnapshot -> {
                if (documentSnapshot.exists()) {
                    userName.setText(documentSnapshot.getString("name"));
                    userFirstname.setText(documentSnapshot.getString("firstname"));
                    isAdmin = Boolean.TRUE.equals(documentSnapshot.getBoolean("isAdmin"));
                    if (isAdmin) {
                        String idAsso = documentSnapshot.getString("idAsso");
                        bundle.putString("idAsso", idAsso);

                        buttonHist.setVisibility(View.VISIBLE);
                        associationName.setVisibility(View.VISIBLE);
                        associationText.setVisibility(View.VISIBLE);

                        if (idAsso != null && !idAsso.isEmpty()) {
                            DocumentReference assoRef = db.collection("associations").document(idAsso);
                            assoRef.get().addOnSuccessListener(assoSnapshot -> {
                                if (assoSnapshot.exists()) {
                                    String assoName = assoSnapshot.getString("name");
                                    if (assoName != null) {
                                        associationName.setText(assoName);
                                    }
                                }
                            }).addOnFailureListener(e ->
                                    Toast.makeText(this, "Erreur de récupération de l'association", Toast.LENGTH_SHORT).show()
                            );
                        }
                    }
                }
            }).addOnFailureListener(e -> {
                Toast.makeText(this, "Erreur de récupération des données", Toast.LENGTH_SHORT).show();
            });
        } else {
            Toast.makeText(this, "Aucun utilisateur connecté", Toast.LENGTH_SHORT).show();
            finish();
        }

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        });
    }

    public void clickLogout(View view) {
        mAuth.signOut();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void clickHistDon(View view){
        Intent intent = new Intent(this, HistoriqueActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}