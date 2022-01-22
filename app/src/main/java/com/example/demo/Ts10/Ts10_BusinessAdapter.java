package com.example.demo.Ts10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.List;

public class Ts10_BusinessAdapter extends BaseAdapter {

    List<Ts10_Business> businesses = new ArrayList<Ts10_Business>();
    private Context context;

    public Ts10_BusinessAdapter(List<Ts10_Business> businesses, Context context) {
        this.businesses = businesses;
        this.context = context;
    }

    @Override
    public int getCount() {
        return businesses.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder{
        private ImageView businessImg;
        private TextView businessName;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.ts10_business_list,viewGroup,false);
            holder.businessImg = (ImageView) view.findViewById(R.id.business_img);
            holder.businessName = (TextView) view.findViewById(R.id.business_name);
            view.setTag(holder);
        }else {
            holder = (Ts10_BusinessAdapter.ViewHolder)view.getTag();
        }
        holder.businessImg.setImageResource(businesses.get(i).getBusinessimg());
        holder.businessName.setText("\t\t"+businesses.get(i).getAdvertising()+"--"+businesses.get(i).getBusinessname());

        return view;
    }
}
