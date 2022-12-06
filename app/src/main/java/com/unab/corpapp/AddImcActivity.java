package com.unab.corpapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class AddImcActivity extends AppCompatActivity {

    EditText nombre,peso,estatura;
    TextView res,resNum;
    Button btn_calc;
    private FirebaseFirestore mfirestone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_imc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.setTitle("Calcular IMC");
        mfirestone = FirebaseFirestore.getInstance();
        String id = getIntent().getStringExtra("id_imc");

        nombre = (EditText) findViewById(R.id.txtNombreTid);
        estatura  = (EditText) findViewById(R.id.txt_EstaturaTId);
        peso = (EditText) findViewById(R.id.txt_pesoTId);
        res = (TextView) findViewById(R.id.txt_resIMCTId);
        resNum = (TextView) findViewById(R.id.txt_resIMCT2Id);
        btn_calc = (Button) findViewById(R.id.btn_calcularICMId);

        if (id == null || id == ""){
            btn_calc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String nameIn = nombre.getText().toString().trim();
                    String weightIn = peso.getText().toString().trim();
                    String statureIn = estatura.getText().toString().trim();

                    if (weightIn.isEmpty() && statureIn.isEmpty()){
                        Toast.makeText(AddImcActivity.this, "Hay campos Vacios", Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        float d1,d2,imc;
                        String nameT;
                        d1 = Float.parseFloat(peso.getText().toString());
                        d2 = Float.parseFloat(estatura.getText().toString());
                        nameT = nombre.getText().toString().trim();
                        imc = d1/(d2*d2);
                        DecimalFormat formato = new DecimalFormat("#.#");
                        String imcS = String.valueOf(formato.format(imc));

                        res.setText(nameT+" tu valor IMC es: ");
                        resNum.setText(imcS);
                        String imcIn = resNum.getText().toString().trim();

                        postImc(nameIn,weightIn,statureIn,imcIn);

                    }

                }
            });
        }
        else {
            btn_calc.setText("Actualizar");
            getImc(id);
            btn_calc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nameIn = nombre.getText().toString().trim();
                    String weightIn = peso.getText().toString().trim();
                    String statureIn = estatura.getText().toString().trim();

                    if (weightIn.isEmpty() && statureIn.isEmpty()){
                        Toast.makeText(AddImcActivity.this, "Hay campos Vacios", Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        float d1,d2,imc;
                        String nameT;
                        d1 = Float.parseFloat(peso.getText().toString());
                        d2 = Float.parseFloat(estatura.getText().toString());
                        nameT = nombre.getText().toString().trim();
                        imc = d1/(d2*d2);
                        DecimalFormat formato = new DecimalFormat("#.#");
                        String imcS = String.valueOf(formato.format(imc));

                        res.setText(nameT+" tu valor IMC es: ");
                        resNum.setText(imcS);
                        String imcIn = resNum.getText().toString().trim();

                        updateImc(nameIn,weightIn,statureIn,imcIn,id);

                    }
                }
            });
        }


    }

    private void updateImc(String nameIn, String ageIn, String statureIn, String imcIn, String id) {
        Map<String, Object> map = new HashMap<>();

        map.put("name", nameIn);
        map.put("weight", ageIn);
        map.put("stature",statureIn);
        map.put("IMC",imcIn);

        mfirestone.collection("IMC").document(id).update(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(getApplicationContext(), "Actualizado exitosamente", Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error en la actualización", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void postImc(String nameIn, String ageIn, String statureIn, String imcIn) {

        Map<String, Object> map = new HashMap<>();

        map.put("name", nameIn);
        map.put("weight", ageIn);
        map.put("stature",statureIn);
        map.put("IMC",imcIn);

        mfirestone.collection("IMC").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(), "Creado exitosamente", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error al ingresar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getImc(String id){
        mfirestone.collection("IMC").document(id).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String nameImc = documentSnapshot.getString("name");
                String weightImc = documentSnapshot.getString("weight");
                String statureImc = documentSnapshot.getString("stature");
                String IMCImc = documentSnapshot.getString("IMC");


                nombre.setText(nameImc);
                estatura.setText(statureImc);
                peso.setText(weightImc);
                res.setText(IMCImc);
                //resNum = (TextView) findViewById(R.id.txt_resIMCT2Id);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error al obetener los datos", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        //return super.onSupportNavigateUp();
        onBackPressed();
        return false;
    }

/*
    @Override
    public void onClick(View view) {
        //Toast.makeText(getApplicationContext(), "Se presiono el boton calcular", Toast.LENGTH_SHORT).show();
        float d1,d2,imc;
        String nameT;
        //nameT = nombre.getText();
        d1 = Float.parseFloat(edad.getText().toString());
        d2 = Float.parseFloat(estatura.getText().toString());
        imc = d2/(d1*d1);

        res.setText("Tu valor IMC es: "+Math.round(imc));
        Toast.makeText(getApplicationContext(), " tu valor IMC es: "+Math.round(imc), Toast.LENGTH_SHORT).show();
    }*/
}