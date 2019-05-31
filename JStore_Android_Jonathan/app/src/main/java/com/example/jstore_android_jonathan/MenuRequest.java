package com.example.jstore_android_jonathan;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

public class MenuRequest extends StringRequest {
    private static final String Regis_URL = "http://10.0.2.2:8080/items";
    private Map<String, String> params;

    public MenuRequest(
            Response.Listener<String>listener){
        super(Method.GET, Regis_URL, listener, null);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}