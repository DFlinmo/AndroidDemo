package com.example.demo.t12_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.demo.R;
import com.example.demo.t12_Bean.T12_Bus_Site_Info;
import com.example.demo.t12_Bean.T12_parmsBean;

import java.util.List;

public class RouteSituationAdapter extends BaseExpandableListAdapter {
    private List<T12_Bus_Site_Info> groupData;

    public RouteSituationAdapter(List<T12_Bus_Site_Info> groupData, List<List<List<T12_parmsBean>>> childData, Context ma) {
        this.groupData = groupData;
        this.childData = childData;
        this.ma = ma;
    }

    private List<List<List<T12_parmsBean>>> childData;
    private Context ma;
    @Override
    public int getGroupCount() {
        return groupData.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return childData.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return groupData.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return childData.get(i).get(i).get(i1).getName();
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //一下为添加数据
    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        GroupViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(ma).inflate(R.layout.t12_layout_group, null);
            holder = new GroupViewHolder();
            holder.routestartName = (TextView)view.findViewById(R.id.routestartName) ;
            holder.routeEndName = (TextView)view.findViewById(R.id.routeEndName);
            holder.number = (TextView) view.findViewById(R.id.number);
            holder.textView3 = (TextView) view.findViewById(R.id.textView3);
            holder.money = (TextView) view.findViewById(R.id.money);
            holder.textView8 = (TextView) view.findViewById(R.id.textView8);
            holder.distance = (TextView) view.findViewById(R.id.distance);
            holder.starttime = (TextView) view.findViewById(R.id.start_time);
            holder.endtime = (TextView) view.findViewById(R.id.end_time);
            holder.number.setText(groupData.get(i).getName());
            holder.starttime.setText(groupData.get(i).getStartTime());
            holder.endtime.setText(groupData.get(i).getEndTime());
            holder.money.setText(String.valueOf(groupData.get(i).getPrice()));
            holder.distance.setText(groupData.get(i).getMileage());
            holder.routestartName.setText(groupData.get(i).getFirst());
            holder.routeEndName.setText(groupData.get(i).getEnd());
        } else {
            holder = (GroupViewHolder) view.getTag();
        }

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(ma).inflate(R.layout.t12_layout_child, null);
            holder = new ChildViewHolder();
            holder.v1 = view.findViewById(R.id.v1);
            holder.v2 = view.findViewById(R.id.v2);
            holder.v3 = view.findViewById(R.id.v3);
            holder.v4 = view.findViewById(R.id.v4);
            if (i != 2){
                holder.v1.setText(childData.get(i).get(i1).get(0).getName());
                holder.v2.setText(childData.get(i).get(i1).get(1).getName());
                holder.v3.setText(childData.get(i).get(i1).get(2).getName());
                holder.v4.setText(childData.get(i).get(i1).get(3).getName());

            }else {
                if (i1 == 2){
                    holder.v1.setText(childData.get(i).get(i1).get(0).getName());
                    holder.v2.setText(childData.get(i).get(i1).get(1).getName());
                    holder.v3.setText(childData.get(i).get(i1).get(2).getName());
                    holder.v4.setVisibility(View.GONE);
                }else {
                    holder.v1.setText(childData.get(i).get(i1).get(0).getName());
                    holder.v2.setText(childData.get(i).get(i1).get(1).getName());
                    holder.v3.setText(childData.get(i).get(i1).get(2).getName());
                    holder.v4.setText(childData.get(i).get(i1).get(3).getName());
                }

            }

        } else {
            holder = (ChildViewHolder) view.getTag();
        }
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    class GroupViewHolder {
        TextView number;
        TextView routestartName;
        TextView routeEndName;
        TextView textView3;
        TextView money;
        TextView textView8;
        TextView distance;
        TextView starttime;
        TextView endtime;

    }

    class ChildViewHolder {
        TextView v1;
        TextView v2;
        TextView v3;
        TextView v4;
    }
}
