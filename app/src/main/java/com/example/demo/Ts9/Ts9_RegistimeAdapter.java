package com.example.demo.Ts9;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.List;

public class Ts9_RegistimeAdapter extends BaseAdapter {

    List<Ts9_Registime> registimes = new ArrayList<Ts9_Registime>();
    private Context context;

    public Ts9_RegistimeAdapter(List<Ts9_Registime> registimes, Context context) {
        this.registimes = registimes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return registimes.size();
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
        private TextView deptname;
        private TextView depttime;
        private Button regist;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Ts9_RegistimeAdapter.ViewHolder holder;
        if(view == null){
            holder = new Ts9_RegistimeAdapter.ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.ts9_commonlist,viewGroup,false);
            holder.deptname = (TextView)view.findViewById(R.id.deptname);
            holder.depttime = (TextView)view.findViewById(R.id.depttime);
            holder.regist = (Button) view.findViewById(R.id.reserve);
            view.setTag(holder);
        }else {
            holder = (Ts9_RegistimeAdapter.ViewHolder)view.getTag();
        }
        holder.deptname.setText(registimes.get(i).getDeptname());
        holder.depttime.setText(registimes.get(i).getDepttime());

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击·传值
                SharedPreferences sps = context.getSharedPreferences("regist",context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sps.edit();
                editor.putString("registname",registimes.get(i).getDeptname());
                editor.putString("registtime",registimes.get(i).getDepttime());
                editor.putString("registtype",registimes.get(i).getDepttype());
                editor.commit();
                System.out.println("registimes.get(i).getDepttype()=="+registimes.get(i).getDepttype());
                //页面跳转
                Intent intent = new Intent(context, Ts9_RegistSuccess.class);
                context.startActivity(intent);
            }
        };
        holder.regist.setOnClickListener(listener);
        return view;
    }
//    private class registListen implements View.OnClickListener{
//        int position;
//        public registListen(int position){
//            this.position = position;
//        }
//
//        @Override
//        public void onClick(View view) {
//
//        }
//    }
//    public interface IDclassControl{
//        public
//    }
}
