package com.example.demo.Ts10;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.List;

public class Ts10_BusinessActivity extends AppCompatActivity {

    private int[] busiimg = {R.mipmap.supermarket,R.mipmap.clinic,R.mipmap.broadband};
    private String[] businame = {"家乐福超市","同仁馆诊所","小区宽带服务"};
    private String[] busiadver = {"开心购物家乐福","妙手厚德待四方客，仁方仁术仁爱天下","用户至上，用心服务，电话魅力，无限延伸"};

    private List<Ts10_Business> businesses = new ArrayList<Ts10_Business>();
    private Ts10_BusinessAdapter businessAdapter;

    private ListView businessList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ts10__business);

        //侧边返回
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        businessList = (ListView) findViewById(R.id.business_list);
        businessAdapter = new Ts10_BusinessAdapter(businesses,Ts10_BusinessActivity.this);
        businessList.setAdapter(businessAdapter);


        initDatabusiness();

//        listview点击事件
        businessList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //点击显示详情
                ListView listView = (ListView) adapterView;
                Intent intent = new Intent(Ts10_BusinessActivity.this,Ts10_businessDetail.class);
                intent.putExtra("businame",businame[i]);
                intent.putExtra("busiimg",busiimg[i]);
                System.out.println("businame[i]=="+businame[i]);
                startActivity(intent);
            }
        });
    }


    public void initDatabusiness(){
        for (int i=0;i<busiimg.length;i++){
            Ts10_Business ts10_business = new Ts10_Business(busiimg[i],businame[i],busiadver[i]);
            System.out.println("business["+i+"]"+busiimg[i]);
            businesses.add(ts10_business);
        }
        businessAdapter.notifyDataSetChanged();
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
