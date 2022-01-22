package com.example.deomo.t2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.deomo.R;
import com.example.deomo.t2.bean.N_List;

import java.util.List;

public class N_ListAdapter extends BaseAdapter {

    private Context context;
    List<N_List.RowsDTO> rows;

    public N_ListAdapter() {
    }

    public N_ListAdapter(Context context, List<N_List.RowsDTO> rows) {
        this.context = context;
        this.rows = rows;
    }

    @Override
    public int getCount() {
        return rows.size();
    }

    @Override
    public Object getItem(int i) {
        return rows.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder {
        private TextView name;
        private TextView likeNum;
        private TextView signNum;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = new ViewHolder();

        view = LayoutInflater.from(context).inflate(R.layout.t1_activity, viewGroup, false);
        holder.name = view.findViewById(R.id.name);
        holder.likeNum = view.findViewById(R.id.likeNum);
        holder.signNum = view.findViewById(R.id.signNum);

        holder.name.setText(rows.get(i).getName());
        holder.likeNum.setText("点赞人数" + String.valueOf(rows.get(i).getLikeNum()));
        holder.signNum.setText("报名人数" + String.valueOf(rows.get(i).getSignupNum()));
        return view;
    }

}
