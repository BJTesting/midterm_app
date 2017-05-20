package com.example.moviles.midtermprojectandroid;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Informacion extends AppCompatActivity{

    Button btnGuardar;
    TextView NombreInfo, ApellidoInfo, Curso;
    EditText etNombre, etApellido, etCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


        NombreInfo=(TextView) findViewById(R.id.NombreInfo);
        ApellidoInfo=(TextView) findViewById(R.id.ApellidoInfo);
        etNombre= (EditText) findViewById(R.id.etNombreInfo);
        etApellido=(EditText) findViewById(R.id.etApellidoInfo);
        btnGuardar=(Button) findViewById(R.id.btnGuardar);


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String GuardarNom =null;
                String GuardarApell=null;
                String GuardarCur=null;

                GuardarNom= etNombre.getText().toString();
                GuardarApell= etApellido.getText().toString();
                GuardarCur= etCurso.getText().toString();

                etNombre.setText(GuardarNom);
                etApellido.setText(GuardarApell);
                etCurso.setText(GuardarCur);
            }
        });


    }

}
