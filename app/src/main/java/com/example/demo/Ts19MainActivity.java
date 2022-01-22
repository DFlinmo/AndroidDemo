package com.example.demo;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ts19MainActivity extends Activity {
    List<Ts19HouseList.RowsBean> mlist = new ArrayList<>();
    private List<String> mData = new ArrayList<>();
    private List<String> mBackData;
    private ListView listView;
    private ListView listView2;
    private TextView test;
    private ViewPager mViewPaper;
//    private List<String> data ;
    private EditText mSearchView;
    private TextView ershou;
    private Ts19HouseAdapter mAdapter;
    private ListView mListView;
    private List<ImageView> images;
    private List<View> dots;
    private RequestQueue mQueue;
    private Ts19HouseAdapter adapter;
    private PagerAdapter adapter2;
    private Ts19SearchAdapter adapter3;
    private Button Ershou;
    private Button Zufang;
    private Button Loupan;
    private Button Zhongjie;

    private ScheduledExecutorService scheduledExecutorService;
    private List<String> data = new ArrayList<>() ;
    private int currentItem;
    //记录上一次点的位置
    private int oldPosition = 0;
    //存放图片的id
    private int[] imageIds = new int[]{
            R.drawable.homepage1,
            R.drawable.homepage2,
            R.drawable.homepage3,
            R.drawable.homepage4,
    };
    //存放图片的标题


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ts19activity_main);
        mViewPaper = (ViewPager) findViewById(R.id.vp);
        initListener();
        listView =findViewById(R.id.HouseList);
        listView2 =findViewById(R.id.AllHouseList);
        Ershou = findViewById(R.id.Ershou);
        Zufang = findViewById(R.id.Zufang);
        Loupan = findViewById(R.id.Loupan);
        Zhongjie = findViewById(R.id.Zhongjie);
        mSearchView = (EditText) findViewById(R.id.searchView);
        adapter3 = new Ts19SearchAdapter(getApplicationContext(),mlist);
        listView.setAdapter((ListAdapter) adapter);
//        mSearchView.addTextChangedListener(new watcher());
        LayoutInflater layout=this.getLayoutInflater();
        View view=layout.inflate(R.layout.ts19layout_houselist, null);
        final TextView  b=(TextView) view.findViewById(R.id.ershou);


//        init();

        //显示的图片
        images = new ArrayList<ImageView>();
        for(int i = 0; i < imageIds.length; i++){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }
        //显示的小点
        dots = new ArrayList<View>();
        dots.add(findViewById(R.id.dot_0));
        dots.add(findViewById(R.id.dot_1));
        dots.add(findViewById(R.id.dot_2));
        dots.add(findViewById(R.id.dot_3));
        dots.add(findViewById(R.id.dot_4));


//        setListViewHeightBasedOnChildren(listView);
        mQueue = Volley.newRequestQueue(this);

        Intent intent=this.getIntent();
        ArrayList<String> list=intent.getStringArrayListExtra("list");
        System.out.println(list);
//        LoginByGet();
        adapter2 = new ViewPagerAdapter();
        mViewPaper.setAdapter(adapter2);

        mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {



            @Override
            public void onPageSelected(int position) {
                dots.get(position).setBackgroundResource(R.drawable.dot_focused);
                dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);

                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

        Ershou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                data.clear();

                initListener();
                adapter3.notifyDataSetChanged();
                String str=mSearchView.getText().toString();
                if (!str.equals("全部")){      // 全部 时不进行筛选
                    for (int a=0;a<data.size();a++){     //对列表每列都进行对比
                        if (!data.get(a).toString().contains(str)){   //当列表与选项不符合时
                            System.out.println(data.get(a));
                            data.remove(a);      //移除当前列
                            a--;       //每次执行删除一个 size 都要减少 1 （因为列表中减少了一列）
                        }

                        adapter3.notifyDataSetChanged();    //每次删除后更新列表
                        System.out.println(data);
                    }

                }
            }

        });
    }


    public void initListener() {
        //创建一个请求队列
        final RequestQueue requestQueue = Volley.newRequestQueue(Ts19MainActivity.this);
        //创建一个请求
        String url = "http://124.93.196.45:10001/prod-api/api/house/housing/list";
        Ts19MyStringRequest stringRequest = new Ts19MyStringRequest(url, new Response.Listener<String>() {
            //正确接受数据之后的回调
            @Override
            public void onResponse(String response) {
                Log.d("onResponse",response.toString());
                analyzeJSONArray(response);
//                Gson gson = new Gson();
//                Ts19HouseList newsList = gson.fromJson(response.toString(),Ts19HouseList.class);
//                listView.setAdapter(new Ts19HouseAdapter(newsList.getRows(),Ts19MainActivity.this));
//                test.setText(response);
            }
        }, new Response.ErrorListener() {//发生异常之后的监听回调
            @Override
            public void onErrorResponse(VolleyError error) {
                test.setText("加载错误" + error);
            }
        });
        //将创建的请求添加到请求队列当中
        requestQueue.add(stringRequest);
    }

    public void analyzeJSONArray(String json) {

        try{
            JSONObject jsonObjectALL = new JSONObject(json);

            // 通过标识(person)，获取JSON数组
            JSONArray jsonArray = jsonObjectALL.getJSONArray("rows");
            for(int i = 0; i <jsonArray.length() ; i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                data.add(obj.getString("price")); data.add(obj.getString("sourceName")) ; data.add(obj.getString("price")) ; data.add(obj.getString("address")) ; data.add(obj.getString("areaSize"));
                data.add(obj.getString("tel")) ; data.add(obj.getString("houseType"));data.add(obj.getString( "description"));
                System.out.println(data);
//                String s= URLDecoder.decode(obj.getString("pic"), "UTF-8");
                Gson gson = new Gson();
                Ts19HouseList newsList = gson.fromJson(json.toString(), Ts19HouseList.class);
                listView.setAdapter(new Ts19HouseAdapter(newsList.getRows(), Ts19MainActivity.this));
                listView2.setAdapter(new Ts19HouseAdapter(newsList.getRows(), Ts19MainActivity.this));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class watcher implements TextWatcher {

        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            // TODO Auto-generated method stub
            String aa = s.toString();
            Pattern p = Pattern.compile(aa);
            List<Ts19HouseList.RowsBean> we = new ArrayList<>();
            for(int i=0;i<mlist.size();i++){
                Ts19HouseList.RowsBean pp = mlist.get(i);
                Matcher matcher = p.matcher(pp.getAddress()+pp.getPrice()+pp.getDescription()+pp.getAreaSize());
                System.out.println("huode");
                if(matcher.find()){
                    we.add(pp);
                }
            }
            adapter3 = new Ts19SearchAdapter(getApplicationContext(), we);
            listView.setAdapter((ListAdapter) adapter3);
        }

    }


    public class ViewPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            // TODO Auto-generated method stub
//			super.destroyItem(container, position, object);
//			view.removeView(view.getChildAt(position));
//			view.removeViewAt(position);
            view.removeView(images.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            // TODO Auto-generated method stub
            view.addView(images.get(position));
            return images.get(position);
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * 利用线程池定时执行动画轮播
     */
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),
                2,
                2,
                TimeUnit.SECONDS);
    }


    private class ViewPageTask implements Runnable{

        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            mHandler.sendEmptyMessage(0);
        }
    }

    /**
     * 接收子线程传递过来的数据
     */
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            mViewPaper.setCurrentItem(currentItem);
        };
    };
    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
    }
}
