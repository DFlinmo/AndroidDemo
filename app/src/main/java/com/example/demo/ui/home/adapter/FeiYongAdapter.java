package com.example.demo.ui.home.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.demo.ui.home.Bean.FeiYongBean;

public class FeiYongAdapter extends RecyclerView.Adapter<FeiYongAdapter.InnerHolder> {
    private FeiYongBean mData;

    public FeiYongAdapter(FeiYongBean mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public FeiYongAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.t13_new_electricity,null);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeiYongAdapter.InnerHolder holder, int position) {
        holder.setData(mData);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private TextView qianfei;
        private TextView textView6;
        private TextView t13Address;
        private TextView textView8;
        private TextView t13Name;
        private TextView textView10;
        private TextView t13Balance;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            qianfei = (TextView) itemView.findViewById(R.id.qianfei);
            textView6 = (TextView) itemView.findViewById(R.id.textView6);
            t13Address = (TextView) itemView.findViewById(R.id.t13_address);
            textView8 = (TextView) itemView.findViewById(R.id.textView8);
            t13Name = (TextView) itemView.findViewById(R.id.t12_name);
            textView10 = (TextView) itemView.findViewById(R.id.textView10);
            t13Balance = (TextView) itemView.findViewById(R.id.t13_balance);
        }

        public void setData(FeiYongBean mData) {
            qianfei.setText("您目前暂无欠费");
            t13Address.setText(mData.getAddress());
            t13Name.setText(mData.getOwnerName());
            t13Balance.setText(mData.getBalance());
        }
    }
}
