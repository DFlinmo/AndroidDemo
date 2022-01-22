package com.example.demo.t12_ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.demo.MyJsonObjectRequest_t12;
import com.example.demo.R;
import com.example.demo.t12_Bean.T12_Order_Info;
import com.example.demo.t12_adapter.OrderAdapter;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class T12_Order extends AppCompatActivity {
    private RecyclerView recyclerView;
    private T12_Order_Info t12_order_info;
    private List<T12_Order_Info> mList = new ArrayList<>();
    private Gson gson = new Gson();
    private OrderAdapter adapter;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t12_order_activity);
        recyclerView = this.findViewById(R.id.t12_order_recycler_view);
        Intent intent = getIntent();
        String str = intent.getStringExtra("time");
        System.out.println(str);
        t12_order_query();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        button=this.findViewById(R.id.button23);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void t12_order_query(){
        String url = "http://124.93.196.45:10001/prod-api/api/bus/order/list";
        JSONObject jo = new JSONObject();
        RequestQueue rq = Volley.newRequestQueue(this);
        MyJsonObjectRequest_t12 jor = new MyJsonObjectRequest_t12(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray results = response.getJSONArray("rows");
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject item = results.getJSONObject(i);
                        t12_order_info = gson.fromJson(item.toString(),T12_Order_Info.class);
                        mList.add(t12_order_info);
                    }
                    showList();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        rq.add(jor);
    }

    private void showList() {
        adapter = new OrderAdapter(mList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}