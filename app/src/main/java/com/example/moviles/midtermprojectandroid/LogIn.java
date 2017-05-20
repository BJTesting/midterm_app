package com.example.moviles.midtermprojectandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LogIn extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        final EditText etUsernameEmail = (EditText) findViewById(R.id.usernameEmail);
        final EditText etPassword = (EditText) findViewById(R.id.passwordLogIn);
        final Button log_in = (Button) findViewById(R.id.log_in);
        final Button sign_up = (Button) findViewById(R.id.sign_up);
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUsernameEmail.getText().toString();
                final String email = etUsernameEmail.getText().toString();
                final String password = etPassword.getText().toString();
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Please complete all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    String usernameResponse = jsonResponse.getString("username");
                                    intent = new Intent(LogIn.this, Principal.class);
                                    intent.putExtra("username", usernameResponse);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LogIn.this);
                                    builder.setMessage("Login failed!")
                                            .setNegativeButton("Retry", null)
                                            .create()
                                            .show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    LogInRequest logInRequest = new LogInRequest(username,email,password,responseListener);
                    RequestQueue requestQueue = Volley.newRequestQueue(LogIn.this);
                    requestQueue.add(logInRequest);
                }
            }
        });
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LogIn.this,SignUp.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
