package com.unab.corpapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.firestore.FirestoreArray;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.unab.corpapp.adapter.ImcAdapter;
import com.unab.corpapp.model.Imc;

public class MenActivity extends AppCompatActivity {

    Button btn_imcAdd;
    RecyclerView mRecycler;
    ImcAdapter mAdapter;
    FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men);

        mFirestore = FirebaseFirestore.getInstance();
        mRecycler = findViewById(R.id.recicleViewId);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        Query query = mFirestore.collection("IMC");
        FirestoreRecyclerOptions<Imc> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Imc>().setQuery(query, Imc.class).build();
        mAdapter = new ImcAdapter(firestoreRecyclerOptions, this);
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);

        this.setTitle("Bienvenid@");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_imcAdd = findViewById(R.id.btn_addimc);
        btn_imcAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenActivity.this, AddImcActivity.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        //return super.onSupportNavigateUp();
        onBackPressed();
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.startListening();;
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAdapter.startListening();
    }
}