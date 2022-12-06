package com.unab.corpapp.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.unab.corpapp.AddImcActivity;
import com.unab.corpapp.R;
import com.unab.corpapp.model.Imc;

import java.lang.annotation.Documented;

public class ImcAdapter extends FirestoreRecyclerAdapter<Imc, ImcAdapter.ViewHolder> {

    private FirebaseFirestore mFirestone = FirebaseFirestore.getInstance();
    Activity activity;

    public ImcAdapter(@NonNull FirestoreRecyclerOptions<Imc> options, Activity activity) {

        super(options);
        this.activity = activity;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull Imc Imc) {
        DocumentSnapshot documentSnapshot = getSnapshots().getSnapshot(viewHolder.getAdapterPosition());
        final String id = documentSnapshot.getId();
        /*
        DocumentSnapshot documentSnapshot = getSnapshots().getSnapshot(viewHolder.getAdapterPosition());
        final String id = documentSnapshot.getId();

         */
        viewHolder.name.setText(Imc.getName());
        viewHolder.estatura.setText(Imc.getStature());
        viewHolder.peso.setText(Imc.getWeight());
        viewHolder.imc.setText(Imc.getIMC());

        viewHolder.btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, AddImcActivity.class);
                i.putExtra("id_imc", id);
                activity.startActivity(i);
            }
        });

        viewHolder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteImc(id);
            }
        });
    }

    private void deleteImc(String id) {
        mFirestone.collection("IMC").document(id).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(activity, "Eliminado correctamente", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(activity, "Error al eliminar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_imc, parent, false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,estatura,peso,imc;
        ImageButton btn_delete, btn_edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textViewNameId);
            estatura = itemView.findViewById(R.id.textViewstatuId);
            peso = itemView.findViewById(R.id.textViewWeiId);
            imc = itemView.findViewById(R.id.textViewImcId);
            btn_delete = itemView.findViewById(R.id.btn_delid);
            btn_edit = itemView.findViewById(R.id.btn_editId);
        }
    }
}
