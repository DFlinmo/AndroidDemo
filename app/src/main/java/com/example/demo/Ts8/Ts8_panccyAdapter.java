package com.example.demo.Ts8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.List;

public class Ts8_panccyAdapter extends BaseAdapter {

    private List<Ts8_panccy> panlist = new ArrayList<Ts8_panccy>();
    private Context context;

    public Ts8_panccyAdapter(List<Ts8_panccy> panlist, Context context){
        this.panlist = panlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return panlist.size();
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
        private TextView parea;
        private TextView pscore;
        private TextView pmoney;
        private TextView pdate;
        private TextView phandle;
        private TextView pcarid;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();

            convertView = LayoutInflater.from(context).inflate(R.layout.ts8_panccy_list,parent,false);
            holder.parea = (TextView)convertView.findViewById(R.id.area);
            holder.pscore = (TextView)convertView.findViewById(R.id.score);
            holder.pmoney = (TextView)convertView.findViewById(R.id.money);
            holder.pdate = (TextView)convertView.findViewById(R.id.date);
            holder.phandle = (TextView)convertView.findViewById(R.id.handle);
            holder.pcarid = (TextView)convertView.findViewById(R.id.carid);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.parea.setText(panlist.get(position).getArea());
        holder.pscore.setText(panlist.get(position).getScore());
        holder.pmoney.setText(panlist.get(position).getMoney());
        holder.pdate.setText(panlist.get(position).getDate());
        holder.phandle.setText(panlist.get(position).getHandle());
        holder.pcarid.setText(panlist.get(position).getCarid());

        return convertView;
    }
}
