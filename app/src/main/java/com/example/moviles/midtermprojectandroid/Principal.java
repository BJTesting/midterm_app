package com.example.moviles.midtermprojectandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
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
    }
}
