package com.example.demo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.demo.t12_Bean.T12_Bus_Site_Info;
import com.example.demo.t12_Bean.T12_parmsBean;
import com.example.demo.t12_adapter.RouteSituationAdapter;
import com.example.demo.t12_ui.T12_Booking;
import com.example.demo.t12_ui.T12_Order;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_t12 extends AppCompatActivity {
    private Button newRoute;
    private ExpandableListView expandableListView;
    private List<T12_Bus_Site_Info> group_list = new ArrayList<>();
    private List<List<List<T12_parmsBean>>> child_list = new ArrayList<>();
    private List<List<T12_parmsBean>> child11_list = new ArrayList<>();
    private List<List<T12_parmsBean>> child12_list = new ArrayList<>();
    private List<List<T12_parmsBean>> child13_list = new ArrayList<>();
    private List<List<T12_parmsBean>> child14_list = new ArrayList<>();
    private List<T12_parmsBean> child2_list = new ArrayList<>();
    private List<T12_parmsBean> child3_list = new ArrayList<>();
    private List<T12_parmsBean> child4_list = new ArrayList<>();
    private List<T12_parmsBean> child5_list = new ArrayList<>();
    private List<T12_parmsBean> child6_list = new ArrayList<>();
    private List<T12_parmsBean> child7_list = new ArrayList<>();
    private List<T12_parmsBean> child8_list = new ArrayList<>();
    private T12_Bus_Site_Info t12_bus_site_info;
    private T12_parmsBean t12_parmsBean;
    private RouteSituationAdapter adapter;
    Gson gson = new Gson();
    private Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_t12);
        newRoute = (Button) findViewById(R.id.new_route);
        button3 = (Button) findViewById(R.id.button3);
        expandableListView = (ExpandableListView) this.findViewById(R.id.expanfListView);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        busSite();

        newRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity_t12.this, T12_Booking.class));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_t12.this, T12_Order.class);
                startActivity(intent);
            }
        });
 
    }


    public void busSite() {
        String url = "http://124.93.196.45:10001/prod-api/api/bus/line/list";
        JSONObject jo = new JSONObject();
        RequestQueue rq = Volley.newRequestQueue(this);
        JsonObjectRequest jor = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray results = response.getJSONArray("rows");
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject item = results.getJSONObject(i);
                        t12_bus_site_info = gson.fromJson(item.toString(),T12_Bus_Site_Info.class);
                        group_list.add(t12_bus_site_info);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                busRoute();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onErrorResponse: ", error.toString());
            }
        });
        rq.add(jor);
    }

    public void busRoute(){
        String url = "http://124.93.196.45:10001/prod-api/api/bus/stop/list";
        JSONObject jo = new JSONObject();
        RequestQueue rq = Volley.newRequestQueue(this);
        JsonObjectRequest jor = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response.toString());
                try {
                    JSONArray results = response.getJSONArray("rows");
                    System.out.println(results);
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject item = results.getJSONObject(i);
                        if (item.get("linesId").equals(1)){
                            t12_parmsBean = gson.fromJson(item.toString(),T12_parmsBean.class);
                            child2_list.add(t12_parmsBean);
                        }else if (item.get("linesId").equals(2)){
                            t12_parmsBean = gson.fromJson(item.toString(),T12_parmsBean.class);
                            child3_list.add(t12_parmsBean);
                        }else if (item.get("linesId").equals(3)){
                            t12_parmsBean = gson.fromJson(item.toString(),T12_parmsBean.class);
                            if (child4_list.size() != 4) {
                                child4_list.add(t12_parmsBean);
                            }else if(child5_list.size() != 4){
                                child5_list.add(t12_parmsBean);
                            }else if (child6_list.size() != 4){
                                child6_list.add(t12_parmsBean);
                            }

                        }else if (item.get("linesId").equals(4)){
                            t12_parmsBean = gson.fromJson(item.toString(),T12_parmsBean.class);
                            if (child7_list.size() != 4) {
                                child7_list.add(t12_parmsBean);
                            }else if(child8_list.size() != 4){
                                child8_list.add(t12_parmsBean);
                            }
                        }
                    }
                    child11_list.add(child2_list);
                    child12_list.add(child3_list);
                    child13_list.add(child4_list);
                    child13_list.add(child5_list);
                    child13_list.add(child6_list);
                    child14_list.add(child7_list);
                    child14_list.add(child8_list);
                    child_list.add(child11_list);
                    child_list.add(child12_list);
                    child_list.add(child13_list);
                    child_list.add(child14_list);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                showList();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onErrorResponse: ", error.toString());
            }
        });
        rq.add(jor);
    }

    private void showList() {
        adapter = new RouteSituationAdapter(group_list,child_list, MainActivity_t12.this);
        expandableListView.setAdapter(adapter);

    }
}