package com.example.demo15.T15Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo15.T15Bean.ItemGridViewBean;
import com.example.testflask.R;

import java.util.List;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.h> {
    private final List<ItemGridViewBean> mData;

    public GridViewAdapter(List<ItemGridViewBean> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public GridViewAdapter.h onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.t15_item_grid_view, null);

        return new h(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewAdapter.h holder, int position) {
        holder.setData(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public class h extends RecyclerView.ViewHolder {
        private final TextView date;
        private final TextView temperature;
        private final TextView weather;


        public h(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            temperature = itemView.findViewById(R.id.temperature);
            weather = itemView.findViewById(R.id.weather);
        }

        public void setData(ItemGridViewBean itemGridViewBean) {
            date.setText(itemGridViewBean.date+"");
            temperature.setText(itemGridViewBean.temperature+"");
            weather.setText(itemGridViewBean.weather);


        }
    }
}
