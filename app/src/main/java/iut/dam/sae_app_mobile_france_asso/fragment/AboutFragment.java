package iut.dam.sae_app_mobile_france_asso.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import iut.dam.sae_app_mobile_france_asso.R;

public class AboutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView txtVersion = view.findViewById(R.id.txt_version);
        TextView txtSource = view.findViewById(R.id.txt_source);

        txtVersion.setText("Version 1.0.0");

        txtSource.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/FlorianKP/SAE_App_Mobile_France_Asso.git"));
            startActivity(browserIntent);
        });
    }
}