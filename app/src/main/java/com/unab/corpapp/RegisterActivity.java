package com.unab.corpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    Button btn_registerR,btn_dateId;
    EditText name,lastname, dateB,sexo,career,email,mobile;
    private Spinner mySpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mySpinner = (Spinner) findViewById(R.id.spinnerId);

        ArrayList<String> listS = new ArrayList<String>();

        listS.add("Masculino");
        listS.add("Femenino");

        ArrayAdapter adp = new ArrayAdapter(RegisterActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listS);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String elemento = (String) mySpinner.getAdapter().getItem(i);
                //Toast.makeText(RegisterActivity.this, "Seleccionaste: "+i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mySpinner.setAdapter(adp);

        btn_registerR = findViewById(R.id.btn_loginP);
        btn_registerR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, MenActivity.class));
            }
        });
    }
}