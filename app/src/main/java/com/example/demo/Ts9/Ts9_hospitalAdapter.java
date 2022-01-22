package com.example.demo.Ts9;

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

public class Ts9_hospitalAdapter extends BaseAdapter {

    private List<Ts9_hospital> hospitals = new ArrayList<Ts9_hospital>();
    private Context context;

    public Ts9_hospitalAdapter(List<Ts9_hospital> hospitals, Context context){
        this.hospitals = hospitals;
        this.context = context;
    }

    @Override
    public int getCount() {
        return hospitals.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        private ImageView hspimg;
        private TextView hspname;
        private TextView hspstar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Ts9_hospitalAdapter.ViewHolder holder;
        if(convertView == null){
            holder = new Ts9_hospitalAdapter.ViewHolder();

            convertView = LayoutInflater.from(context).inflate(R.layout.ts9_hsplist,parent,false);
            holder.hspimg = (ImageView) convertView.findViewById(R.id.hsplogo);
            holder.hspname = (TextView)convertView.findViewById(R.id.hspname);
            holder.hspstar = (TextView)convertView.findViewById(R.id.hspstart);

            convertView.setTag(holder);
        }else {
            holder = (Ts9_hospitalAdapter.ViewHolder)convertView.getTag();
        }//R.mipmap.hslogo
        holder.hspimg.setImageResource(R.mipmap.hslogo);
        holder.hspname.setText(hospitals.get(position).getHspname());
        holder.hspstar.setText(hospitals.get(position).getHspstar());

        return convertView;
    }
}


