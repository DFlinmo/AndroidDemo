package com.example.demo.t12_adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

import java.util.HashMap;
import java.util.Map;

public class BookingAdapter3 extends RecyclerView.Adapter<BookingAdapter3.InnerHolder> {
    private Map<String,String> mData;
    private BookingAdapter3.OnItemClickListener mOnItemClickListener;

    public BookingAdapter3(Map<String, String> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public BookingAdapter3.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.t12_new_route3_activity,null);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingAdapter3.InnerHolder holder, int position) {
        holder.setData(mData);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public void setOnItemClickListener(BookingAdapter3.OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    public interface OnItemClickListener{
        void onItemBackClick(int backStep);
        void onItemClick(int step, Map<String, String> map);
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private TextView textView10;
        private TextView t133StartName;
        private TextView t133EndName;
        private TextView textView11;
        private EditText edit1;
        private TextView textView12;
        private EditText edit2;
        private TextView textView14;
        private EditText edit3;
        private TextView textView17;
        private EditText edit4;
        private TextView textView18;
        private TextView time;
        private Button t12Next;
        private int step = 3;
        private int backStep = 3;
        private Button t12ReturnToDirectory;
        private Map<String,String> map = new HashMap<>();
        private AlertDialog.Builder builder;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            textView10 = (TextView) itemView.findViewById(R.id.textView10);
            t133StartName = (TextView) itemView.findViewById(R.id.t13_3_startName);
            t133EndName = (TextView) itemView.findViewById(R.id.t13_3_endName);
            textView11 = (TextView) itemView.findViewById(R.id.textView11);
            edit1 = (EditText) itemView.findViewById(R.id.edit1);
            textView12 = (TextView) itemView.findViewById(R.id.textView12);
            edit2 = (EditText) itemView.findViewById(R.id.edit2);
            textView14 = (TextView) itemView.findViewById(R.id.textView14);
            edit3 = (EditText) itemView.findViewById(R.id.edit3);
            textView17 = (TextView) itemView.findViewById(R.id.textView17);
            edit4 = (EditText) itemView.findViewById(R.id.edit4);
            textView18 = (TextView) itemView.findViewById(R.id.textView18);
            time = (TextView) itemView.findViewById(R.id.t12_3_time);
            t12Next = (Button) itemView.findViewById(R.id.t12_next);
            t12ReturnToDirectory = (Button) itemView.findViewById(R.id.t12_Return_to_directory);

            t12Next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!edit1.getText().toString().isEmpty() &&
                            !edit2.getText().toString().isEmpty() &&
                            !edit3.getText().toString().isEmpty() &&
                            !edit4.getText().toString().isEmpty()) {
                        if (mOnItemClickListener != null){
                            map.put("startName",t133StartName.getText().toString());
                            map.put("endName",t133EndName.getText().toString());
                            map.put("time",time.getText().toString());
                            map.put("name",edit1.getText().toString());
                            map.put("tel",edit2.getText().toString());
                            map.put("upCar",edit3.getText().toString());
                            map.put("downCar",edit4.getText().toString());
                            mOnItemClickListener.onItemClick(step,map);
                        }
                    }else {
                        builder = new AlertDialog.Builder(itemView.getContext());
                        builder.setTitle("提示");
                        builder.setMessage("输入框中有一处为空，请检查");
                        builder.setPositiveButton("确定", null);
                        builder.show();

                    }
                }
            });
            t12ReturnToDirectory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null){
                        mOnItemClickListener.onItemBackClick(backStep);
                    }
                }
            });
        }

        public void setData(Map<String, String> mData) {
            t133StartName.setText(mData.get("startName"));
            t133EndName.setText(mData.get("endName"));
            time.setText(mData.get("time"));
        }
    }
}
