package com.example.deomo.t2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.deomo.R;
import com.example.deomo.t2.adapter.MyFragmentStateAdapter;
import com.example.deomo.t2.MoreActivity;
import com.example.deomo.t2.Movie;
import com.example.deomo.t2.Subways;
import com.example.deomo.t2.Waimai;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class P1_Fragment extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.t2_p1,container,false);
        return v;
    }

    private TextView subway;
    private TextView work;
    private TextView homes;
    private TextView waimai;
    private TextView life;
    private TextView movies;
    private TextView bus;
    private TextView charge;
    private TextView cline;
    private TextView allService;
    private TextView top1;
    private TextView top2;


    private ViewPager2 viewPager2;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;//新闻类别
    private Tab1 fragment1;
    private Tab2 fragment2;
    private Tab3 fragment3;
    private Tab4 fragment4;
    private Tab5 fragment5;
    private Tab6 fragment6;
    private TabLayout tabLayout;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager2 = (ViewPager2)view.findViewById(R.id.viewPager2);
        tabLayout = (TabLayout)view.findViewById(R.id.tabLayout);
        init();
        zhuanglan();
        iniUI(view);
    }

    //初始化
    private void iniUI(View view){
        subway = (TextView) view.findViewById(R.id.subway);
        work = (TextView) view.findViewById(R.id.work);
        homes = (TextView) view.findViewById(R.id.homes);
        waimai = (TextView) view.findViewById(R.id.waimai);
        life = (TextView) view.findViewById(R.id.life);
        movies = (TextView) view.findViewById(R.id.movies);
        bus = (TextView) view.findViewById(R.id.bus);
        charge = (TextView) view.findViewById(R.id.charge);
        cline = (TextView) view.findViewById(R.id.cline);
        allService = (TextView)  view.findViewById(R.id.all_service);
        top1 = (TextView) view.findViewById(R.id.top1);
        top2 = (TextView)  view.findViewById(R.id.top2);

        subway.setOnClickListener(this);
        work.setOnClickListener(this);
        homes.setOnClickListener(this);
        waimai.setOnClickListener(this);
        life.setOnClickListener(this);
        movies.setOnClickListener(this);
        bus.setOnClickListener(this);
        charge.setOnClickListener(this);
        cline.setOnClickListener(this);
        allService.setOnClickListener(this);
        top1.setOnClickListener(this);
        top2.setOnClickListener(this);

    }


    //点击事件
    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.subway){
            Intent intent = new Intent(P1_Fragment.this.getContext(), Subways.class);
            startActivity(intent);
            Toast.makeText(P1_Fragment.this.getContext(),"正在进入地铁服务页面",Toast.LENGTH_SHORT).show();
        }else if (view.getId()==R.id.work){
            Intent intent = new Intent(P1_Fragment.this.getContext(), Subways.class);
            startActivity(intent);
            Toast.makeText(P1_Fragment.this.getContext(),"正在进入找工作页面",Toast.LENGTH_SHORT).show();
        }
        else if (view.getId()==R.id.homes){
            Intent intent = new Intent(P1_Fragment.this.getContext(), Subways.class);
            startActivity(intent);
            Toast.makeText(P1_Fragment.this.getContext(),"正在进入找房子页面",Toast.LENGTH_SHORT).show();
        }
        else if (view.getId()==R.id.waimai){
            Intent intent = new Intent(P1_Fragment.this.getContext(), Waimai.class);
            startActivity(intent);
            Toast.makeText(P1_Fragment.this.getContext(),"正在进入点外卖页面",Toast.LENGTH_SHORT).show();
        }
        else if (view.getId()==R.id.life){
            Intent intent = new Intent(P1_Fragment.this.getContext(), MoreActivity.class);
            startActivity(intent);
            Toast.makeText(P1_Fragment.this.getContext(),"正在进入智慧生活页面",Toast.LENGTH_SHORT).show();
        }else if (view.getId()==R.id.movies){
            Intent intent = new Intent(P1_Fragment.this.getContext(), Movie.class);
            startActivity(intent);
            Toast.makeText(P1_Fragment.this.getContext(),"正在进入看电影页面",Toast.LENGTH_SHORT).show();
        }else if (view.getId()==R.id.bus){
            Intent intent = new Intent(P1_Fragment.this.getContext(), MoreActivity.class);
            startActivity(intent);
            Toast.makeText(P1_Fragment.this.getContext(),"正在进入智慧巴士页面",Toast.LENGTH_SHORT).show();
        }else if (view.getId()==R.id.charge){
            Intent intent = new Intent(P1_Fragment.this.getContext(), MoreActivity.class);
            startActivity(intent);
            Toast.makeText(P1_Fragment.this.getContext(),"正在进入生活缴费页面",Toast.LENGTH_SHORT).show();
        }else if (view.getId()==R.id.cline){
            Intent intent = new Intent(P1_Fragment.this.getContext(), MoreActivity.class);
            startActivity(intent);
            Toast.makeText(P1_Fragment.this.getContext(),"正在进入门诊预约页面",Toast.LENGTH_SHORT).show();
        }else if (view.getId()==R.id.all_service){
            Intent intent = new Intent(P1_Fragment.this.getContext(), MoreActivity.class);
            startActivity(intent);
            Toast.makeText(P1_Fragment.this.getContext(),"正在进入更多服务页面",Toast.LENGTH_SHORT).show();
        }
        else if (view.getId()==R.id.top1){
            Intent intent = new Intent(P1_Fragment.this.getContext(), MoreActivity.class);
            startActivity(intent);
            Toast.makeText(P1_Fragment.this.getContext(),"正在进入热门话题",Toast.LENGTH_SHORT).show();
        }
        else if (view.getId()==R.id.top2){
            Intent intent = new Intent(P1_Fragment.this.getContext(), MoreActivity.class);
            startActivity(intent);
            Toast.makeText(P1_Fragment.this.getContext(),"正在进入热门话题",Toast.LENGTH_SHORT).show();
        }
    }



    private void zhuanglan(){
        MyFragmentStateAdapter myFragmentStateAdapter =
                new MyFragmentStateAdapter(this.getActivity(),fragments);
        viewPager2.setAdapter(myFragmentStateAdapter);

        //关联TabLayout 添加attach()
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titles.get(position));
            }
        }).attach();

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
//                Log.d("amy",position+"");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

    }

    //添加数据
    public void init(){
        fragments = new ArrayList<>();
        fragment1 = new Tab1();
        fragment2 = new Tab2();
        fragment3 = new Tab3();
        fragment4 = new Tab4();
        fragment5 = new Tab5();
        fragment6 = new Tab6();
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment4);
        fragments.add(fragment5);
        fragments.add(fragment6);
        titles = new ArrayList<>();
        titles.add("今日要闻");
        titles.add("专题聚焦");
        titles.add("政策解读");
        titles.add("经济发展");
        titles.add("文化旅游");
        titles.add("更多");

    }



}
