package com.example.deomo.t2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.deomo.R;
import com.example.deomo.t2.bean.PressList;

import java.util.List;

public class MyNewsAdapter extends BaseAdapter {
    private Context context;
    List<PressList.RowsDTO> rows;

    public MyNewsAdapter() {
    }

    public MyNewsAdapter(List<PressList.RowsDTO> rows, Context context) {
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
        private ImageView new_img;
        private TextView new_title;
        private TextView new_content;
        private TextView comment;
        private TextView time;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder= new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.t2_newslist,viewGroup,false);
//            holder.new_img = (ImageView) view.findViewById(R.id.new_img);
            holder.new_title = (TextView) view.findViewById(R.id.new_title);
            holder.new_content = (TextView) view.findViewById(R.id.new_content);
            holder.comment = (TextView) view.findViewById(R.id.comment);
            holder.time = (TextView) view.findViewById(R.id.time);
            holder.new_title.setText(rows.get(i).getTitle());
            holder.new_content.setText(rows.get(i).getContent());
            holder.comment.setText("评论人数:"+String.valueOf(rows.get(i).getCommentNum()));
            holder.time.setText("发布时间"+rows.get(i).getCreateTime());
            return view;
    }

}
