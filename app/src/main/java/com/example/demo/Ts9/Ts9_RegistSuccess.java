package com.example.demo.Ts9;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;

public class Ts9_RegistSuccess extends AppCompatActivity {

    private TextView regitname;
    private TextView rigistype;
    private TextView registime;
    private Button registsuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ts9__regist_success);

        //侧边返回
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        regitname = (TextView) findViewById(R.id.regitname);
        rigistype = (TextView) findViewById(R.id.rigistype);
        registime = (TextView) findViewById(R.id.registime);
        registsuccess = (Button) findViewById(R.id.registsuccess);

        SharedPreferences sharedPreferences = getSharedPreferences("regist",Ts9_RegistSuccess.MODE_PRIVATE);
        String type = sharedPreferences.getString("registtype","");
        System.out.println("name=="+type);
        regitname.setText("预约科室:"+sharedPreferences.getString("registname",""));
        registime.setText(sharedPreferences.getString("registtime",""));
        rigistype.setText("门诊类型：普通挂号");

        registsuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ts9_RegistSuccess.this, Ts9_BookPatient.class);
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
