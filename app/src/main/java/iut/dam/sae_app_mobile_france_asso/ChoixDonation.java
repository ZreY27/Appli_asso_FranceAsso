package iut.dam.sae_app_mobile_france_asso;

import static android.widget.Toast.makeText;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChoixDonation extends AppCompatActivity {
    private Association association;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choix_donation);

        Button bUnique = findViewById(R.id.btn_unique);
        Button bRecurrent = findViewById(R.id.btn_recurrent);

        association = (Association) getIntent().getSerializableExtra("association");
        mAuth = FirebaseAuth.getInstance();
        TextView associationName = findViewById(R.id.association_name);
        ImageView associationLogo = findViewById(R.id.association_logo);

        associationName.setText(association.getIntitule());
        Glide.with(this)
                .load(association.getLogoUrl())
                .placeholder(R.drawable.assoimage)
                .override(300, 136)
                .fitCenter()
                .into(associationLogo);

        bUnique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ouvrirChoixMontant("unique");
            }
        });

        bRecurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = mAuth.getCurrentUser();
                if (user == null){
                    Toast.makeText(ChoixDonation.this, "Connexion requise", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ChoixDonation.this, ConnexionActivity.class);
                    intent.putExtra("fromChoixDonation", true);
                    startActivity(intent);
                    return;
                }
                ouvrirChoixMontant("recurrent");
            }
        });

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        });
    }

    private void ouvrirChoixMontant(String type) {
        Intent intent = new Intent(ChoixDonation.this, ChoixMontantActivity.class);
        intent.putExtra("association", association);
        intent.putExtra("TYPE_DON", type);
        startActivity(intent);
    }
}