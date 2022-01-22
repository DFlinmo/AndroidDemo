package com.example.demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.List;

import static com.example.demo.R.drawable.homepage3;

public class Ts19AllHouseAdapter extends BaseAdapter {
    List<Ts19HouseList.RowsBean> mList;
//    private List<String> pic = new ArrayList<String>();
    private Context mContext;

    public Ts19AllHouseAdapter(List<Ts19HouseList.RowsBean> mList, Ts19MainActivity mContext) {
        this.mList=mList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return  mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.ts19layout_allhouselist,parent,false);
        TextView text=(TextView) convertView.findViewById(R.id.address);
        TextView text2=(TextView) convertView.findViewById(R.id.areasize);
        TextView text3=(TextView) convertView.findViewById(R.id.price);
        TextView text4=(TextView) convertView.findViewById(R.id.description);
        ImageView text5 = (ImageView) convertView.findViewById(R.id.pic);

        text.setText((CharSequence) mList.get(position).getAddress());
        text2.setText((int) mList.get(position).getAreaSize()+"");
        text3.setText((CharSequence) mList.get(position).getPrice());
        text4.setText((CharSequence) mList.get(position).getDescription());
        text5.setImageResource(homepage3);
//        pic.add((mList.get(position).getPic()));
//        System.out.println(pic);
//        Intent intent = new Intent();
//        intent.putStringArrayListExtra("pic", (ArrayList<String>) pic);
        return convertView;
    }
}
