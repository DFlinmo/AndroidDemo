package com.sfsq.demo17.T17ui;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MyJsonObjectRequest extends JsonObjectRequest {
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6IjEwOWQ0OTZiLTQ0ZWQtNDcxYy1iZGEzLThlMWExN2RiNWMwZCJ9.NTt_OhvEN2wWd_jlDUrfjub7fq150pgygBBMt5Us7XOXq3UBi0D6d7QDTa0UXtn727r_a86iD7vimtYrbVhIJQ");
//        headers.put("Charset", "UTF-8");
        return headers;
    }

    public MyJsonObjectRequest(int method, String url, @Nullable JSONObject jsonRequest, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    public MyJsonObjectRequest(String url, @Nullable JSONObject jsonRequest, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(url, jsonRequest, listener, errorListener);
    }

}


