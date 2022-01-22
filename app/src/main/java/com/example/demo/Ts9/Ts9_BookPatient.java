package com.example.demo.Ts9;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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

public class Ts9_BookPatient extends AppCompatActivity {

    List<String> liHsplogo = new ArrayList<String>();    //获取违章时间
    List<String> liHspname = new ArrayList<String>();    //获取违章车牌号
    List<String> liHspstar = new ArrayList<String>();    //获取违章地点


    private EditText search;
    private Button Tosearch;
    private ListView hsplist;

    private List<Ts9_hospital> hospitals = new ArrayList<Ts9_hospital>();
    private Ts9_hospitalAdapter hspAdapter;
    JSONArray hospitaldata;
    Ts9_hospitaldata ts9_hospitaldata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ts9activity_book_patient);

        //侧边返回
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        hsplist = (ListView) findViewById(R.id.hsplist);
        hspAdapter = new Ts9_hospitalAdapter(hospitals, Ts9_BookPatient.this);
        hsplist.setAdapter(hspAdapter);

        search = (EditText) findViewById(R.id.search);
        Tosearch = (Button) findViewById(R.id.Tosearch);
        sethspdetail();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ts9_BookPatient.this, Ts9_QueryHospital.class);
                startActivity(intent);
            }
        });

        Tosearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ts9_BookPatient.this, Ts9_QueryHospital.class);
                startActivity(intent);
            }
        });
    }

    public void sethspdetail() {
        String url = "http://124.93.196.45:10001/prod-api/api/hospital/hospital/list";
        RequestQueue rq = Volley.newRequestQueue(Ts9_BookPatient.this);
        JsonObjectRequest jor = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("onResponse", response.toString());
                try {
                    hospitaldata = response.getJSONArray("rows");
                    System.out.println("ts2_hspinfo==" + hospitaldata);
                    for (int i = 0; i < hospitaldata.length(); i++) {
                        liHsplogo.add(hospitaldata.getJSONObject(i).getString("imgUrl"));
                        liHspname.add(hospitaldata.getJSONObject(i).getString("hospitalName"));
                        liHspstar.add(hospitaldata.getJSONObject(i).getString("level"));
                    }
                    System.out.println("liHsplogo==" + liHsplogo);
                    System.out.println("liHspname==" + liHspname);
                    System.out.println("liHspstar==" + liHspstar);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                hsplist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int j, long l) {
                        Intent intent = new Intent(Ts9_BookPatient.this, Ts9_Hospitalinfo.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("hspname", liHspname.get(j));
                        System.out.println("getHspname()==" + liHspname.get(j));
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
                initDatahsplist();
            }
//                }
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
        String s = String.valueOf(search.getText());
        for (int i = 0; i < liHsplogo.size(); i++) {
            Ts9_hospital ts9_hospital = new Ts9_hospital(liHsplogo.get(i), liHspname.get(i), liHspstar.get(i));
            System.out.println("liHspname.get(" + i + ")==" + liHspname.get(i));
            hospitals.add(ts9_hospital);
        }
        hspAdapter.notifyDataSetChanged(); //通知适配器数据改变
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


