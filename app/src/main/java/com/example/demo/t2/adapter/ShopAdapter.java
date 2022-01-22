package com.example.deomo.t2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.deomo.R;
import com.example.deomo.t2.bean.Shop;

import java.util.List;

public class ShopAdapter extends BaseAdapter {
    private Context context;
    List<Shop.RowsDTO> rows;

    public ShopAdapter(Context context, List<Shop.RowsDTO> rows) {
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

    static class ViewHolder{
        private TextView shop_name;
        private TextView introduction;
        private TextView shop_address;
        private TextView avgmoney;
        private TextView distance;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = new ViewHolder();
        view = LayoutInflater.from(context).inflate(R.layout.t2_shoplist,viewGroup,false);
        holder.shop_name = (TextView) view.findViewById(R.id.shop_name);
        holder.introduction = (TextView) view.findViewById(R.id.introduction);
        holder.shop_address = (TextView) view.findViewById(R.id.shop_address);
        holder.avgmoney = (TextView) view.findViewById(R.id.avgmoney);
        holder.distance = (TextView) view.findViewById(R.id.distance);


        holder.shop_name.setText(rows.get(i).getName());
        holder.introduction.setText("简要描述"+rows.get(i).getIntroduction());
        holder.shop_address.setText("商家地址:"+rows.get(i).getAddress());
        holder.avgmoney.setText("平均消费"+rows.get(i).getAvgCost());
        holder.distance.setText("距离"+String.valueOf(rows.get(i).getDistance())+"米");
        return view;
    }

}

