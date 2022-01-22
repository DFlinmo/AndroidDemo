package com.example.deomo.t1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.deomo.R;
import com.example.deomo.t2.Page;

public class Index_5 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.t1_5,container,false);
        return v;
    }

    private Button network,enter;
    private EditText address;
    private EditText ip;

    SharedPreferences mContextSp;
    SharedPreferences mActivitySp;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        network = (Button)view.findViewById(R.id.network);
        enter = (Button) view.findViewById(R.id.enter);
        address = (EditText) view.findViewById(R.id.address);
        ip = (EditText) view.findViewById(R.id.ip);
        mContextSp = Index_5.this.getActivity().getSharedPreferences( "ipdata", Context.MODE_PRIVATE );
        mActivitySp = Index_5.this.getActivity().getPreferences( Context.MODE_PRIVATE );
        mActivitySp.edit();
//        address.setText(mContextSp.getString("address",null));

        init();

    }

    private void init(){
        network.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Index_5.this.getContext());
                builder.setTitle("显示网络");
                View v = LayoutInflater.from(Index_5.this.getContext()).inflate(R.layout.t1_networkactivity,null);
                address = (EditText)v.findViewById(R.id.address);
                ip = (EditText)v.findViewById(R.id.ip);
                builder.setView(v);
                builder.setPositiveButton("修改", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        SharedPreferences.Editor editor = mContextSp.edit();
                        editor.putString("address",address.getText().toString());
                        editor.putString("ip",ip.getText().toString());
                        editor.commit();

//                        Log.i("onResponse", "修改信息成功");
                        Toast.makeText(Index_5.this.getContext(),"修改信息成功",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i("onResponse", "保存成功");
                        Toast.makeText(Index_5.this.getContext(),"保存成功",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }

        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Index_5.this.getContext(),"进入主页",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Index_5.this.getContext(), Page.class);
                startActivity(intent);
            }
        });
    }



}
