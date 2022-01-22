package com.sfsq.demo17.T17ui.dashboard;

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

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.sfsq.demo17.T17adapter.ListViewAdapter;
import com.sfsq.demo3.R;
import com.sfsq.demo17.T17Bean.DeliverListBean;
import com.sfsq.demo17.T17Bean.ItemDeliverListBean;
import com.sfsq.demo3.databinding.T17FragmentDashboardBinding;
import com.sfsq.demo17.T17ui.MyJsonObjectRequest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private T17FragmentDashboardBinding binding;
    private ArrayList<ItemDeliverListBean> mData;
    private RecyclerView listView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.t17_fragment_dashboard,container,false);
        listView = (RecyclerView) view.findViewById(R.id.list_view);
        mData = new ArrayList<>();
        showList();
        query();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void showList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DashboardFragment.this.getActivity());
        listView.setLayoutManager(linearLayoutManager);
        Collections.reverse(mData); // 数组倒序，将最新添加的展示在最前面
        ListViewAdapter adapter = new ListViewAdapter(mData);
        listView.setAdapter(adapter);

    }

    public void query() {
        Toast.makeText(DashboardFragment.this.getActivity(),"数据正在加载中...",Toast.LENGTH_LONG).show();
        String url = "http://124.93.196.45:10001/prod-api/api/job/deliver/list";
        JSONObject jr = new JSONObject();
        RequestQueue rq = Volley.newRequestQueue(DashboardFragment.this.getActivity());
        MyJsonObjectRequest jor = new MyJsonObjectRequest(url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d("onResponse", response.toString());
                Gson gson = new Gson();
                DeliverListBean deliverListBean = gson.fromJson(response.toString(), DeliverListBean.class);
                if (deliverListBean.getCode() == 200) {

                    for (int i = 0; i < deliverListBean.getRows().size(); i++) {
                        ItemDeliverListBean itemDeliverListBean = new ItemDeliverListBean();
//                        Log.d("onResponse", "公司" + deliverListBean.getRows().get(i).getCompanyName() +
//                                " 薪资" + deliverListBean.getRows().get(i).getMoney() +
//                                " 岗位" + deliverListBean.getRows().get(i).getPostName() +
//                                " 投递时间" + deliverListBean.getRows().get(i).getSatrTime()
//                        );
                        itemDeliverListBean.money = deliverListBean.getRows().get(i).getMoney();
                        itemDeliverListBean.companyName = deliverListBean.getRows().get(i).getCompanyName();
                        itemDeliverListBean.satrTime = deliverListBean.getRows().get(i).getSatrTime();
                        itemDeliverListBean.postName = deliverListBean.getRows().get(i).getPostName();
                        mData.add(itemDeliverListBean);
                    }
                    showList();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onResponse", error.toString());
            }
        });
        jor.setRetryPolicy(new DefaultRetryPolicy(15 * 1000, 1, 1f));
        rq.add(jor);
    }


}