package com.example.moviles.midtermprojectandroid;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bjulcavi on 19/05/2017.
 */

public class LogInRequest extends StringRequest {
    private static final String LOGIN_URL = "http://192.168.1.104/PHP/Login.php";
    private Map<String, String> params;

    public LogInRequest(String username, String email, String password, Response.Listener<String> listener){
        super(Method.POST, LOGIN_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("email", email);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}