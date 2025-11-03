package iut.dam.sae_app_mobile_france_asso;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PayementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payement);
        int montant = getIntent().getIntExtra("montant",-1);
        Association association = (Association) getIntent().getSerializableExtra("association");
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        });

        ImageView imgCB = findViewById(R.id.carte_bancaire_logo);
        TextView textCB = findViewById(R.id.carte_bancaire_TextView);

        ImageView imgVirement = findViewById(R.id.virement_logo);
        TextView textVirement = findViewById(R.id.virement_TextView);

        ImageView imgPaypal = findViewById(R.id.paypal_logo);
        TextView textPaypal = findViewById(R.id.paypal_TextView);

        LinearLayout zoneConfirmation = findViewById(R.id.zone_confirmation);
        TextView texteInfo = findViewById(R.id.texte_info);
        Button btnJeDonne = findViewById(R.id.btn_je_donne);

        View.OnClickListener cbClickListener = v -> {
            showConfirmation("Vous avez sélectionné le paiement par carte bancaire.");
            btnJeDonne.setVisibility(View.VISIBLE);
            btnJeDonne.setOnClickListener(d -> {
                Intent intent = new Intent(this, PayementCBActivity.class);
                intent.putExtra("montant", montant);
                intent.putExtra("association", association);
                intent.putExtra("TYPE_DON", getIntent().getStringExtra("TYPE_DON"));
                intent.putExtra("periodicite", getIntent().getStringExtra("periodicite"));
                startActivity(intent);
            });
        };
        imgCB.setOnClickListener(cbClickListener);
        textCB.setOnClickListener(cbClickListener);

        View.OnClickListener virementClickListener = v -> {
            showConfirmation("Merci de faire votre virement à :\nFR76 3000 4000 5000 6000 7000 189");
            btnJeDonne.setVisibility(View.VISIBLE);
            btnJeDonne.setOnClickListener(d -> {
                Toast.makeText(this, "Fonction à venir !", Toast.LENGTH_SHORT).show();
            });
        };
        imgVirement.setOnClickListener(virementClickListener);
        textVirement.setOnClickListener(virementClickListener);

        View.OnClickListener paypalClickListener = v -> {
            showConfirmation("Paiement via PayPal : fonctionnalité en cours de développement.");
            btnJeDonne.setVisibility(View.VISIBLE);
            btnJeDonne.setOnClickListener(d -> {
                Toast.makeText(this, "Fonction à venir !", Toast.LENGTH_SHORT).show();
            });
        };
        imgPaypal.setOnClickListener(paypalClickListener);
        textPaypal.setOnClickListener(paypalClickListener);
    }

    private void showConfirmation(String texte) {
        LinearLayout zoneConfirmation = findViewById(R.id.zone_confirmation);
        TextView texteInfo = findViewById(R.id.texte_info);
        Button btnJeDonne = findViewById(R.id.btn_je_donne);

        texteInfo.setText(texte);
        zoneConfirmation.setVisibility(View.VISIBLE);
        btnJeDonne.setAlpha(0f);
        btnJeDonne.animate().alpha(1f).setDuration(300).start();
    }
}