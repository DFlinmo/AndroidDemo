package com.sfsq.demo17.T17adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sfsq.demo3.R;
import com.sfsq.demo17.T17Bean.ItemDeliverListBean;

import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.h> {
    final List<ItemDeliverListBean> mData;

    public ListViewAdapter(List<ItemDeliverListBean> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public h onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.t17_item_list_view, null);
        return new h(view);
    }

    @Override
    public void onBindViewHolder(@NonNull h holder, int position) {
        holder.setData(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public class h extends RecyclerView.ViewHolder {

        private TextView postName;
        private TextView companyName;
        private TextView money;
        private TextView satrTime;


        public h(@NonNull View itemView) {
            super(itemView);
            postName = (TextView) itemView.findViewById(R.id.postName);
            companyName = (TextView) itemView.findViewById(R.id.companyName);
            money = (TextView) itemView.findViewById(R.id.money);
            satrTime = (TextView) itemView.findViewById(R.id.satr_time);
        }

        public void setData(ItemDeliverListBean itemDeliverListBean) {
            postName.setText(itemDeliverListBean.postName + "");
            companyName.setText(itemDeliverListBean.companyName + "");
            money.setText(itemDeliverListBean.money + "");
            satrTime.setText(itemDeliverListBean.satrTime + "");
        }
    }
}
