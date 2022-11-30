package com.unab.corpapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    Button btn_registerR;
    ImageButton btnDateIn;
    EditText name,lastname, dateView,sexo,career,email,mobile;
    //private Spinner mySpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dateView = findViewById(R.id.txt_InputFechaInR);
        btnDateIn = findViewById(R.id.btn_dateId);

        //mySpinner = (Spinner) findViewById(R.id  n.spinnerId);

        //ArrayList<String> listS = new ArrayList<String>();

       // listS.add("Masculino");
        //listS.add("Femenino");

       // ArrayAdapter adp = new ArrayAdapter(RegisterActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listS);

       /* mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String elemento = (String) mySpinner.getAdapter().getItem(i);
                //Toast.makeText(RegisterActivity.this, "Seleccionaste: "+i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mySpinner.setAdapter(adp);*/

        btn_registerR = findViewById(R.id.btn_loginP);
        btn_registerR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, MenActivity.class));
            }
        });

        btnDateIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //final Calendar c = Calendar.getInstance();
                Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateView.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
    }
}