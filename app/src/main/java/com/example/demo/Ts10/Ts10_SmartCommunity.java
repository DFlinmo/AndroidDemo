package com.example.demo.Ts10;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;

public class Ts10_SmartCommunity extends AppCompatActivity{

    private LinearLayout PropertyLayout;
    private LinearLayout DeliveryLayout;
    private LinearLayout NeighborsLayout;
    private LinearLayout BusinessLayout;
    private LinearLayout CarManagerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ts10_smart_community);


        //侧边返回
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        PropertyLayout = (LinearLayout) findViewById(R.id.Property_layout);
        DeliveryLayout = (LinearLayout) findViewById(R.id.Delivery_layout);
        NeighborsLayout = (LinearLayout) findViewById(R.id.Neighbors_layout);
        BusinessLayout = (LinearLayout) findViewById(R.id.Business_layout);
        CarManagerLayout = (LinearLayout) findViewById(R.id.CarManager_layout);


        PropertyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ts10_SmartCommunity.this, Ts10_PropertyActivity.class);
                startActivity(intent);
            }
        });

        DeliveryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ts10_SmartCommunity.this, Ts10_DeliveryActivity.class);
                startActivity(intent);
            }
        });

        NeighborsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ts10_SmartCommunity.this, Ts10_NeighborsActivity.class);
                startActivity(intent);
            }
        });
        BusinessLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ts10_SmartCommunity.this, Ts10_BusinessActivity.class);
                startActivity(intent);
            }
        });
        CarManagerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ts10_SmartCommunity.this, Ts10_CarManagerActivity.class);
                startActivity(intent);
            }
        });
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
