package iut.dam.sae_app_mobile_france_asso.fragment;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Locale;

import iut.dam.sae_app_mobile_france_asso.R;

public class SettingsFragment extends Fragment {

    private Switch switchAccessibilityText;
    private Spinner spinnerLanguage;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        switchAccessibilityText = view.findViewById(R.id.switch_large_text);
        spinnerLanguage = view.findViewById(R.id.spinner_language);

        SharedPreferences prefs = requireContext().getSharedPreferences("app_settings", getContext().MODE_PRIVATE);
        boolean isLargeText = prefs.getBoolean("large_text", false);
        switchAccessibilityText.setChecked(isLargeText);

        switchAccessibilityText.setOnCheckedChangeListener((buttonView, isChecked) -> {
            boolean previous = prefs.getBoolean("large_text", false);
            if (previous != isChecked) {
                prefs.edit().putBoolean("large_text", isChecked).apply();
                requireActivity().recreate();
            }
        });

        spinnerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getItemAtPosition(position).toString();
                if (selected.equals("Français")) {
                    setLocale("fr");
                } else if (selected.equals("English")) {
                    setLocale("en");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        String currentLang = prefs.getString("locale", "fr");
        if (currentLang.equals("en")) {
            spinnerLanguage.setSelection(1);
        } else {
            spinnerLanguage.setSelection(0);
        }
    }

    private void setLocale(String languageCode) {
        SharedPreferences prefs = requireContext().getSharedPreferences("app_settings", getContext().MODE_PRIVATE);
        String currentLang = prefs.getString("locale", "");
        if (!languageCode.equals(currentLang)) {
            prefs.edit().putString("locale", languageCode).apply();

            Locale locale = new Locale(languageCode);
            Locale.setDefault(locale);

            Configuration config = getResources().getConfiguration();
            config.setLocale(locale);
            getResources().updateConfiguration(config, getResources().getDisplayMetrics());

            requireActivity().recreate();
        }
    }
}