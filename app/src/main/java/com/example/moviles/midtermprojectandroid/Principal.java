package com.example.moviles.midtermprojectandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

public class Principal extends AppCompatActivity{
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
        ImageButton btnInfo= (ImageButton) findViewById(R.id.Informacion);
        ImageButton btnCrea= (ImageButton) findViewById(R.id.Crea);
        ImageButton btnPart= (ImageButton) findViewById(R.id.Inscribir);

        btnDonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Principal.this, Dona.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Principal.this, Informacion.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btnCrea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Principal.this, Crea.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btnPart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Principal.this, Participa.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        intent = new Intent(Principal.this,LogIn.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
