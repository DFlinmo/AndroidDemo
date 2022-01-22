package com.example.deomo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.deomo.t1.Index_1;
import com.example.deomo.t1.Index_2;
import com.example.deomo.t1.Index_3;
import com.example.deomo.t1.Index_4;
import com.example.deomo.t1.Index_5;

public class T1_MainActivity extends AppCompatActivity {

    private ViewPager myViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t1_activitymain);
        myViewPager = (ViewPager) findViewById(R.id.myViewPager);
        PagerAdapter pa = new PagerAdapter(this.getSupportFragmentManager());
        //添加适配器
        myViewPager.setAdapter(pa);
    }


    private class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            if(i == 0){
                return new Index_1();
            }
            if(i == 1){
                return new Index_2();
            }
            if(i == 2){
                return new Index_3();
            }
            if(i == 3){
                return new Index_4();
            }
            if(i == 4){
                return new Index_5();
            }

            return null;
        }

        //返回多少个页面
        @Override
        public int getCount() {
            return 5;
        }
    }

}