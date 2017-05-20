package com.example.moviles.midtermprojectandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Principal extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ImageButton btnDonar= (ImageButton) findViewById(R.id.Dona);
        btnDonar.setOnClickListener(this);

        ImageButton btnInfo= (ImageButton) findViewById(R.id.Informacion);
        btnInfo.setOnClickListener(this);

        ImageButton btnCrea= (ImageButton) findViewById(R.id.Crea);
        btnInfo.setOnClickListener(this);

        ImageButton btnPart= (ImageButton) findViewById(R.id.Inscribir);
        btnInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent= new Intent(Principal.this,Dona.class);
        startActivity(intent);

        Intent intent1=new Intent(Principal.this,Informacion.class);
        startActivity(intent1);

        Intent intent2 = new Intent(Principal.this,Crea.class);
        startActivity(intent2);

        Intent intent3= new Intent(Principal.this,Participa.class);
        startActivity(intent3);
    }


}
