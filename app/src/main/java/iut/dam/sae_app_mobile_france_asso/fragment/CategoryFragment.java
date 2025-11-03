package iut.dam.sae_app_mobile_france_asso.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import iut.dam.sae_app_mobile_france_asso.R;

public class CategoryFragment extends Fragment {

    private CategoryListener categoryListener;

    public interface CategoryListener {
        void onCategorySelected(String category);
    }

    public void setCategoryListener(CategoryListener listener) {
        this.categoryListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_category_fragment, container, false);

        Button allButton = view.findViewById(R.id.category_all);
        Button maladiesButton = view.findViewById(R.id.category_maladies);
        Button accidentsButton = view.findViewById(R.id.category_accidents);
        Button handicapButton = view.findViewById(R.id.category_handicap);
        Button santeMentaleButton = view.findViewById(R.id.category_sante_mentale);
        Button droitsButton = view.findViewById(R.id.category_droits);
        Button aidantsButton = view.findViewById(R.id.category_aidants);
        Button preventionButton = view.findViewById(R.id.category_prevention);

        allButton.setOnClickListener(v -> notifyCategorySelected("Toutes"));
        maladiesButton.setOnClickListener(v -> notifyCategorySelected("Maladies chroniques"));
        accidentsButton.setOnClickListener(v -> notifyCategorySelected("Accidents et effets secondaires"));
        handicapButton.setOnClickListener(v -> notifyCategorySelected("Handicap et dépendance"));
        santeMentaleButton.setOnClickListener(v -> notifyCategorySelected("Santé mentale et bien-être psychique"));
        droitsButton.setOnClickListener(v -> notifyCategorySelected("Droits des patients et accès aux soins"));
        aidantsButton.setOnClickListener(v -> notifyCategorySelected("Soutien aux aidants et proches"));
        preventionButton.setOnClickListener(v -> notifyCategorySelected("Prévention et santé publique"));

        return view;
    }

    private void notifyCategorySelected(String category) {
        if (categoryListener != null) {
            categoryListener.onCategorySelected(category);
        }
    }
}
