package com.example.demo.Ts9;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.demo.R;
import com.google.gson.Gson;

import org.json.JSONObject;

public class Ts9_PatientCard extends AppCompatActivity {
    private ConstraintLayout ptinfo;
    private TextView ptname;
    private TextView ptsex;
    private TextView ptbirthday;
    private TextView pttel;
    private TextView ptiacard;
    private TextView ptadr;
    private TextView todepartment;

    private TextView etname;
    private TextView etsex;
    private TextView etbirthday;
    private TextView ettel;
    private TextView etiacard;
    private TextView etadr;

    private EditText editname;
    private EditText editsex;
    private EditText editbirth;
    private EditText edittel;
    private EditText editid;
    private EditText editadr;

    private ConstraintLayout etinfo;
    Ts9_patientinfodata patientinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ts9_activity_patient_card);

        //侧边返回
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        ptinfo = (ConstraintLayout) findViewById(R.id.ptinfo);
        etinfo = (ConstraintLayout) findViewById(R.id.etinfo);

        ptname = (TextView) findViewById(R.id.ptname);
        ptsex = (TextView) findViewById(R.id.ptsex);
        ptbirthday = (TextView) findViewById(R.id.ptbirthday);
        pttel = (TextView) findViewById(R.id.pttel);
        ptiacard = (TextView) findViewById(R.id.ptiacard);
        ptadr = (TextView) findViewById(R.id.ptadr);

        etname = (TextView) findViewById(R.id.ptname);
        etsex = (TextView) findViewById(R.id.ptsex);
        etbirthday = (TextView) findViewById(R.id.ptbirthday);
        ettel = (TextView) findViewById(R.id.pttel);
        etiacard = (TextView) findViewById(R.id.ptiacard);
        etadr = (TextView) findViewById(R.id.ptadr);

        todepartment = (TextView) findViewById(R.id.todepartment);
        todepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ts9_PatientCard.this, Ts9_AvailableDepart.class);
                startActivity(intent);
            }
        });

        setpatientinfo();

        etinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adddialog();
            }
        });
    }

    public void adddialog(){
        AlertDialog.Builder carddialog = new AlertDialog.Builder(Ts9_PatientCard.this);

        final View dialogView = LayoutInflater.from(Ts9_PatientCard.this) .inflate(R.layout.ts9_addcard,null);

        editname = (EditText) dialogView.findViewById(R.id.editname);
        editsex = (EditText) dialogView.findViewById(R.id.editsex);
        editbirth = (EditText) dialogView.findViewById(R.id.editbirth);
        edittel = (EditText) dialogView.findViewById(R.id.edittel);
        editid = (EditText) dialogView.findViewById(R.id.editid);
        editadr = (EditText) dialogView.findViewById(R.id.editadr);

        carddialog.setTitle("新增就诊人卡片");
        carddialog.setView(dialogView);
        carddialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getpatientadd();
                Toast.makeText(Ts9_PatientCard.this,"保存成功",Toast.LENGTH_LONG).show();
            }
        });
        carddialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Ts9_PatientCard.this,"操作取消",Toast.LENGTH_SHORT).show();
            }
        });
        carddialog.show();

    }

    public void getpatientadd(){
        if(editname.getText().toString() == null){
            Toast.makeText(Ts9_PatientCard.this,"姓名不能为空",Toast.LENGTH_SHORT).show();
        }else if(editbirth.getText().toString() == null){
            Toast.makeText(Ts9_PatientCard.this,"请输入出生日期",Toast.LENGTH_SHORT).show();
        }else if(editid.getText().toString() == null){
            Toast.makeText(Ts9_PatientCard.this,"身份证号码不能为空",Toast.LENGTH_SHORT).show();
        }else if(edittel.getText().toString() == null){
            Toast.makeText(Ts9_PatientCard.this,"联系方式不能为空",Toast.LENGTH_SHORT).show();
        }else if(editadr.getText().toString() == null){
            Toast.makeText(Ts9_PatientCard.this,"通讯地址不能为空！",Toast.LENGTH_SHORT).show();
        }else if(editsex.getText().toString() == null){
            Toast.makeText(Ts9_PatientCard.this,"请输入性别",Toast.LENGTH_SHORT).show();
        }else {
            etname.setText("*姓名："+editname.getText().toString());
            String etname = editname.getText().toString();
            System.out.println(etname);
            etsex.setText("*性别："+editsex.getText().toString());
            etbirthday.setText("*出生日期："+editbirth.getText().toString());
            ettel.setText("*联系方式："+edittel.getText().toString());
            etiacard.setText("*身份证号码："+editid.getText().toString());
            etadr.setText("通讯地址："+editadr.getText().toString());
        }
    }

    //显示通过读取个人中心的用户信息自动生成的就诊人卡片
    public void setpatientinfo(){
        String url="http://192.168.202.25:5000/api/bookpatient/list";
        JSONObject jr = new JSONObject();
        RequestQueue rq = Volley.newRequestQueue(Ts9_PatientCard.this);
        JsonObjectRequest jor = new JsonObjectRequest(url, jr, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("onResponse", response.toString());
                Gson gson = new Gson();
                patientinfo = gson.fromJson(response.toString(), Ts9_patientinfodata.class);
                for (int i = 0; i < patientinfo.getData().getList().size(); i++) {
                    Ts9_patientinfodata.DataBean.ListBean pi = patientinfo.getData().getList().get(i);
                    ptname.setText("*姓名："+pi.getBname());
                    ptsex.setText("*性别："+pi.getBsex());
                    ptbirthday.setText("*出生日期："+pi.getBbirthday());
                    pttel.setText("*联系方式："+pi.getBtel());
                    ptiacard.setText("*身份证号码："+pi.getBid());
                    ptadr.setText("通讯地址："+pi.getBaddress());
                }
            }
//                }
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