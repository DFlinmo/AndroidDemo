package com.example.demo.Ts8;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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

public class Ts8_QueryFragment extends Fragment {


    private TextView area;
    private TextView score;
    private TextView money;
    private TextView date;
    private TextView handle;
    private TextView carid;

    String CarId;

    private Button Tquery;
    private EditText inputtype;
    private EditText inpulic;
    private EditText inputen;

//    private FragmentManager manager;
//    private FragmentTransaction ft;

    RecordList recordList;

    String cartype;
    String pulic;
    String puten;

    List<String> carnumtype=new ArrayList<String>();
    List<String> carlicnum=new ArrayList<String>();
    List<String> carennum=new ArrayList<String>();

    Ts8_Queryviodata.DataBean.ListBean b; // 声明QueryvioList
    RecordList.DataBean.ListBean d;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            //创建Fragment的布局
            View view = inflater.inflate(R.layout.ts8_queryfragment,container,false);
            return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        query();
        inputtype = (EditText) view.findViewById(R.id.inputtype);
        inpulic = (EditText) view.findViewById(R.id.inpulic);
        inputen = (EditText) view.findViewById(R.id.inputen);
        Tquery = (Button) view.findViewById(R.id.Tquery);

        area = (TextView) view.findViewById(R.id.area);
        score = (TextView) view.findViewById(R.id.score);
        money = (TextView) view.findViewById(R.id.money);
        date = (TextView) view.findViewById(R.id.date);
        handle = (TextView) view.findViewById(R.id.handle);
        carid = (TextView) view.findViewById(R.id.carid);

        Tquery.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                setquery();
            }
        });

    }

    public void getqueryD(){
        AlertDialog.Builder querydialog = new AlertDialog.Builder(getActivity());
        View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.ts8_panccy_list,null);
        area = (TextView) dialogView.findViewById(R.id.area);
        score = (TextView) dialogView.findViewById(R.id.score);
        money = (TextView) dialogView.findViewById(R.id.money);
        date = (TextView) dialogView.findViewById(R.id.date);
        handle = (TextView) dialogView.findViewById(R.id.handle);
        carid = (TextView) dialogView.findViewById(R.id.carid);
        record();
        querydialog.setTitle("违章查询");
        querydialog.setView(dialogView);
        querydialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        querydialog.setNegativeButton("查看详情", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(getActivity(), Ts8_QuerydetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("carnum", CarId);
                System.out.println("query.getCarnum()=="+CarId);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        querydialog.show();

    }

    //获取违章记录详情
    public void record(){
        String url="http://192.168.202.25:5000/api/detailvio/list";
        JSONObject jr = new JSONObject();

        RequestQueue rq = Volley.newRequestQueue(Ts8_QueryFragment.this.getContext());
        JsonObjectRequest jor = new JsonObjectRequest(url, jr, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("onResponse",response.toString());
                Gson gson = new Gson();
                recordList = gson.fromJson(response.toString(), RecordList.class);
                for (int i = 0; i < recordList.getData().getList().size(); i++) {
                    d =  recordList.getData().getList().get(i);
                    if(pulic.equals(d.getCarnum())){
                        System.out.println("d.getParea()=="+d.getParea());
                        area.setText(d.getParea());
                        score.setText(d.getPsocre());
                        money.setText(d.getPmoney());
                        date.setText(d.getPtime());
                        handle.setText(d.getPhandle());
                        CarId =d.getCarnum();
                        carid.setText(CarId);
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onResponse",error.toString());
            }
        });
        rq.add(jor);
    }

    //查询违章数据
    public void query(){
        String url="http://192.168.202.25:5000/api/queryvio/list";
        //{"CarId":2, "UserName":"user1"}
        JSONObject jr = new JSONObject();

        RequestQueue rq = Volley.newRequestQueue(Ts8_QueryFragment.this.getContext());
        JsonObjectRequest jor = new JsonObjectRequest(url, jr, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("onResponse",response.toString());
                Gson gson = new Gson();
                Ts8_Queryviodata newsList = gson.fromJson(response.toString(), Ts8_Queryviodata.class);
                for (int i = 0; i < newsList.getData().getList().size(); i++) {
                    b = newsList.getData().getList().get(i);
                    Log.d("onResponse", b.getCarnum());
                    carnumtype.add(b.getNumtype());
                    carlicnum.add(b.getCarnum());
                    carennum.add(b.getEnignum());
                    System.out.println("carnumtype="+carnumtype+"\ncarlicnum="+carlicnum+"\ncarennum="+carennum);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onResponse",error.toString());
            }
        });
        rq.add(jor);
    }

    //判断查询条件
    public void setquery(){
        cartype = inputtype.getText().toString();
        pulic = inpulic.getText().toString();
        puten = inputen.getText().toString();
        for (int i = 0;i<carnumtype.size();i++){
            if(cartype.equals(carnumtype.get(i))){  //判断车牌类型
                if(pulic.equals(carlicnum.get(i))){  //判断车牌号码
                    if(puten.equals(carennum.get(i))){  //判断发动机号
                        getqueryD();
                        System.out.println("搜索"+carnumtype.get(i)+"成功！");
                        break;
                    }else {
                        System.out.println("此发动机号不存在,carennum.get(i)="+carennum.get(i));
                    }
                }else {
                    System.out.println("此车牌号不存在");
                    System.out.println("carlicnum.get(i)="+carlicnum.get(i));
                }
            }else {
                System.out.println("此车牌类型不存在");
                System.out.println("carnumtype.get(i)"+carnumtype.get(i));
            }
        }

    }



}
