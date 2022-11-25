package com.unab.corpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddImcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_imc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        //return super.onSupportNavigateUp();
        onBackPressed();
        return false;
    }
}