package com.example.demo.Ts10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.List;

public class Ts10_PropertyAdapter extends BaseAdapter {
    List<Ts10_property> properties = new ArrayList<Ts10_property>();
    private Context context;

    public Ts10_PropertyAdapter(List<Ts10_property> properties, Context context) {
        this.properties = properties;
        this.context = context;
    }

    @Override
    public int getCount() {
        return properties.size();
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
        private TextView division_tel;
        private TextView division_name;
        private ImageView call;
        private TextView feedback;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Ts10_PropertyAdapter.ViewHolder holder;
        if(view == null){
            holder = new Ts10_PropertyAdapter.ViewHolder();

            view = LayoutInflater.from(context).inflate(R.layout.ts10_propertylist,viewGroup,false);
            holder.division_tel = (TextView)view.findViewById(R.id.division_tel);
            holder.division_name = (TextView)view.findViewById(R.id.division_name);
            holder.call = (ImageView) view.findViewById(R.id.call);
            holder.feedback = (TextView) view.findViewById(R.id.feedback);


            view.setTag(holder);
        }else {
            holder = (Ts10_PropertyAdapter.ViewHolder)view.getTag();
        }
        holder.division_tel.setText(properties.get(i).getDivtel());
        holder.division_name.setText(properties.get(i).getDivname());

        View.OnClickListener calllistener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"打电话打电话！！",Toast.LENGTH_SHORT).show();
            }
        };
        View.OnClickListener feetlistener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"反馈反馈！！！",Toast.LENGTH_SHORT).show();
            }
        };
        holder.feedback.setOnClickListener(feetlistener);

        holder.call.setOnClickListener(calllistener);
        return view;
    }
}
