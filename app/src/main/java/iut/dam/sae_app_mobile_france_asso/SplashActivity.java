package iut.dam.sae_app_mobile_france_asso;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {
            if (!SharedPrefManager.isIntroSeen(SplashActivity.this)) {
                startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
            } else {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
            finish();
        }, 1500);
    }
}