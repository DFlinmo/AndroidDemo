package com.sfsq.demo16.T16ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.sfsq.demo16.T16Bean.ItemMoveCarHistoryBean;
import com.sfsq.demo16.T16Bean.MoveCarHistoryBean;
import com.sfsq.demo16.T16ui.MyJsonObjectRequest;
import com.sfsq.demo16.T16ui.adapter.ListViewAdapter;
import com.sfsq.demo2.R;
import com.sfsq.demo2.databinding.T16FragmentDashboardBinding;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private T16FragmentDashboardBinding binding;
    private RecyclerView list_view;
    private ArrayList<ItemMoveCarHistoryBean> mData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        dashboardViewModel =
//                new ViewModelProvider(this).get(DashboardViewModel.class);
//
//        binding = FragmentDashboardBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
        View v = inflater.inflate(R.layout.t16_fragment_dashboard,container,false);
        list_view = v.findViewById(R.id.list_view);
        mData = new ArrayList<>();
        query();
        showList();

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void showList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(DashboardFragment.this.getActivity());
        list_view.setLayoutManager(layoutManager);
        Collections.reverse(mData); // 倒序
        ListViewAdapter listViewAdapter = new ListViewAdapter(mData);
        list_view.setAdapter(listViewAdapter);

    }

    public void query() {
        Toast.makeText(DashboardFragment.this.getActivity(), "数据正在加载中...", Toast.LENGTH_SHORT).show();
        String url = "http://124.93.196.45:10001/prod-api/api/park/car/history/list";
        JSONObject jr = new JSONObject();
        RequestQueue rq = Volley.newRequestQueue(DashboardFragment.this.getActivity());
        MyJsonObjectRequest jor = new MyJsonObjectRequest(url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Log.d("onResponse", response.toString());
                Gson gson = new Gson();
                MoveCarHistoryBean moveCarHistoryBean = gson.fromJson(response.toString(), MoveCarHistoryBean.class);

                if (moveCarHistoryBean.getCode()==200){
                for (int i = 0; i < moveCarHistoryBean.getRows().size(); i++) {

//                    Log.d("onResponse", "地址:" + moveCarHistoryBean.getRows().get(i).getProvince() + moveCarHistoryBean.getRows().get(i).getCity() + moveCarHistoryBean.getRows().get(i).getArea());
//                    Log.d("onResponse", "现场图片:" + moveCarHistoryBean.getRows().get(i).getPhoto());
//                    Log.d("onResponse", "车牌号:" + moveCarHistoryBean.getRows().get(i).getPlateNo());
//                    Log.d("onResponse", "车主电话:" + moveCarHistoryBean.getRows().get(i).getTel());
                    ItemMoveCarHistoryBean itemMoveCarHistoryBean = new ItemMoveCarHistoryBean();
                    itemMoveCarHistoryBean.tel = moveCarHistoryBean.getRows().get(i).getTel();
                    itemMoveCarHistoryBean.address = moveCarHistoryBean.getRows().get(i).getProvince() + moveCarHistoryBean.getRows().get(i).getCity() + moveCarHistoryBean.getRows().get(i).getArea() + moveCarHistoryBean.getRows().get(i).getAddress();
                    itemMoveCarHistoryBean.PlateNo = moveCarHistoryBean.getRows().get(i).getPlateNo();
                    mData.add(itemMoveCarHistoryBean);
                }
                showList();}else {
                    Toast.makeText(DashboardFragment.this.getActivity(), "查询失败:"+moveCarHistoryBean.getCode(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onResponse", error.toString());
            }
        });
        rq.add(jor);
    }


}