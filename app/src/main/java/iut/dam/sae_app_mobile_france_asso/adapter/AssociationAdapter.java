package iut.dam.sae_app_mobile_france_asso.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import iut.dam.sae_app_mobile_france_asso.AssociationDetailActivity;
import iut.dam.sae_app_mobile_france_asso.R;
import iut.dam.sae_app_mobile_france_asso.Association;
import java.util.List;
import android.content.Intent;

public class AssociationAdapter extends BaseAdapter {
    private Context context;
    private List<Association> associations;

    public AssociationAdapter(Context context, List<Association> associations) {
        this.context = context;
        this.associations = associations;
    }

    @Override
    public int getCount() {
        return associations.size();
    }

    @Override
    public Object getItem(int position) {
        return associations.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_association, parent, false);
        }

        Association association = associations.get(position);

        TextView nameTextView = convertView.findViewById(R.id.association_name);
        ImageView logoImageView = convertView.findViewById(R.id.association_logo);

        nameTextView.setText(association.getName());

        Glide.with(context)
                .load(association.getLogoUrl())
                .placeholder(R.drawable.assoimage)
                .override(300, 136)
                .fitCenter()
                .into(logoImageView);

        convertView.setOnClickListener(v -> {
            Intent intent = new Intent(context, AssociationDetailActivity.class);
            intent.putExtra("associationId", association.getId());
            context.startActivity(intent);
        });


        return convertView;
    }
}