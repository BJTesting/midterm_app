package com.example.moviles.midtermprojectandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Principal extends AppCompatActivity implements View.OnClickListener {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        final TextView welcome = (TextView) findViewById(R.id.Bienvenida);
        intent = getIntent();
        String username = intent.getStringExtra("username");
        String aux = welcome.getText().toString();
        welcome.setText(aux+", "+username);

        ImageButton btnDonar= (ImageButton) findViewById(R.id.Dona);
        btnDonar.setOnClickListener(this);

        ImageButton btnInfo= (ImageButton) findViewById(R.id.Informacion);
        btnInfo.setOnClickListener(this);

        ImageButton btnCrea= (ImageButton) findViewById(R.id.Crea);
        btnCrea.setOnClickListener(this);

        ImageButton btnPart= (ImageButton) findViewById(R.id.Inscribir);
        btnPart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Dona:
                Intent intent= new Intent(Principal.this,Dona.class);
                startActivity(intent);
             break;
            case R.id.Informacion:
                Intent intent1=new Intent(Principal.this,Informacion.class);
                startActivity(intent1);
             break;
            case R.id.Crea:
                Intent intent2 = new Intent(Principal.this,Crea.class);
                startActivity(intent2);
             break;
            case R.id.Inscribir:
                Intent intent3= new Intent(Principal.this,Participa.class);
                startActivity(intent3);
             break;
        }







    }

}
