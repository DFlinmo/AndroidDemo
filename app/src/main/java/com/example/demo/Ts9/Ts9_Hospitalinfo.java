package com.example.demo.Ts9;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

public class Ts9_Hospitalinfo extends AppCompatActivity {

    private ImageView hspimg;
    private TextView hspinfo;
    private Button bookpatient;

    String hspname;
//    Ts9_hospitaldata ts2_hspinfo;
    JSONArray ts2_hspinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ts9__hospitalinfo);

        //侧边返回
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        hspimg = (ImageView) findViewById(R.id.hspimg);
        hspinfo = (TextView) findViewById(R.id.hspinfo);
        bookpatient = (Button) findViewById(R.id.bookpatient);

        Bundle bundle = getIntent().getExtras();
        hspname = bundle.getString("hspname");
        System.out.println("hspname=="+hspname);
        sethspinfo();

        bookpatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ts9_Hospitalinfo.this, Ts9_PatientCard.class);
                startActivity(intent);
            }
        });

    }
    public void sethspinfo(){
    String url="http://124.93.196.45:10001/prod-api/api/hospital/hospital/list";
    RequestQueue rq = Volley.newRequestQueue(Ts9_Hospitalinfo.this);
    JsonObjectRequest jor = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            try {
                ts2_hspinfo = response.getJSONArray("rows");
                System.out.println("ts2_hspinfo=="+ts2_hspinfo);

                for (int i =0 ;i<ts2_hspinfo.length();i++){
                    if (hspname.equals(ts2_hspinfo.getJSONObject(i).getString("hospitalName"))){
                        hspinfo.setText("\t\t\n"+ts2_hspinfo.getJSONObject(i).getString("hospitalName")+"\n\t\t"+"\n\t\t"+ts2_hspinfo.getJSONObject(i).getString("brief")+"\n\t\t\n");
                        }
                    }
                System.out.println("hspinfo=="+hspinfo);
            } catch (JSONException e) {
                e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onResponse",error.toString());
            }
        });
        rq.add(jor);
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
