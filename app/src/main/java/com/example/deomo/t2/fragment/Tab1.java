package com.example.deomo.t2.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.deomo.R;
import com.example.deomo.t2.adapter.MyNewsAdapter;
import com.example.deomo.t2.bean.PressList;
import com.google.gson.Gson;

import org.json.JSONObject;

public class Tab1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.t2_tab1,container,false);
        return v;
    }

    private MyNewsAdapter myNewsAdapter;
    private ListView listView;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView)view.findViewById(R.id.listView);
        newlists();

    }

    //    查询新闻列表
    private void newlists(){
        String url = "http://124.93.196.45:10001/prod-api/press/press/list";

        RequestQueue rq = Volley.newRequestQueue(Tab1.this.getContext());
        JsonObjectRequest jor = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("List",response.toString());
                Gson gson = new Gson();
                PressList pressList = gson.fromJson(response.toString(),PressList.class);
                myNewsAdapter = new MyNewsAdapter(pressList.getRows(),Tab1.this.getContext());
                listView.setAdapter(myNewsAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("List",error.toString());
            }
        });
        rq.add(jor);
    }
}

