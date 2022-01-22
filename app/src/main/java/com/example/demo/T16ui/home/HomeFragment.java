package com.sfsq.demo16.T16ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.sfsq.demo16.T16Bean.CarMove;
import com.sfsq.demo2.R;
import com.sfsq.demo2.databinding.T16FragmentHomeBinding;
import com.sfsq.demo16.T16ui.MyJsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private T16FragmentHomeBinding binding;
    private EditText plateNo;
    private EditText tel;
    private EditText name;
    private EditText idCard;
    private EditText province;
    private EditText city;
    private EditText area;
    private EditText address;
    private Button button;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//
//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
        View v = inflater.inflate(R.layout.t16_fragment_home, container, false);


        plateNo = (EditText) v.findViewById(R.id.plate_no);
        tel = (EditText) v.findViewById(R.id.tel);
        name = (EditText) v.findViewById(R.id.name);
        idCard = (EditText) v.findViewById(R.id.id_card);
        province = (EditText) v.findViewById(R.id.province);
        city = (EditText) v.findViewById(R.id.city);
        area = (EditText) v.findViewById(R.id.area);
        address = (EditText) v.findViewById(R.id.address);
        button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeFragment.this.getActivity(), "正在申请挪车", Toast.LENGTH_SHORT).show();


                JSONObject jr = new JSONObject();
                try {
                    jr.put("userName", name.getText().toString());
                    jr.put("province", province.getText().toString());
                    jr.put("city", city.getText().toString());
                    jr.put("area", area.getText().toString());
                    jr.put("idCard", idCard.getText().toString());
                    jr.put("plateNo", plateNo.getText().toString());
                    jr.put("tel", tel.getText().toString());
                    jr.put("photo", "cra333.png");
                    jr.put("address", address.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                moveCar(jr);


            }
        });


        return v;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void moveCar(JSONObject jr) {
        if (!jr.optString("plateNo").equals("")) {
            String url = "http://124.93.196.45:10001/prod-api/api/park/car/move";
            RequestQueue rq = Volley.newRequestQueue(HomeFragment.this.getActivity());
            MyJsonObjectRequest jor = new MyJsonObjectRequest(url, jr, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    Gson gson = new Gson();
                    CarMove carMove = gson.fromJson(response.toString(), CarMove.class);
                    Log.d("onResponse", response.toString());
                    if (carMove.getCode() == 200) {
                        Toast.makeText(HomeFragment.this.getActivity(), "挪车成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(HomeFragment.this.getActivity(), "挪车失败,"+carMove.getMsg(), Toast.LENGTH_SHORT).show();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("onResponse", error.toString());
                    Toast.makeText(HomeFragment.this.getActivity(), "挪车失败", Toast.LENGTH_SHORT).show();
                }
            });
            rq.add(jor);
        }else {

            Toast.makeText(HomeFragment.this.getActivity(), "挪车失败,车牌号为空", Toast.LENGTH_SHORT).show();
        }
    }
}