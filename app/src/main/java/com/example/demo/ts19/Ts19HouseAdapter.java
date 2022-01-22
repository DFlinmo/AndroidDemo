package com.example.demo.ts19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.R;

import java.util.List;

import static com.example.demo.R.drawable.homepage3;

public class Ts19HouseAdapter extends BaseAdapter  {
    private List<Ts19HouseList.RowsBean> mList;
    //    private List<String> pic = new ArrayList<String>();
    private Context mContext;

    public Ts19HouseAdapter(List<Ts19HouseList.RowsBean> mList, Ts19MainActivity mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(mContext).inflate(R.layout.ts19layout_houselist, parent, false);
        TextView text = (TextView) convertView.findViewById(R.id.address);
        TextView text2 = (TextView) convertView.findViewById(R.id.areasize);
        TextView text3 = (TextView) convertView.findViewById(R.id.price);
        TextView text4 = (TextView) convertView.findViewById(R.id.description);
        TextView text6 = (TextView) convertView.findViewById(R.id.ershou);
        ImageView text5 = (ImageView) convertView.findViewById(R.id.pic);

        text.setText((CharSequence) mList.get(position).getAddress());
        text2.setText((int) mList.get(position).getAreaSize() + "");
        text3.setText((CharSequence) mList.get(position).getPrice());
        text4.setText((CharSequence) mList.get(position).getDescription());
        text6.setText((CharSequence) mList.get(position).getHouseType());
        Button ershou= (Button) convertView.findViewById(R.id.Ershou);
        text5.setImageResource(homepage3);
//        pic.add((mList.get(position).getPic()));
//        System.out.println(pic);
//        Intent intent = new Intent();
//        intent.putStringArrayListExtra("pic", (ArrayList<String>) pic);


            return convertView;
    }

}