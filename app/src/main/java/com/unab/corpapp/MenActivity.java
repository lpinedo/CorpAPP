package com.unab.corpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenActivity extends AppCompatActivity {

    Button btn_imcAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men);
        this.setTitle("Mi mundo");
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
}