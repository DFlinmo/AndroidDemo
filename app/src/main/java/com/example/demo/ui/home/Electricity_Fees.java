package com.example.demo.ui.home;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.demo.MyJsonObjectRequest_t13;
import com.example.demo.R;
import com.example.demo.ui.home.Bean.FeiYongBean;
import com.example.demo.ui.home.adapter.FeiYongAdapter;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Electricity_Fees extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Gson gson = new Gson();
    private FeiYongBean feiYongBean;
    private FeiYongAdapter adapter;

    private String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_fees);
        recyclerView = this.findViewById(R.id.electricity_recycler_view);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        Intent intent=getIntent();
        //通过这个标签得到之前的字符串
        type = intent.getStringExtra("params");
        querySelf();
    }

    public void querySelf(){
        String url = "http://124.93.196.45:10001/prod-api/api/common/user/getInfo";
        JSONObject jo = new JSONObject();
        RequestQueue rq = Volley.newRequestQueue(this);
        MyJsonObjectRequest_t13 jor = new MyJsonObjectRequest_t13(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject item = response.getJSONObject("user");
                    String idCard = item.getString("idCard");
                    String balance = item.getString("balance");
                    if ("electricity".equals(type)){
                        System.out.println("--------------------");
                       queryElectricity(idCard,balance);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });
        rq.add(jor);
    }

    public void queryElectricity(String idCard,String balance){
        String url = "http://124.93.196.45:10001/prod-api/api/living/account/list?idCard=210113199808242137&categoryId=2";
        JSONObject jo = new JSONObject();
        RequestQueue rq = Volley.newRequestQueue(this);
        MyJsonObjectRequest_t13 jor = new MyJsonObjectRequest_t13(url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray results = response.getJSONArray("data");
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject item = results.getJSONObject(i);
                        feiYongBean = gson.fromJson(item.toString(),FeiYongBean.class);
                        feiYongBean.setBalance(balance);
                    }
                    showList(feiYongBean);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                showList(feiYongBean);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        rq.add(jor);
    }

    private void showList(FeiYongBean feiYongBean) {
        adapter = new FeiYongAdapter(feiYongBean);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}