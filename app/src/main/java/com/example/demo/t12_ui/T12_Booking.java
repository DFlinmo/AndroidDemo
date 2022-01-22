package com.example.demo.t12_ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.demo.MyJsonObjectRequest_t12;
import com.example.demo.R;
import com.example.demo.t12_Bean.T12_Bus_Site_Info;
import com.example.demo.t12_adapter.BookingAdapter1;
import com.example.demo.t12_adapter.BookingAdapter2;
import com.example.demo.t12_adapter.BookingAdapter3;
import com.example.demo.t12_adapter.BookingAdapter4;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T12_Booking extends AppCompatActivity {
    private Button button2;
    private RecyclerView mList;
    Gson gson = new Gson();
    private List<T12_Bus_Site_Info> group_list = new ArrayList<>();
    private T12_Bus_Site_Info t12_bus_site_info;
    BookingAdapter1 adapter1;
    BookingAdapter2 adapter2 = new BookingAdapter2();
    BookingAdapter3 adapter3;
    BookingAdapter4 adapter4;
    private String pathName;
    private String time = null;
    private Button button3;
    private Map<String, String> map1 = new HashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t12_booking);
        button2 = this.findViewById(R.id.button2);
        mList = this.findViewById(R.id.t12_recycler_view);
        button3 = this.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(T12_Booking.this,T12_Order.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        busSite();
    }

    public void initListener() {
        adapter1.setOnItemClickListener(new BookingAdapter1.OnItemClickListener() {
            @Override
            public void onItemClick(int step, String name, String startName, String endName) {
                map1.put("startName", startName);
                map1.put("endName", endName);
                pathName = name;
                mList.setAdapter(adapter2);
                initListener();
            }

            @Override
            public void onItemBackClick(int backStep) {
                finish();
                initListener();
            }
        });
        adapter2.setOnItemClickListener(new BookingAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(int step, String str) {
                time = str;
                map1.put("time", time);
                adapter3 = new BookingAdapter3(map1);
                mList.setAdapter(adapter3);
                adapter3.setOnItemClickListener(new BookingAdapter3.OnItemClickListener() {
                    @Override
                    public void onItemBackClick(int backStep) {
                        mList.setAdapter(adapter2);
                        initListener();
                    }

                    @Override
                    public void onItemClick(int step, Map<String, String> map) {
                        adapter4 = new BookingAdapter4(map);
                        mList.setAdapter(adapter4);
                        adapter4.setOnItemClickListener(new BookingAdapter4.OnItemClickListener() {
                            @Override
                            public void onItemClick() {
                                submit(map);
                            }

                            @Override
                            public void onItemBackClick() {
                                mList.setAdapter(adapter3);
                            }
                        });
                    }
                });
                initListener();
            }

            @Override
            public void onItemBackClick(int backStep) {
                adapter1 = new BookingAdapter1(group_list);
                mList.setAdapter(adapter1);
                initListener();
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
                        t12_bus_site_info = gson.fromJson(item.toString(), T12_Bus_Site_Info.class);
                        group_list.add(t12_bus_site_info);
                    }
                    showList();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onErrorResponse: ", error.toString());
            }
        });
        rq.add(jor);
    }

    public void submit(Map<String,String> map){
        String url = "http://124.93.196.45:10001/prod-api/api/bus/order";
        JSONObject jo = new JSONObject();
        try {
            jo.put("start",map.get("startName"));
            jo.put("end",pathName.toString());
            jo.put("price","8");
            jo.put("path",map.get("endName"));
            jo.put("status",1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestQueue rq = Volley.newRequestQueue(this);
        MyJsonObjectRequest_t12 jor = new MyJsonObjectRequest_t12(url, jo, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                AlertDialog.Builder builder = new AlertDialog.Builder(T12_Booking.this);
                builder.setTitle("提交成功，跳转我的订单处支付");
                builder.setNegativeButton("取消",null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(T12_Booking.this,T12_Order.class);
                        intent.putExtra("time",map.get("time"));
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        rq.add(jor);
    }


    private void showList() {
        adapter1 = new BookingAdapter1(group_list);
        mList.setLayoutManager(new LinearLayoutManager(this));
        mList.setAdapter(adapter1);
        initListener();
    }


}