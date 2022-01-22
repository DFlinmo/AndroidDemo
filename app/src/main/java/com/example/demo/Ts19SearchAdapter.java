package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.demo.R.drawable.homepage3;

public class Ts19SearchAdapter extends BaseAdapter{
	private List<Ts19HouseList.RowsBean> mlist = new ArrayList<>();
	Context ct;
	private LayoutInflater inflater;
	public Ts19SearchAdapter(Context ct, List<Ts19HouseList.RowsBean> mlist) {
		this.mlist = mlist;
		this.ct = ct;
		inflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mlist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mlist.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Ts19HouseList.RowsBean p = mlist.get(position);
		if(convertView==null){
			convertView = inflater.inflate(R.layout.ts19layout_houselist, null);
		}
		TextView text = (TextView) convertView.findViewById(R.id.address);
		TextView text2 = (TextView) convertView.findViewById(R.id.areasize);
		TextView text3 = (TextView) convertView.findViewById(R.id.price);
		TextView text4 = (TextView) convertView.findViewById(R.id.description);
		TextView text6 = (TextView) convertView.findViewById(R.id.ershou);
		ImageView text5 = (ImageView) convertView.findViewById(R.id.pic);

		text.setText((CharSequence) mlist.get(position).getAddress());
		text2.setText((int) mlist.get(position).getAreaSize() + "");
		text3.setText((CharSequence) mlist.get(position).getPrice());
		text4.setText((CharSequence) mlist.get(position).getDescription());
		text6.setText((CharSequence) mlist.get(position).getHouseType());
		Button ershou= (Button) convertView.findViewById(R.id.Ershou);
		text5.setImageResource(homepage3);


		return convertView;
	}
}
