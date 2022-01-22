package com.example.deomo.t2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.deomo.R;
import com.example.deomo.t2.fragment.P1_Fragment;
import com.example.deomo.t2.fragment.P2_Fragment;
import com.example.deomo.t2.fragment.P3_Fragment;
import com.example.deomo.t2.fragment.P4_Fragment;
import com.example.deomo.t2.fragment.P5_Fragment;

public class Page extends AppCompatActivity implements View.OnClickListener{


    private Fragment Fragment_index;
    private Fragment Fragment_service;
    private Fragment Fragment_smart;
    private Fragment Fragment_news;
    private Fragment Fragment_user;
    private Fragment newFragment;
    private TextView main;
    private TextView service;
    private TextView smart;
    private TextView news;
    private TextView user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t2_page);


        initUI();

        main.setOnClickListener(this);
        service.setOnClickListener(this);
        smart.setOnClickListener(this);
        news.setOnClickListener(this);
        user.setOnClickListener(this);
        show1Fragment();


    }

    //    初始化控件
    private void initUI(){
        main = (TextView)findViewById(R.id.main);
        main = (TextView)findViewById(R.id.main);
        service = (TextView)findViewById(R.id.service);
        smart = (TextView)findViewById(R.id.smart);
        news = (TextView)findViewById(R.id.news);
        user = (TextView)findViewById(R.id.user);

        main.setBackgroundColor(Color.WHITE);
        service.setBackgroundColor(Color.WHITE);
        smart.setBackgroundColor(Color.GRAY);
        news.setBackgroundColor(Color.WHITE);
        user.setBackgroundColor(Color.WHITE);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.main){
            show1Fragment();
        }else if (view.getId()==R.id.service){
            show2Fragment();
        }else if (view.getId()==R.id.smart){
            show3Fragment();
        }else if (view.getId()==R.id.news){
            show4Fragment();
        }else if (view.getId()==R.id.user){
            show5Fragment();
        }

    }


    //    fragment 布局
    private void show1Fragment(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (Fragment_index==null){
            Fragment_index = new P1_Fragment();
            transaction.add(R.id.page,Fragment_index);
        }
        hideAllFragment(transaction);
        transaction.show(Fragment_index);
        newFragment = Fragment_index;
        transaction.commit();

        main.setBackgroundColor(Color.GRAY);
        service.setBackgroundColor(Color.WHITE);
        smart.setBackgroundColor(Color.WHITE);
        news.setBackgroundColor(Color.WHITE);
        user.setBackgroundColor(Color.WHITE);

    }

    private void show2Fragment(){
        androidx.fragment.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (Fragment_service==null){
            Fragment_service = new P2_Fragment();
            transaction.add(R.id.page,Fragment_service);
        }
        hideAllFragment(transaction);
        transaction.show(Fragment_service);
        newFragment = Fragment_service;
        transaction.commit();

        main.setBackgroundColor(Color.WHITE);
        service.setBackgroundColor(Color.GRAY);
        smart.setBackgroundColor(Color.WHITE);
        news.setBackgroundColor(Color.WHITE);
        user.setBackgroundColor(Color.WHITE);

    }

    private void show3Fragment(){
        androidx.fragment.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (Fragment_smart==null){
            Fragment_smart = new P3_Fragment();
            transaction.add(R.id.page,Fragment_smart);
        }
        hideAllFragment(transaction);
        transaction.show(Fragment_smart);
        newFragment = Fragment_smart;
        transaction.commit();

        main.setBackgroundColor(Color.WHITE);
        service.setBackgroundColor(Color.WHITE);
        smart.setBackgroundColor(Color.GRAY);
        news.setBackgroundColor(Color.WHITE);
        user.setBackgroundColor(Color.WHITE);

    }

    private void show4Fragment(){
        androidx.fragment.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (Fragment_news==null){
            Fragment_news = new P4_Fragment();
            transaction.add(R.id.page,Fragment_news);
        }
        hideAllFragment(transaction);
        transaction.show(Fragment_news);
        newFragment = Fragment_news;
        transaction.commit();

        main.setBackgroundColor(Color.WHITE);
        service.setBackgroundColor(Color.WHITE);
        smart.setBackgroundColor(Color.WHITE);
        news.setBackgroundColor(Color.GRAY);
        user.setBackgroundColor(Color.WHITE);

    }


    private void show5Fragment(){
        androidx.fragment.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (Fragment_user==null){
            Fragment_user = new P5_Fragment();
            transaction.add(R.id.page,Fragment_user);
        }
        hideAllFragment(transaction);
        transaction.show(Fragment_user);
        newFragment = Fragment_user;
        transaction.commit();

        main.setBackgroundColor(Color.WHITE);
        service.setBackgroundColor(Color.WHITE);
        smart.setBackgroundColor(Color.WHITE);
        news.setBackgroundColor(Color.WHITE);
        user.setBackgroundColor(Color.GRAY);

    }

    private void hideAllFragment(FragmentTransaction transaction){
        if (Fragment_index!=null){
            transaction.hide(Fragment_index);
        }
        if (Fragment_service!=null){
            transaction.hide(Fragment_service);
        }
        if (Fragment_smart!=null){
            transaction.hide(Fragment_smart);
        }
        if (Fragment_news!=null){
            transaction.hide(Fragment_news);
        }
        if (Fragment_user!=null){
            transaction.hide(Fragment_user);
        }
    }




}
