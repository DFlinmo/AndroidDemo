package com.sfsq.demo16.T16ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sfsq.demo16.T16Bean.ItemMoveCarHistoryBean;
import com.sfsq.demo2.R;

import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.h> {
    final List<ItemMoveCarHistoryBean> mData;

    public ListViewAdapter(List<ItemMoveCarHistoryBean> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public ListViewAdapter.h onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.t16_item_list_view_history_layout, null);


        return new h(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewAdapter.h holder, int position) {
        holder.setData(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public class h extends RecyclerView.ViewHolder {

        private TextView plateNo;
        private TextView tel;
        private TextView address;



        public h(@NonNull View itemView) {
            super(itemView);
            plateNo = (TextView)  itemView.findViewById(R.id.plate_no);
            tel = (TextView) itemView.findViewById(R.id.tel);
            address = (TextView) itemView.findViewById(R.id.address);
        }

        public void setData(ItemMoveCarHistoryBean itemMoveCarHistoryBean) {
            plateNo.setText(""+itemMoveCarHistoryBean.PlateNo);
            address.setText(""+itemMoveCarHistoryBean.address);
            tel.setText(""+itemMoveCarHistoryBean.tel);
        }
    }
}
