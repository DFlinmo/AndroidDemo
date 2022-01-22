package com.example.demo.t12_adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

public class BookingAdapter2 extends RecyclerView.Adapter<BookingAdapter2.InnerHolder> {
    private OnItemClickListener mOnItemClickListener;

    @NonNull
    @Override
    public BookingAdapter2.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.t12_new_route2_activity,null);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingAdapter2.InnerHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    public interface OnItemClickListener{
        void onItemClick(int step, String str);
        void onItemBackClick(int backStep);
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private TextView textView2;
        private Spinner spinner8;
        private TextView textView4;
        private Spinner spinner9;
        private TextView textView5;
        private Spinner spinner10;
        private TextView textView6;
        private TextView textView7;
        private TextView textView9;
        private Button t12Next;
        private Button t12ReturnToDirectory;
        private int step = 2;
        private int backStep = 2;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            textView2 = (TextView) itemView.findViewById(R.id.textView2);
            spinner8 = (Spinner)  itemView.findViewById(R.id.spinner8);
            textView4 = (TextView)  itemView.findViewById(R.id.textView4);
            spinner9 = (Spinner)  itemView.findViewById(R.id.spinner9);
            textView5 = (TextView)  itemView.findViewById(R.id.textView5);
            spinner10 = (Spinner)  itemView.findViewById(R.id.spinner10);
            textView6 = (TextView)  itemView.findViewById(R.id.textView6);
            textView7 = (TextView)  itemView.findViewById(R.id.textView7);
            textView9 = (TextView)  itemView.findViewById(R.id.textView9);
            t12Next = (Button)  itemView.findViewById(R.id.t12_next);
            t12ReturnToDirectory = (Button)  itemView.findViewById(R.id.t12_Return_to_directory);
            spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView6.setText(spinner8.getSelectedItem().toString());
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            spinner9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView7.setText(spinner9.getSelectedItem().toString());
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            spinner10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView9.setText(spinner10.getSelectedItem().toString());
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            t12Next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null){
                        String str = textView6.getText().toString() + "-" + textView7.getText().toString() + "-"+textView9.getText().toString();
                        mOnItemClickListener.onItemClick(step,str);
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
    }
}
