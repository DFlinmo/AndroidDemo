package com.example.demo.Ts8;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.demo.R;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Ts8_RecordFragment extends Fragment {
    public View view;
    private ViewGroup viewGroup;
    private Context mContext;

    //测试传值
    String tvshow;
    private Button Readmore;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //创建Fragment的布局
        View view = inflater.inflate(R.layout.ts8_record,container,false);
        return view;
    }
    List<String> liDated=new ArrayList<String>();    //获取违章时间
    List<String> liCarnumber=new ArrayList<String>();    //获取违章车牌号
    List<String> liPaddr=new ArrayList<String>();    //获取违章地点
    List<String> liPremarks=new ArrayList<String>();    //获取违章内容
    List<String> liPmoney=new ArrayList<String>();    //获取违章罚款
    List<String> liPscore=new ArrayList<String>();    //获取违章扣分
    List<String> liHandle=new ArrayList<String>();    //获取违章处理
    List<String> liPnumber=new ArrayList<String>();    //获取违章号码

    private ListView panccydetail;
    private List<Ts8_panccy> panlist = new ArrayList<Ts8_panccy>();
    private Ts8_panccyAdapter panAdapter;
    RecordList recordList;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        record();
        Readmore = (Button) view.findViewById(R.id.Readmore);
        Readmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        //listview操作
        panccydetail = (ListView) view.findViewById(R.id.plist);
        panAdapter = new Ts8_panccyAdapter(panlist, Ts8_RecordFragment.this.getContext());
        panccydetail.setAdapter(panAdapter);

    }
    //获取违章记录详情
    public void record(){
        String url="http://192.168.202.25:5000/api/detailvio/list";
        JSONObject jr = new JSONObject();

        RequestQueue rq = Volley.newRequestQueue(Ts8_RecordFragment.this.getContext());
        JsonObjectRequest jor = new JsonObjectRequest(url, jr, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("onResponse",response.toString());
                Gson gson = new Gson();
                recordList = gson.fromJson(response.toString(),RecordList.class);
                for (int i = 0; i < recordList.getData().getList().size(); i++) {
                    final RecordList.DataBean.ListBean b =   recordList.getData().getList().get(i);
//                    if(tvshow.equals(b.getCarnum())){
                        liDated.add(b.getPtime());
                        liCarnumber.add(b.getCarnum());
                        liPaddr.add(b.getParea());
                        liHandle.add(b.getPhandle());
                        liPremarks.add(b.getPhands());
                        liPmoney.add(b.getPmoney());
                        liPscore.add(b.getPsocre());
                        liPnumber.add(b.getPnumber());
                        //listview点击显示详情
                        panccydetail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int j, long l) {
                                RecordList.DataBean.ListBean rl = recordList.getData().getList().get(j);
                                Intent intent = new Intent(getActivity(), Ts8_RecorddetailActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("carid", rl.getCarnum());
                                System.out.println("getCarnum()=="+rl.getCarnum());
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }
                        });

                }
                //获取违章记录详情
                initDatapanlist(); // 初始化listview数据

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onResponse",error.toString());
            }
        });
        rq.add(jor);
    }
    //初始化数据
    public void initDatapanlist(){

            for (int i = 0;i<liPaddr.size();i++){
                Ts8_panccy palist = new Ts8_panccy(liPaddr.get(i),liPscore.get(i),liPmoney.get(i),liDated.get(i),liHandle.get(i),liCarnumber.get(i));
                System.out.println("liPaddr.get("+i+")=="+liPaddr.get(i));
                panlist.add(palist);
            }

            panAdapter.notifyDataSetChanged(); //通知适配器数据改变

    }

}
