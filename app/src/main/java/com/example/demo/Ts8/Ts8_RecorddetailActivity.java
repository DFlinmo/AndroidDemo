package com.example.demo.Ts8;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.demo.R;
import com.google.gson.Gson;

import org.json.JSONObject;

public class Ts8_RecorddetailActivity extends AppCompatActivity {

    private TextView viotime;
    private TextView vioarea;
    private TextView viobeh;
    private TextView punum;
    private TextView puscore;
    private TextView pumoney;

    RecordList recordList2;
    String carid;
    String carnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ts8_viodetail);

        //侧边返回
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        viotime = (TextView) findViewById(R.id.viotime);
        vioarea = (TextView) findViewById(R.id.vioarea);
        viobeh = (TextView) findViewById(R.id.viobeh);
        punum = (TextView) findViewById(R.id.punum);
        puscore = (TextView) findViewById(R.id.puscore);
        pumoney = (TextView) findViewById(R.id.pumoney);

        Bundle bundle = getIntent().getExtras();
        carid = bundle.getString("carid");
        vioarea.setText(carid);
        System.out.println("carid=="+carid);

        recorddetail();

    }

    //获取违章记录详情
    public void recorddetail(){
        String url="http://192.168.202.25:5000/api/detailvio/list";
        JSONObject jr = new JSONObject();

        RequestQueue rq = Volley.newRequestQueue(Ts8_RecorddetailActivity.this);
        JsonObjectRequest jor = new JsonObjectRequest(url, jr, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("onResponse",response.toString());
                Gson gson = new Gson();
                recordList2 = gson.fromJson(response.toString(), RecordList.class);
                for (int i = 0; i < recordList2.getData().getList().size(); i++) {
                    RecordList.DataBean.ListBean b =   recordList2.getData().getList().get(i);
                    if(carid.equals(b.getCarnum())){
                        viotime.setText("违法时间\t\t"+b.getPtime());
                        vioarea.setText("违法地点\t\t"+b.getParea());
                        viobeh.setText("违法行为\t\t"+b.getPhands());
                        punum.setText("通知书号\t\t"+b.getPnumber());
                        puscore.setText("违章计分\t\t"+b.getPsocre());
                        pumoney.setText("罚款金额\t\t"+b.getPmoney());
                    }
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
