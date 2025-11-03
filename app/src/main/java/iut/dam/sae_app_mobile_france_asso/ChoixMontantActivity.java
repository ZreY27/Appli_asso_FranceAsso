package iut.dam.sae_app_mobile_france_asso;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChoixMontantActivity extends AppCompatActivity {
    private Association association;
    private String montant;
    private String typeDon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choix_montant);

        typeDon = getIntent().getStringExtra("TYPE_DON");
        TextView typeTitre = findViewById(R.id.titre);
        typeTitre.setText("Faire un don " + typeDon + " à");
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        if(typeDon.equals("recurrent")){
            radioGroup.setVisibility(View.VISIBLE);
        }

        TextView textView = findViewById(R.id.association_intitule);
        association = (Association) getIntent().getSerializableExtra("association");
        textView.setText(association.getIntitule());

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        });

        TextView montant01 = findViewById(R.id.text_montant01);
        TextView montant02 = findViewById(R.id.text_montant02);
        TextView montant03 = findViewById(R.id.text_montant03);
        TextView montant04 = findViewById(R.id.text_montant04);

        EditText editMontantLibre = findViewById(R.id.edit_text_montant_libre);

        Button btnDonner = findViewById(R.id.button_donate);

        montant01.setOnClickListener(v -> {
            resetSelection(montant01, montant02, montant03, montant04);
            montant = "1";
            montant01.setBackgroundResource(R.drawable.bordure_choix_montant_selected);
        });

        montant02.setOnClickListener(v -> {
            resetSelection(montant01, montant02, montant03, montant04);
            montant = "10";
            montant02.setBackgroundResource(R.drawable.bordure_choix_montant_selected);
        });

        montant03.setOnClickListener(v -> {
            resetSelection(montant01, montant02, montant03, montant04);
            montant = "50";
            montant03.setBackgroundResource(R.drawable.bordure_choix_montant_selected);
        });

        montant04.setOnClickListener(v -> {
            resetSelection(montant01, montant02, montant03, montant04);
            montant = "100";
            montant04.setBackgroundResource(R.drawable.bordure_choix_montant_selected);
        });

        btnDonner.setOnClickListener(v -> {
            String montantSaisi = editMontantLibre.getText().toString().trim();

            if (!TextUtils.isEmpty(montantSaisi)) {
                if (montantSaisi.matches("\\d+")) {
                    montant = montantSaisi;
                } else {
                    Toast.makeText(this, "Veuillez saisir un montant valide (entier)", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            int selectedId = radioGroup.getCheckedRadioButtonId(); // Récupérer l'ID sélectionné

            if ( typeDon.equals("recurrent") && selectedId == -1){
                Toast.makeText(this, "Veuillez choisir la périodicité du don", Toast.LENGTH_SHORT).show();
                return;
            }
            if (montant == null || montant.isEmpty()) {
                Toast.makeText(this, "Veuillez choisir ou saisir un montant", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Montant sélectionné : " + montant + " €", Toast.LENGTH_SHORT).show();


            Intent intent = new Intent(ChoixMontantActivity.this, PayementActivity.class);
            int montant_int = Integer.parseInt(montant);
            RadioButton selectedRadioButton = findViewById(selectedId);
            String periodicite = null;
            if(typeDon.equals("recurrent")){
                periodicite = (selectedRadioButton.getText().toString().equals("Don annuel")?"annuel":"mensuel");
            }
            intent.putExtra("montant", montant_int);
            intent.putExtra("association", association);
            intent.putExtra("TYPE_DON",typeDon);
            intent.putExtra("periodicite", periodicite);
            startActivity(intent);
        });
    }

    private void resetSelection(TextView... views) {
        for (TextView tv : views) {
            tv.setBackgroundResource(R.drawable.bordure_choix_montant);
            tv.setTextColor(getResources().getColor(R.color.black));
        }
    }

}