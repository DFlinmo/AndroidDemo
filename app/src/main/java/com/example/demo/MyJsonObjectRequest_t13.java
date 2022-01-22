package com.example.demo;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MyJsonObjectRequest_t13 extends JsonObjectRequest {
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {



        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6IjdhYWRiN2E1LTExMmQtNDU0YS1iNzkxLTA5OWQyNDNkMzYyMSJ9.6yng8neoBycCtLYkddb0l8UHmmzEVhtLDgTwm0Tk3GHAqW2TCVRO6RaYP8z_8DTluKZlu-uktKUQSDN3wkWc4Q");
        headers.put("Charset", "UTF-8");
        headers.put("Content-Type", "application/x-javascript");
        return headers;
    }

    public MyJsonObjectRequest_t13(int method, String url, @Nullable JSONObject jsonRequest, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    public MyJsonObjectRequest_t13(String url, @Nullable JSONObject jsonRequest, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(url, jsonRequest, listener, errorListener);
    }
}

