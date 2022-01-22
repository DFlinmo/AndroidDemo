package com.example.demo.t12_adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.demo.t12_Bean.T12_Order_Info;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.InnerHolder> {
    private List<T12_Order_Info> mData;

    public OrderAdapter(List<T12_Order_Info> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public OrderAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.t12_order_activity2,null);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.InnerHolder holder, int position) {
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mData != null){
            return mData.size();
        }
        return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private TextView textView13;
        private TextView path;
        private TextView orderName;
        private TextView orderStartName;
        private TextView textView24;
        private TextView orderEndName;
        private TextView textView26;
        private TextView price;
        private TextView textView30;
        private TextView time;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            textView13 = (TextView) itemView.findViewById(R.id.textView13);
            path = (TextView) itemView.findViewById(R.id.t12_path);
            orderName = (TextView) itemView.findViewById(R.id.order_name);
            orderStartName = (TextView) itemView.findViewById(R.id.order_startName);
            textView24 = (TextView) itemView.findViewById(R.id.textView24);
            orderEndName = (TextView) itemView.findViewById(R.id.order_endName);
            textView26 = (TextView) itemView.findViewById(R.id.textView26);
            price = (TextView) itemView.findViewById(R.id.price);
            textView30 = (TextView) itemView.findViewById(R.id.textView30);
            time = (TextView) itemView.findViewById(R.id.time);
        }

        public void setData(T12_Order_Info t12_order_info) {
            path.setText(t12_order_info.getOrderNum());
            orderName.setText(t12_order_info.getPath());
            orderStartName.setText(t12_order_info.getStart());
            orderEndName.setText(t12_order_info.getEnd());
            price.setText(String.valueOf(t12_order_info.getPrice()));
            time.setText(t12_order_info.getTime());
        }
    }
}
