package com.example.demo.t12_adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

import java.util.Map;

public class BookingAdapter4 extends RecyclerView.Adapter<BookingAdapter4.InnerHolder> {
    private Map<String,String> mData;
    private OnItemClickListener mOnItemClickListener;

    public BookingAdapter4(Map<String, String> mData) {
        this.mData = mData;
    }


    @NonNull
    @Override
    public BookingAdapter4.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.t12_new_route4_activity,null);
        return new InnerHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull BookingAdapter4.InnerHolder holder, int position) {
        holder.setData(mData);
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public void setOnItemClickListener(BookingAdapter4.OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    public interface OnItemClickListener{
        void onItemClick();
        void onItemBackClick();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private TextView textView10;
        private TextView t133StartName;
        private TextView textView20;
        private TextView t133EndName;
        private TextView textView11;
        private TextView name;
        private TextView textView12;
        private TextView tel;
        private TextView textView14;
        private TextView upCar;
        private TextView textView17;
        private TextView downCar;
        private TextView textView18;
        private TextView t123Time;
        private Button t12Next;
        private Button t12ReturnToDirectory;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            textView10 = (TextView) itemView.findViewById(R.id.textView10);
            t133StartName = (TextView) itemView.findViewById(R.id.t13_3_startName);
            textView20 = (TextView) itemView.findViewById(R.id.textView20);
            t133EndName = (TextView) itemView.findViewById(R.id.t13_3_endName);
            textView11 = (TextView) itemView.findViewById(R.id.textView11);
            name = (TextView) itemView.findViewById(R.id.name);
            textView12 = (TextView) itemView.findViewById(R.id.textView12);
            tel = (TextView) itemView.findViewById(R.id.tel);
            textView14 = (TextView) itemView.findViewById(R.id.textView14);
            upCar = (TextView) itemView.findViewById(R.id.upCar);
            textView17 = (TextView) itemView.findViewById(R.id.textView17);
            downCar = (TextView) itemView.findViewById(R.id.downCar);
            textView18 = (TextView) itemView.findViewById(R.id.textView18);
            t123Time = (TextView) itemView.findViewById(R.id.t12_3_time);
            t12Next = (Button) itemView.findViewById(R.id.t12_next);
            t12ReturnToDirectory = (Button) itemView.findViewById(R.id.t12_Return_to_directory);

            t12Next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null){
                        mOnItemClickListener.onItemClick();
                    }
                }
            });
            t12ReturnToDirectory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null){
                        mOnItemClickListener.onItemBackClick();
                    }
                }
            });
        }

        public void setData(Map<String, String> mData) {
            t133StartName.setText(mData.get("startName"));
            t133EndName.setText(mData.get("endName"));
            name.setText(mData.get("name"));
            tel.setText(mData.get("tel"));
            upCar.setText(mData.get("upCar"));
            downCar.setText(mData.get("downCar"));
            t123Time.setText(mData.get("time"));
        }
    }
}
