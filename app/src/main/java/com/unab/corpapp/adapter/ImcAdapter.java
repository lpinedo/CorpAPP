package com.unab.corpapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.unab.corpapp.R;
import com.unab.corpapp.model.Imc;

public class ImcAdapter extends FirestoreRecyclerAdapter<Imc, ImcAdapter.ViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ImcAdapter(@NonNull FirestoreRecyclerOptions<Imc> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull Imc Imc) {
        viewHolder.name.setText(Imc.getName());
        viewHolder.estatura.setText(Imc.getStature());
        viewHolder.peso.setText(Imc.getWeight());
        viewHolder.imc.setText(Imc.getIMC());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_imc, parent, false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,estatura,peso,imc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textViewNameId);
            estatura = itemView.findViewById(R.id.textViewstatuId);
            peso = itemView.findViewById(R.id.textViewWeiId);
            imc = itemView.findViewById(R.id.textViewImcId);
        }
    }
}
