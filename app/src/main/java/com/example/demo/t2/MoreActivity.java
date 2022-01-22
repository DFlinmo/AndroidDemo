package com.example.deomo.t2;

import android.content.Intent;
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
import com.example.deomo.t2.adapter.N_ListAdapter;
import com.example.deomo.t2.bean.N_List;
import com.google.gson.Gson;

import org.json.JSONObject;

public class MoreActivity extends AppCompatActivity {

    private ListView name_list;
    private N_ListAdapter n_listAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t2_moreservice);
        name_list = (ListView) findViewById(R.id.name_list);
        activity_list();
        name_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MoreActivity.this,"你点击了第"+(i+1)+"项",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MoreActivity.this, Subways.class);
                startActivity(intent);
            }
        });

    }

    private void activity_list(){
        String url = "http://124.93.196.45:10001/prod-api/api/activity/activity/list";
        RequestQueue rq = Volley.newRequestQueue(MoreActivity.this);
        JsonObjectRequest jor = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Name",response.toString());
                Gson gson = new Gson();
                N_List activity_list = gson.fromJson(response.toString(),N_List.class);
                n_listAdapter = new N_ListAdapter(MoreActivity.this, activity_list.getRows());
                name_list.setAdapter(n_listAdapter);
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
