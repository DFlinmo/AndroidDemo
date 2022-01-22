package com.example.demo.Ts9;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.demo.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Ts9_AvailableDepart extends AppCompatActivity {


    List<Integer> lideptid = new ArrayList<Integer>();
    List<String> lidepttype = new ArrayList<String>();
    List<String> lideptname = new ArrayList<String>();
    List<String> lideptcost = new ArrayList<String>();

    //    Ts9_DepartmentData Deta;
    private ListView avadpt;

    JSONArray Depart;

    private List<Ts9_Department> departments = new ArrayList<Ts9_Department>();
    private Ts9_DepartmentAdapter deptAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ts9_available_depart);

        //侧边返回
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        avadpt = (ListView) findViewById(R.id.avadpt);
        deptAdapter = new Ts9_DepartmentAdapter(departments, Ts9_AvailableDepart.this);
        avadpt.setAdapter(deptAdapter);

        setdepartment();

    }

    public void setdepartment() {
        String url = "http://124.93.196.45:10001/prod-api/api/hospital/category/list";
        RequestQueue rq = Volley.newRequestQueue(Ts9_AvailableDepart.this);
        JsonObjectRequest jor = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("onResponse", response.toString());
                try {
                    Depart = response.getJSONArray("rows");
                    System.out.println("Depart==" + Depart);
                    for (int i = 0; i < Depart.length(); i++) {
                        lideptid.add((Integer) Depart.getJSONObject(i).get("id"));
                        lidepttype.add(String.valueOf(Depart.getJSONObject(i).get("type")));
                        lideptname.add(String.valueOf(Depart.getJSONObject(i).get("categoryName")));
                        lideptcost.add(String.valueOf(Depart.getJSONObject(i).get("money")));
//                        //listview点击显示详情
                        avadpt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int j, long l) {
                                Intent intent = new Intent(Ts9_AvailableDepart.this, Ts9_Registration.class);
                                startActivity(intent);
                                //全局传值
                                SharedPreferences sps = getSharedPreferences("Deta", Ts9_AvailableDepart.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sps.edit();
                                editor.putString("deptname", lideptname.get(j));
                                System.out.println("deptname==="+lideptname.get(j));
                                editor.commit();
                            }
                        });
                        System.out.println("Depart==" + Depart);
                        System.out.println("lidepttype==" + lidepttype);
                        System.out.println("lideptid==" + lideptid);
                        System.out.println("lideptcost==" + lideptcost);
                        System.out.println("lideptname==" + lideptname);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                initDatahsplist();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onResponse", error.toString());
            }
        });
        rq.add(jor);
    }

    //初始化数据
    public void initDatahsplist() {
        for (int i = 0; i < lideptid.size(); i++) {
            Ts9_Department ts9_department = new Ts9_Department(lideptid.get(i), lidepttype.get(i), lideptname.get(i), lideptcost.get(i));
            System.out.println("liHspname.get(" + i + ")==" + lideptname.get(i));
            departments.add(ts9_department);
        }
        deptAdapter.notifyDataSetChanged(); //通知适配器数据改变
    }

    //侧边返回方法重写
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
