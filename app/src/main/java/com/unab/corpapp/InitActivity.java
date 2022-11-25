package com.unab.corpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InitActivity extends AppCompatActivity {

    Button btn_goRegister;
    Button btn_gologin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        btn_goRegister = findViewById(R.id.btn_registerGoView);
        btn_goRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InitActivity.this, RegisterActivity.class));
            }
        });

        btn_gologin = findViewById(R.id.btn_loginGoView);
        btn_gologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InitActivity.this, LoginActivity.class));
            }
        });
    }
}