package com.example.demo.Ts10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.List;

public class Ts10_CarmanagerAdapter extends BaseAdapter {

    List<Ts10_Carmanager> carmanagers = new ArrayList<Ts10_Carmanager>();
    private Context context;

    public Ts10_CarmanagerAdapter(List<Ts10_Carmanager> carmanagers, Context context) {
        this.carmanagers = carmanagers;
        this.context = context;
    }

    @Override
    public int getCount() {
        return carmanagers.size();
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
        private EditText carnum1;
        private EditText parkingSpace1;
        private EditText parkingCardNumber1;
        private EditText ownerSName1;
        private EditText ownersTel1;
        private EditText residentName1;
        private EditText address1;
        private Button editor;
        private Button save;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.ts10_carmanagerlist,viewGroup,false);
            holder.carnum1 = (EditText) view.findViewById(R.id.carnum);
            holder.parkingSpace1 = (EditText) view.findViewById(R.id.parkingSpace);
            holder.parkingCardNumber1 = (EditText) view.findViewById(R.id.parkingCardNumber);
            holder.ownerSName1 = (EditText) view.findViewById(R.id.ownerSName);
            holder.ownersTel1 = (EditText) view.findViewById(R.id.ownersTel);
            holder.residentName1 = (EditText) view.findViewById(R.id.residentName);
            holder.address1 = (EditText) view.findViewById(R.id.address);
            holder.editor = (Button) view.findViewById(R.id.editor);
            holder.save = (Button) view.findViewById(R.id.save);

            view.setTag(holder);
        }else {
            holder = (Ts10_CarmanagerAdapter.ViewHolder)view.getTag();
        }
        holder.carnum1.setText("车牌号：\t"+carmanagers.get(i).getCarnum());
        holder.parkingSpace1.setText("车位号：\t"+carmanagers.get(i).getParkingSpace());
        holder.parkingCardNumber1.setText("停车卡号：\t"+carmanagers.get(i).getParkingCardNumber());
        holder.ownerSName1.setText("车主姓名：\t"+carmanagers.get(i).getOwnerSName());
        holder.ownersTel1.setText("车主手机号：\t"+carmanagers.get(i).getOwnersTel());
        holder.residentName1.setText("住户姓名：\t"+carmanagers.get(i).getResidentName());
        holder.address1.setText("地址：\t"+carmanagers.get(i).getAddress());

//        将输入框设置为不可编辑
        holder.carnum1.setFocusable(false);
        holder.carnum1.setFocusableInTouchMode(false);
        holder.carnum1.setOnClickListener(null);

        holder.parkingSpace1.setFocusable(false);
        holder.parkingSpace1.setFocusableInTouchMode(false);
        holder.parkingSpace1.setOnClickListener(null);

        holder.parkingCardNumber1.setFocusable(false);
        holder.parkingCardNumber1.setFocusableInTouchMode(false);
        holder.parkingCardNumber1.setOnClickListener(null);

        holder.ownerSName1.setFocusable(false);
        holder.ownerSName1.setFocusableInTouchMode(false);
        holder.ownerSName1.setOnClickListener(null);

        holder.ownersTel1.setFocusable(false);
        holder.ownersTel1.setFocusableInTouchMode(false);
        holder.ownersTel1.setOnClickListener(null);

        holder.residentName1.setFocusable(false);
        holder.residentName1.setFocusableInTouchMode(false);
        holder.residentName1.setOnClickListener(null);

        holder.address1.setFocusable(false);
        holder.address1.setFocusableInTouchMode(false);
        holder.address1.setOnClickListener(null);



        View.OnClickListener editorlistener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //                将输入框设置为不可编辑
                holder.carnum1.setFocusable(true);
                holder.carnum1.setFocusableInTouchMode(true);

                holder.parkingSpace1.setFocusable(true);
                holder.parkingSpace1.setFocusableInTouchMode(true);

                holder.parkingCardNumber1.setFocusable(true);
                holder.parkingCardNumber1.setFocusableInTouchMode(true);

                holder.ownerSName1.setFocusable(true);
                holder.ownerSName1.setFocusableInTouchMode(true);

                holder.ownersTel1.setFocusable(true);
                holder.ownersTel1.setFocusableInTouchMode(true);

                holder.residentName1.setFocusable(true);
                holder.residentName1.setFocusableInTouchMode(true);

                holder.address1.setFocusable(true);
                holder.address1.setFocusableInTouchMode(true);
            }
        };
        holder.editor.setOnClickListener(editorlistener);

        View.OnClickListener savelistener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //将输入框设置为不可编辑
                holder.carnum1.setFocusable(false);
                holder.carnum1.setFocusableInTouchMode(false);
                holder.carnum1.setOnClickListener(null);

                holder.parkingSpace1.setFocusable(false);
                holder.parkingSpace1.setFocusableInTouchMode(false);
                holder.parkingSpace1.setOnClickListener(null);

                holder.parkingCardNumber1.setFocusable(false);
                holder.parkingCardNumber1.setFocusableInTouchMode(false);
                holder.parkingCardNumber1.setOnClickListener(null);

                holder.ownerSName1.setFocusable(false);
                holder.ownerSName1.setFocusableInTouchMode(false);
                holder.ownerSName1.setOnClickListener(null);

                holder.ownersTel1.setFocusable(false);
                holder.ownersTel1.setFocusableInTouchMode(false);
                holder.ownersTel1.setOnClickListener(null);

                holder.residentName1.setFocusable(false);
                holder.residentName1.setFocusableInTouchMode(false);
                holder.residentName1.setOnClickListener(null);

                holder.address1.setFocusable(false);
                holder.address1.setFocusableInTouchMode(false);
                holder.address1.setOnClickListener(null);
            }
        };
        holder.save.setOnClickListener(savelistener);
        return view;
    }



}
