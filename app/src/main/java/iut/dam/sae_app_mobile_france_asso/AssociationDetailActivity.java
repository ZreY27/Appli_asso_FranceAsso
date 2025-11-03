package iut.dam.sae_app_mobile_france_asso;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class AssociationDetailActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private String associationId;
    private ImageView logoImageView;
    private TextView nameTextView;
    private TextView descriptionTextView;
    private Button donateButton;
    private Association association;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_association_detail);

        associationId = getIntent().getStringExtra("associationId");
        logoImageView = findViewById(R.id.association_logo);
        nameTextView = findViewById(R.id.header_association_name);
        descriptionTextView = findViewById(R.id.association_description);
        donateButton = findViewById(R.id.button_donate);

        if (associationId == null || associationId.isEmpty()) {
            Toast.makeText(this, "Association introuvable", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        db = FirebaseFirestore.getInstance();

        fetchAssociationDetails();

        donateButton.setOnClickListener(v -> {
            Intent donatePage = new Intent(AssociationDetailActivity.this, ChoixDonation.class);
            donatePage.putExtra("association", association);
            startActivity(donatePage);
        });
    }

    private void fetchAssociationDetails() {
        DocumentReference docRef = db.collection("associations").document(associationId);

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        String category = document.getString("categorie");
                        String name = document.getString("name");
                        String description = document.getString("description");
                        String logoUrl = document.getString("logoUrl");
                        String intitule = document.getString("intitule");


                        nameTextView.setText(intitule);
                        descriptionTextView.setText(description);

                        Glide.with(AssociationDetailActivity.this)
                                .load(logoUrl)
                                .placeholder(R.drawable.assoimage)
                                .override(300, 136)
                                .fitCenter()
                                .into(logoImageView);
                        association = new Association(associationId, category, description, logoUrl, name, intitule);
                    } else {
                        Toast.makeText(AssociationDetailActivity.this, "Association introuvable", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Log.e("Firestore", "Erreur de récupération des données", task.getException());
                    Toast.makeText(AssociationDetailActivity.this, "Erreur de chargement", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void clickBack(android.view.View view) {
        finish();
    }


}
