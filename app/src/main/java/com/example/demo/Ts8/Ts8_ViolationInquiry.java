package com.example.demo.Ts8;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.demo.R;

public class Ts8_ViolationInquiry extends AppCompatActivity {


    //定义Fragment对象
    private Fragment queryfragment,recordfragment,nowFragment;
    //定义底部标签
    private TextView record;
    private TextView query;
    private Button Tquery;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ts8_violation_inquiry);

        //侧边返回
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        query = (TextView) findViewById(R.id.btquery);
        record = (TextView) findViewById(R.id.btrecord);
        Tquery = (Button) findViewById(R.id.Tquery);
        //默认显示记录页
        showRecord();
//        点击查询跳到记录页

        View.OnClickListener l = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btrecord){
                    showRecord();
                }else if(v.getId() == R.id.btquery){
                    showQuery();
                }
            }
        };
        //为标签设计点击事件
        record.setOnClickListener(l);
        query.setOnClickListener(l);

    }
    /**
     *第一个标签被点击
     */
    private void showRecord(){
        //开启事务，Fragment的切换由事务控制
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //判断Fragment是否为空
        if (recordfragment==null){
            recordfragment = new Ts8_RecordFragment();
            //添加Fragment到事务
            transaction.add(R.id.content_layout,recordfragment);
        }
        //隐藏所有的Fragment
        hideAllFragment(transaction);
        //显示Fragment
        transaction.show(recordfragment);
        //记录Fragment
        nowFragment = recordfragment;
        //提交事务
        transaction.commit();
        //设置底部tab变化
        record.setBackgroundColor(Color.GRAY);
        query.setBackgroundColor(Color.WHITE);
    }
    /**
     *第一个标签被点击
     */
    private void showQuery(){
        //开启事务，Fragment的切换由事务控制
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //判断Fragment是否为空
        if (queryfragment==null){
            queryfragment = new Ts8_QueryFragment();
            //添加Fragment到事务
            transaction.add(R.id.content_layout,queryfragment);
        }
        //隐藏所有的Fragment
        hideAllFragment(transaction);
        //显示Fragment
        transaction.show(queryfragment);
        //记录Fragment
        nowFragment = queryfragment;
        //提交事务
        transaction.commit();
        //设置底部tab变化
        query.setBackgroundColor(Color.GRAY);
        record.setBackgroundColor(Color.WHITE);
    }
    /**
     * 隐藏所有的Fragment
     */
    private void hideAllFragment(FragmentTransaction transaction){
        if (queryfragment!=null){
            transaction.hide(queryfragment);
        }
        if (recordfragment!=null){
            transaction.hide(recordfragment);
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
