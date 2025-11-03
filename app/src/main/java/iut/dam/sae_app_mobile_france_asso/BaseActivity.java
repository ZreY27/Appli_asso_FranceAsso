package iut.dam.sae_app_mobile_france_asso;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        applyLanguage();
        applyTextScale();
        super.onCreate(savedInstanceState);
    }

    private void applyLanguage() {
        SharedPreferences prefs = getSharedPreferences("app_settings", MODE_PRIVATE);
        String langCode = prefs.getString("locale", "fr");
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);

        Configuration config = getResources().getConfiguration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }

    private void applyTextScale() {
        SharedPreferences prefs = getSharedPreferences("app_settings", MODE_PRIVATE);
        boolean isLargeText = prefs.getBoolean("large_text", false);

        Configuration config = getResources().getConfiguration();
        config.fontScale = isLargeText ? 1.4f : 1.0f;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }
}