package iut.dam.sae_app_mobile_france_asso;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    Button btnSeConnecter, btnContinuer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnSeConnecter = findViewById(R.id.btnSeConnecter);
        btnContinuer = findViewById(R.id.btnContinuer);

        btnSeConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, ConnexionActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnContinuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, IntroductionActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
