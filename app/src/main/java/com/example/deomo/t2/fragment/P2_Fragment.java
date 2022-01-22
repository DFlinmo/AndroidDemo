package com.example.deomo.t2.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
import com.google.gson.Gson;

import org.json.JSONObject;

public class P2_Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.t2_p2,container,false);
        return v;
    }
    private ListView service_list;
    private ArrayAdapter<String> myAdapter;
    private String[] service_name = {"停哪儿","城市地铁","智慧巴士","门诊预约","智慧交管","生活缴费","外卖订餐","找房子","看电影","找工作","活动管理","数据分析","更多"};



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        service();
        service_list = (ListView)view.findViewById(R.id.service_list);
        myAdapter = new ArrayAdapter<String>(P2_Fragment.this.getActivity(), android.R.layout.simple_list_item_1,service_name);
        //3.加载适配器
        service_list.setAdapter(myAdapter);

    }

    //获取全部服务
    private void service(){
        String url = "http://124.93.196.45:10001/prod-api/api/service/list";
        RequestQueue rq = Volley.newRequestQueue(P2_Fragment.this.getContext());
        JsonObjectRequest jor = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Service",response.toString());
                Gson gson = new Gson();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Service",error.toString());
            }
        });

        rq.add(jor);
    }
}
