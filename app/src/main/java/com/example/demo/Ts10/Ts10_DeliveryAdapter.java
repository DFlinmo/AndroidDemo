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

public class Ts10_DeliveryAdapter extends BaseAdapter {

    List<Ts10_Delivery> deliveries = new ArrayList<Ts10_Delivery>();
    private Context context;

    public Ts10_DeliveryAdapter(List<Ts10_Delivery> deliveries, Context context) {
        this.deliveries = deliveries;
        this.context = context;
    }

    @Override
    public int getCount() {
        return deliveries.size();
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
        private TextView name;
        private TextView waybillNumber;
        private TextView pickupCode;
        private TextView telephone;
        private ImageView scanode;

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();

            view = LayoutInflater.from(context).inflate(R.layout.ts10_deliverylist,viewGroup,false);
            holder.name = (TextView) view.findViewById(R.id.name);
            holder.waybillNumber = (TextView) view.findViewById(R.id.waybillNumber);
            holder.pickupCode = (TextView) view.findViewById(R.id.pickupCode);
            holder.telephone = (TextView) view.findViewById(R.id.telephone);
            holder.scanode = (ImageView) view.findViewById(R.id.scanode);


            view.setTag(holder);
        }else {
            holder = (Ts10_DeliveryAdapter.ViewHolder)view.getTag();
        }
        holder.name.setText("姓名：\t"+deliveries.get(i).getName());
        holder.waybillNumber.setText("运单号：\t"+deliveries.get(i).getWaybillNumber());
        holder.pickupCode.setText("取件码：\t"+deliveries.get(i).getPickupCode());
        holder.telephone.setText("手机尾号：\t"+deliveries.get(i).getTelephone());

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"扫码取件！！",Toast.LENGTH_SHORT).show();
            }
        };
        holder.scanode.setOnClickListener(listener);

        return view;
    }
}
