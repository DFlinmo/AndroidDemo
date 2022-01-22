package com.sfsq.demo17.T17ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.sfsq.demo3.R;

public class HomeFragment extends Fragment {

    //    private HomeViewModel homeViewModel;
//    private FragmentHomeBinding binding;
    private boolean actIsAlive = true;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.t17_fragment_home, container, false);
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }
}