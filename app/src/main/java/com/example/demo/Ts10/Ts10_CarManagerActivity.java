package com.example.demo.Ts10;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.List;

public class Ts10_CarManagerActivity extends AppCompatActivity {

    private ListView managerinfo;
    private Button add;

    private EditText carnum;
    private EditText parkingSpace;
    private EditText parkingCardNumber;
    private EditText ownerSName;
    private EditText ownersTel;
    private EditText residentName;
    private EditText address;
    private TextView textView8;
    private Button editor;
    private Button save;

    private String[] carnums = {"53254542535"};
    private String[] parkingSpaces = {"23423532"};
    private String[] parkingCardNumbers = {"45353453"};
    private String[] ownerSNames = {"王笑笑"};
    private String[] ownersTels = {"14214323253"};
    private String[] residentNames = {"王笑笑"};
    private String[] addresses = {"xx市"};

    private List<Ts10_Carmanager> carmanagers = new ArrayList<Ts10_Carmanager>();
    private Ts10_CarmanagerAdapter carmanagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ts10__car_manager);

        //侧边返回
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        add = (Button) findViewById(R.id.add);
        managerinfo = (ListView) findViewById(R.id.managerinfo);
        carmanagerAdapter = new Ts10_CarmanagerAdapter(carmanagers, Ts10_CarManagerActivity.this);
        managerinfo.setAdapter(carmanagerAdapter);


        initDatacarlist();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                geteditor("添加车辆信息");
            }
        });
    }




    public void geteditor(String title){
        AlertDialog.Builder querydialog = new AlertDialog.Builder(Ts10_CarManagerActivity.this);
        View dialogView = LayoutInflater.from(Ts10_CarManagerActivity.this).inflate(R.layout.ts10_carmanager_dialog,null);

        carnum = (EditText) findViewById(R.id.carnum);
        parkingSpace = (EditText) findViewById(R.id.parkingSpace);
        parkingCardNumber = (EditText) findViewById(R.id.parkingCardNumber);
        ownerSName = (EditText) findViewById(R.id.ownerSName);
        ownersTel = (EditText) findViewById(R.id.ownersTel);
        residentName = (EditText) findViewById(R.id.residentName);
        address = (EditText) findViewById(R.id.address);

        querydialog.setTitle(title);
        querydialog.setView(dialogView);
        querydialog.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        querydialog.setNegativeButton("保存", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        querydialog.show();

    }


    //初始化数据
    public void initDatacarlist() {
        for (int i = 0; i < carnums.length; i++) {
            Ts10_Carmanager ts10_carmanager = new Ts10_Carmanager(carnums[i],parkingSpaces[i],parkingCardNumbers[i],ownerSNames[i],ownersTels[i],residentNames[i],addresses[i]);
            System.out.println("carnum[" + i + "]==" + carnums[i]);
            carmanagers.add(ts10_carmanager);
        }
        carmanagerAdapter.notifyDataSetChanged(); //通知适配器数据改变
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
