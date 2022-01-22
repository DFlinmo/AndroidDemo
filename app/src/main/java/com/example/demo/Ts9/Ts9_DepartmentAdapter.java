package com.example.demo.Ts9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.List;

public class Ts9_DepartmentAdapter extends BaseAdapter {
    private List<Ts9_Department> depart = new ArrayList<Ts9_Department>();
    private Context context;

    public Ts9_DepartmentAdapter(List<Ts9_Department> depart, Context context) {
        this.depart = depart;
        this.context = context;
    }

    @Override
    public int getCount() {
        return depart.size();
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
        private TextView deptid;
        private TextView depttype;
        private TextView deptname;
        private TextView deptcost;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Ts9_DepartmentAdapter.ViewHolder holder;
        if(view == null){
            holder = new Ts9_DepartmentAdapter.ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.ts9_departmentlist,viewGroup,false);
            holder.deptid = (TextView) view.findViewById(R.id.dptid);
            holder.depttype = (TextView) view.findViewById(R.id.dpttype);
            holder.deptname = (TextView)view.findViewById(R.id.dptname);
            holder.deptcost = (TextView)view.findViewById(R.id.dptcost);

            view.setTag(holder);
        }else {
            holder = (Ts9_DepartmentAdapter.ViewHolder)view.getTag();
        }
        holder.deptid.setText(String.valueOf(depart.get(i).getDeptid()));
        holder.depttype.setText(depart.get(i).getDepttype());
        holder.deptname.setText(depart.get(i).getDeptname());
        holder.deptcost.setText(depart.get(i).getDeptcost());

        return view;
    }
}
