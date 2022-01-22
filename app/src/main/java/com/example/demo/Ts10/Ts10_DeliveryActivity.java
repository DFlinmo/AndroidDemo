package com.example.demo.Ts10;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.List;

public class Ts10_DeliveryActivity extends AppCompatActivity {

    private String[] dename = {"王望","王望","王望"};
    private String[] dewaybillNumber = {"78245338329949","462155420468453","78244986637023"};
    private String[] depickupCode = {"4","2","8"};
    private String[] detelephone = {"4325","3242","6787"};

    private List<Ts10_Delivery> deliveries = new ArrayList<Ts10_Delivery>();
    private Ts10_DeliveryAdapter deliveryAdapter;

    private ListView deliveryList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ts10__delivery);
//侧边返回
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        deliveryList = (ListView) findViewById(R.id.delivery_list);
        deliveryAdapter = new Ts10_DeliveryAdapter(deliveries, Ts10_DeliveryActivity.this);
        deliveryList.setAdapter(deliveryAdapter);

        initDatadelivlist();

    }
    //初始化数据
    public void initDatadelivlist() {
        for (int i = 0; i < dename.length; i++) {
            Ts10_Delivery ts10_delivery = new Ts10_Delivery(dename[i],depickupCode[i],detelephone[i],dewaybillNumber[i]);
            System.out.println("dename[" + i + "]==" + dename[i]);
            deliveries.add(ts10_delivery);
        }
        deliveryAdapter.notifyDataSetChanged(); //通知适配器数据改变
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
