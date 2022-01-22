package com.example.deomo.t2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.example.deomo.R;
import com.example.deomo.t2.adapter.ShopAdapter;
import com.example.deomo.t2.bean.Shop;
import com.google.gson.Gson;

import org.json.JSONObject;

public class Waimai extends AppCompatActivity {

    private ListView shop_list;
    private ShopAdapter shopAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t2_show4);
        shop_list = findViewById(R.id.shop_list);
        shop();
        shop_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Waimai.this,"你点击这家店",Toast.LENGTH_SHORT).show();

            }
        });
    }

//    商家列表信息
    private void shop(){
        String url = "http://124.93.196.45:10001/prod-api/api/takeout/seller/list";
        RequestQueue rq = Volley.newRequestQueue(Waimai.this);
        JsonObjectRequest jor = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Name",response.toString());
                Gson gson = new Gson();
                Shop shop = gson.fromJson(response.toString(),Shop.class);
                shopAdapter = new ShopAdapter(Waimai.this, shop.getRows());
                shop_list.setAdapter(shopAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("NesList",error.toString());
            }
        });

        rq.add(jor);

    }
}
