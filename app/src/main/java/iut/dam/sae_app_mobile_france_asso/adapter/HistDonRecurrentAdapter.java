package iut.dam.sae_app_mobile_france_asso.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import iut.dam.sae_app_mobile_france_asso.DonRecurrent;
import iut.dam.sae_app_mobile_france_asso.R;

public class HistDonRecurrentAdapter extends ArrayAdapter<DonRecurrent> {
    public HistDonRecurrentAdapter(@NonNull Context context, int activity_historique, @NonNull List<DonRecurrent> items) {
        super(context, activity_historique, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View layout = convertView;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            layout = inflater.inflate(R.layout.item_hist_don, parent, false);
        }

        DonRecurrent donRecurrent =getItem(position);

        TextView donateurName =layout.findViewById(R.id.donateur_name);
        TextView periodicite = layout.findViewById(R.id.periodicite);
        TextView montant = layout.findViewById(R.id.montant);

        donateurName.setText(donRecurrent.getDonateurName());
        periodicite.setText(donRecurrent.getPeriodicite());
        montant.setText(donRecurrent.getMontant()+" €");

        return layout;
    }
}
