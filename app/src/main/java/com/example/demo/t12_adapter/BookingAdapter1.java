package com.example.demo.t12_adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.demo.t12_Bean.T12_Bus_Site_Info;

import java.util.List;

public class BookingAdapter1 extends RecyclerView.Adapter<BookingAdapter1.InnerHolder>{
    public List<T12_Bus_Site_Info> mData;
    private OnItemClickListener mOnItemClickListener;

    public BookingAdapter1(List<T12_Bus_Site_Info> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public BookingAdapter1.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.t12_new_route1_activity,null);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingAdapter1.InnerHolder holder, int position) {
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if(mData != null){
            return mData.size();
        }
        return 0;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;

    }


    public interface OnItemClickListener{
        void onItemClick(int step, String name, String startName, String endName);
        void onItemBackClick(int backStep);
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private LinearLayout topView;
        private TextView t12Route1RoutestartName;
        private TextView textView4;
        private TextView t12Route1RouteEndName;
        private TextView textView5;
        private TextView t12Route1Money;
        private TextView textView6;
        private TextView t12Route1Distance;
        private Button t12Next;
        private int step = 1;
        private int backStep = -1;
        private String startName = null;
        private String endName = null;
        private String path;
        private Button t12ReturnToDirectory;


        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            topView = (LinearLayout) itemView.findViewById(R.id.top_view);
            t12Route1RoutestartName = (TextView) itemView.findViewById(R.id.t12_route1_routestartName);
            textView4 = (TextView) itemView.findViewById(R.id.textView4);
            t12Route1RouteEndName = (TextView) itemView.findViewById(R.id.t12_route1_routeEndName);
            textView5 = (TextView) itemView.findViewById(R.id.textView5);
            t12Route1Money = (TextView) itemView.findViewById(R.id.t12_route1_money);
            textView6 = (TextView) itemView.findViewById(R.id.textView6);
            t12Route1Distance = (TextView) itemView.findViewById(R.id.t12_route1_distance);
            t12Next = (Button) itemView.findViewById(R.id.t12_next);
            t12ReturnToDirectory = (Button) itemView.findViewById(R.id.t12_Return_to_directory);
            t12Next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null){
                        startName = t12Route1RoutestartName.getText().toString();
                        endName = t12Route1RouteEndName.getText().toString();
                        mOnItemClickListener.onItemClick(step,startName,endName,path);
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

        public void setData(T12_Bus_Site_Info t12_bus_site_info) {
            path = t12_bus_site_info.getName();
            t12Route1RoutestartName.setText(t12_bus_site_info.getFirst());
            t12Route1RouteEndName.setText(t12_bus_site_info.getEnd());
            t12Route1Money.setText(String.valueOf(t12_bus_site_info.getPrice()));
            t12Route1Distance.setText(t12_bus_site_info.getMileage());
        }
    }
}
