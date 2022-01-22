package com.example.demo.ui.dashboard.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

public class JieMianAdapter extends RecyclerView.Adapter<JieMianAdapter.InnerHolder> {
    private String[] str;

    public JieMianAdapter(String[] str) {
        this.str = str;
    }

    @NonNull
    @Override
    public JieMianAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.t13_jiemian,null);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JieMianAdapter.InnerHolder holder, int position) {
        holder.setData(str[position]);
    }

    @Override
    public int getItemCount() {
        if (str != null){
            return str.length;
        }
        return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private Button button;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.jiemian_feiyong);
//            button = (Button) itemView.findViewById(R.id.jiemian_add);


        }


        public void setData(String s) {
            textView.setText(s);
        }
    }
}
