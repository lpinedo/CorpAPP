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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    Button btn_registerR;
    ImageButton btnDateIn;
    EditText fname,flastname, dateView,fsexo,fcareer,femail,fmobile,fpwd1,fpwd2;
    boolean isAllFieldsChecked = false;



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
        //verificacion de campos formulario
        btn_registerR = findViewById(R.id.btn_loginP);
        fname = findViewById(R.id.txt_InputNameInR);
        flastname = findViewById(R.id.txt_InputApellidInR);
        //fsexo = findViewById(R.id.txt_InputSIdR);
        fcareer = findViewById(R.id.txt_InputCarreaInR);
        femail = findViewById(R.id.txt_InputEmailInR);
        fmobile = findViewById(R.id.txt_InputMobilInR);
        fpwd1 = findViewById(R.id.txt_inputPwdIdR);
        fpwd2 = findViewById(R.id.txt_inputPwd2IdR);
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        btn_registerR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAllFieldsChecked = CheckAllFields();
                startActivity(new Intent(RegisterActivity.this, MenActivity.class));
                /*
                if (isAllFieldsChecked) {
                    //startActivity(new Intent(RegisterActivity.this, MenActivity.class));
                    Intent i = new Intent(RegisterActivity.this, MenActivity.class);
                    startActivity(i);
                }
                */
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
    private boolean CheckAllFields() {
        if (fname.length() == 0){
            fname.setError("Este campo es requerido");
            Toast.makeText(RegisterActivity.this, "El campo nombre no puede estar vacio", Toast.LENGTH_SHORT).show();

            return false;
        }
        if (flastname.length() == 0){
            flastname.setError("Este campo es requerido");
            Toast.makeText(RegisterActivity.this, "El campo apellido no puede estar vacio", Toast.LENGTH_SHORT).show();

            return false;
        }

        if (fcareer.length() == 0){
            fcareer.setError("Este campo es requerido");
            Toast.makeText(RegisterActivity.this, "El campo carrera no puede estar vacio", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (fmobile.length() == 0){
            fmobile.setError("Este campo es requerido");
            Toast.makeText(RegisterActivity.this, "El campo Celular no puede estar vacio", Toast.LENGTH_SHORT).show();

            return false;
        }
        if (femail.length() == 0){
            femail.setError("Este campo es requerido");
            Toast.makeText(RegisterActivity.this, "El campo email no puede estar vacio", Toast.LENGTH_SHORT).show();

            return false;
        }

        /*if (femail.match == 0){
            femail.setError("Este campo es requerido");
            Toast.makeText(RegisterActivity.this, "El campo email no puede estar vacio", Toast.LENGTH_SHORT).show();

            return false;
        }*/

        if (fpwd1.length() == 0){
            fpwd1.setError("Este campo es requerido");
            Toast.makeText(RegisterActivity.this, "El campo Password no puede estar vacio", Toast.LENGTH_SHORT).show();

            return false;
        }

        if (fpwd2.length() == 0){
            fpwd2.setError("Este campo es requerido");
            Toast.makeText(RegisterActivity.this, "El campo Password no puede estar vacio", Toast.LENGTH_SHORT).show();

            return false;
        }


        else {
            return true;
        }

    }
}