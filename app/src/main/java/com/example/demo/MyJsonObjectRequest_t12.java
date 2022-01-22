package com.example.demo;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MyJsonObjectRequest_t12 extends JsonObjectRequest {
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6ImQxODAwYjVlLWYwODctNDVmOC1iZmIyLWJkMTNhZDRmZDQzZSJ9.P5fI0rVQV4DdN1T9NjIjKWZIc-LUt537HHKGHecYVLjBmroyb4xNcKYs5jjhbrdWMxUUPpC-9-wjtHHIgwPfwg");
        headers.put("Charset", "UTF-8");
        headers.put("Content-Type", "application/json");
        return headers;
    }

    public MyJsonObjectRequest_t12(int method, String url, @Nullable JSONObject jsonRequest, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    public MyJsonObjectRequest_t12(String url, @Nullable JSONObject jsonRequest, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(url, jsonRequest, listener, errorListener);
    }
}


