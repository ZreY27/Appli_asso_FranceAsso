package iut.dam.sae_app_mobile_france_asso.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import iut.dam.sae_app_mobile_france_asso.R;

public class IntroAdapter extends RecyclerView.Adapter<IntroAdapter.IntroViewHolder> {

    private final Context context;

    private final int[] images = {
            R.drawable.onboarding_1,
            R.drawable.onboarding_2,
            R.drawable.onboarding_3
    };

    private final String[] titles = {
            "Bienvenue 👋",
            "Trouvez des assos",
            "Faites un don utile"
    };

    private final String[] descriptions = {
            "Découvrez les associations autour de la santé et de la solidarité.",
            "Explorez par thématiques, maladies ou publics spécifiques.",
            "Soutenez les causes qui vous tiennent à cœur facilement."
    };

    public IntroAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public IntroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_intro_slide, parent, false);
        return new IntroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IntroViewHolder holder, int position) {
        holder.image.setImageResource(images[position]);
        holder.title.setText(titles[position]);
        holder.description.setText(descriptions[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    static class IntroViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, description;

        public IntroViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgSlide);
            title = itemView.findViewById(R.id.tvTitle);
            description = itemView.findViewById(R.id.tvDescription);
        }
    }
}