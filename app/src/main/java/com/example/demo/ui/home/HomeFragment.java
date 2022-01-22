package com.example.demo.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.demo.R;
import com.example.demo.databinding.T13FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private T13FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.t13_fragment_home,container,false);
        Button electricity = (Button) v.findViewById(R.id.electricity_bill);
        Button  water = (Button) v.findViewById(R.id.water_bill);
        electricity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(v.getContext(), Electricity_Fees.class);
                intent.putExtra("params", "electricity");
                startActivity(intent);
            }
        });

        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(v.getContext(), Electricity_Fees.class);
                intent.putExtra("params", "electricity");
                startActivity(intent);
            }
        });
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}