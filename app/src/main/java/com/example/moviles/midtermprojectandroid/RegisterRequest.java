package com.example.moviles.midtermprojectandroid;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bjulcavi on 19/05/2017.
 */

public class RegisterRequest extends StringRequest{
    private static final String REGISTER_URL = "http://192.168.1.104/PHP/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String username, String email, String password, Response.Listener<String> listener){
        super(Method.POST, REGISTER_URL, listener, null);
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