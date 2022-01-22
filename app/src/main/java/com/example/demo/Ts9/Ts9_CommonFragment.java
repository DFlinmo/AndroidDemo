package com.example.demo.Ts9;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class Ts9_CommonFragment extends Fragment {

    Ts9_RegistimeData registime;

    List<String> reTime = new ArrayList<>();
    List<String> reName = new ArrayList<>();
    List<String> reType = new ArrayList<>();
    String deptname;

    private Button reserve;
    private ListView cregistlist;
    private List<Ts9_Registime> registimes = new ArrayList<Ts9_Registime>();
    private Ts9_RegistimeAdapter registimeAdapter;
    Ts9_RegistimeData registimedata;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //创建Fragment的布局
        View view = inflater.inflate(R.layout.ts9_commonfragment,container,false);
        //获取可预约挂号科室名称
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Deta", Context.MODE_PRIVATE);
        deptname = sharedPreferences.getString("deptname","");
        System.out.println("deptname=="+deptname);


        setdepartment();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        cregistlist = (ListView) view.findViewById(R.id.cregistlist);
        registimeAdapter = new Ts9_RegistimeAdapter(registimes, getActivity());
        cregistlist.setAdapter(registimeAdapter);

    }


    public void setdepartment(){
        String url="http://192.168.202.25:5000/api/registime/list";
        JSONObject jr = new JSONObject();
        RequestQueue rq = Volley.newRequestQueue(Ts9_CommonFragment.this.getContext());
        JsonObjectRequest jor = new JsonObjectRequest(url, jr, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("onResponse", response.toString());
                Gson gson = new Gson();
                registime = gson.fromJson(response.toString(), Ts9_RegistimeData.class);
                for (int i = 0; i < registime.getData().getList().size(); i++) {
                    final Ts9_RegistimeData.DataBean.ListBean regist = registime.getData().getList().get(i);
                    String one = regist.getReserveTime();
                    System.out.println("regist.getReserveTime==="+one);
                    reTime.add(regist.getReserveTime());
                    reName.add(deptname);
                    reType.add(regist.getType());
                    System.out.println("reName=="+reName);

//                    Intent intent = new Intent(getActivity(), Ts9_RegistSuccess.class);
////                    intent.putExtra("registime",regist.getReserveTime());
////                    intent.putExtra("registype",regist.getType());
////                    intent.putExtra("registname",deptname);
////                    startActivity(intent);

                }
                initDataregistlist();
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
    public void initDataregistlist(){
        for (int i = 0;i<reName.size();i++){
            Ts9_Registime ts9_registime = new Ts9_Registime(reName.get(i),reTime.get(i));
            System.out.println("reName.get("+i+")=="+reName.get(i));
            registimes.add(ts9_registime);
        }
        registimeAdapter.notifyDataSetChanged(); //通知适配器数据改变
    }
}