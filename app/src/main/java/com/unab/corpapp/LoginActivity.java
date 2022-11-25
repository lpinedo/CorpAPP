package com.unab.corpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button btn_loginIn;
    //String txt_aquiGo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_loginIn = findViewById(R.id.btn_loginP);
        btn_loginIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MenActivity.class));
            }
        });

        TextView textView = findViewById(R.id.txt_notUser2Id);
        String text ="AQUI!!!";
        SpannableString ss = new SpannableString(text);
        //ClickableSpan onClick(Vi);

    }
}