package com.example.demo.Ts10;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.List;

public class Ts10_PropertyActivity extends AppCompatActivity {

    private String[] diviname = {"物业服务中心","停车位服务中心","24小时值班热线","报修电话","便民服务"};
    private String[] divitel = {"123456","234523","077456","472232","077856"};

    private List<Ts10_property> properties = new ArrayList<Ts10_property>();
    private Ts10_PropertyAdapter propertyAdapter;

    private ListView propertyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ts10_property);

        //侧边返回
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        propertyList = (ListView) findViewById(R.id.property_list);
        propertyAdapter = new Ts10_PropertyAdapter(properties, Ts10_PropertyActivity.this);
        propertyList.setAdapter(propertyAdapter);

        initDataprolist();
    }
    //初始化数据
    public void initDataprolist() {
        for (int i = 0; i < diviname.length; i++) {
            Ts10_property ts10_property = new Ts10_property(divitel[i],diviname[i]);
            System.out.println("diviname[" + i + "]==" + diviname[i]);
            properties.add(ts10_property);
        }
        propertyAdapter.notifyDataSetChanged(); //通知适配器数据改变
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
