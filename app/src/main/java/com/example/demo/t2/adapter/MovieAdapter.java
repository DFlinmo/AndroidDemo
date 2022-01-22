package com.example.deomo.t2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.deomo.R;
import com.example.deomo.t2.bean.M_List;

import java.util.List;

public class MovieAdapter extends BaseAdapter {



    private List<M_List.RowsDTO> rows;
    private Context context;

    public MovieAdapter() {
    }


    public MovieAdapter(List<M_List.RowsDTO> rows, Context context) {
        this.rows = rows;
        this.context = context;
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
        private TextView movies_title;
        private TextView des;
        private TextView language;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = new ViewHolder();
        view = LayoutInflater.from(context).inflate(R.layout.t2_mlist,viewGroup,false);
        holder.movies_title = (TextView) view.findViewById(R.id.movies_title);
        holder.des = (TextView) view.findViewById(R.id.des);
        holder.language = (TextView) view.findViewById(R.id.language);

        holder.movies_title.setText("片名:\t《"+rows.get(i).getName()+"》");
        holder.des.setText("简要描述:\t"+rows.get(i).getIntroduction());
        holder.language.setText("语言:\t"+rows.get(i).getLanguage());
        return view;
    }


}
