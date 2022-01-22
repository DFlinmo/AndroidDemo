package com.example.demo.Ts9;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.demo.R;

public class Ts9_Registration extends AppCompatActivity {


    //定义Fragment对象
    private Fragment expertfragment,commonfragment,nowFragment;
    //定义底部标签
//    private TextView record;
//    private TextView query;
//
    private LinearLayout registrationLayout;
    private TextView expertReg;
    private TextView commonReg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ts9__registration);



        //侧边返回
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        };

//        query = (TextView) findViewById(R.id.common_reg);
//        record = (TextView) findViewById(R.id.expert_reg);

        registrationLayout = (LinearLayout) findViewById(R.id.registration_layout);
        expertReg = (TextView) findViewById(R.id.expert_reg);
        commonReg = (TextView) findViewById(R.id.common_reg);

        //默认显示记录页
        showcommon();
//        点击查询跳到记录页

        View.OnClickListener l = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.expert_reg){
                    showexpert();
                }else if(v.getId() == R.id.common_reg){
                    showcommon();
                }
            }
        };
        //为标签设计点击事件
        expertReg.setOnClickListener(l);
        commonReg.setOnClickListener(l);

    }
    /**
     *第一个标签被点击
     */
    private void showexpert(){
        //开启事务，Fragment的切换由事务控制
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //判断Fragment是否为空
        if (expertfragment ==null){
            expertfragment = new Ts9_ExpertFragment();
            //添加Fragment到事务
            transaction.add(R.id.registration_layout,expertfragment);
        }
        //隐藏所有的Fragment
        hideAllFragment(transaction);
        //显示Fragment
        transaction.show(expertfragment);
        //记录Fragment
        nowFragment = expertfragment;
        //提交事务
        transaction.commit();
        //设置底部tab变化
        expertReg.setBackgroundColor(Color.GRAY);
        commonReg.setBackgroundColor(Color.WHITE);
    }
    /**
     *第一个标签被点击
     */
    private void showcommon(){
        //开启事务，Fragment的切换由事务控制
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //判断Fragment是否为空
        if (commonfragment==null){
            commonfragment = new Ts9_CommonFragment();
            //添加Fragment到事务
            transaction.add(R.id.registration_layout,commonfragment);
        }
        //隐藏所有的Fragment
        hideAllFragment(transaction);
        //显示Fragment
        transaction.show(commonfragment);
        //记录Fragment
        nowFragment = commonfragment;
        //提交事务
        transaction.commit();
        //设置底部tab变化
        expertReg.setBackgroundColor(Color.WHITE);
        commonReg.setBackgroundColor(Color.GRAY);
    }
    /**
     * 隐藏所有的Fragment
     */
    private void hideAllFragment(FragmentTransaction transaction){
        if (commonfragment!=null){
            transaction.hide(commonfragment);
        }
        if (expertfragment!=null){
            transaction.hide(expertfragment);
        }
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
