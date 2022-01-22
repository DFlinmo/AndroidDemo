package com.example.demo15;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.testflask.R;
import com.example.demo15.T15Adapter.GridViewAdapter;
import com.example.demo15.T15Bean.ItemGridViewBean;
import com.example.demo15.T15Bean.WeatherBean;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class T15MainActivity extends AppCompatActivity {

    private TextView date;
    private TextView city;
    private TextView temperature;
    private TextView weather;

    private TextView dress;
    private TextView dressPrompt;

    private TextView ultraviolet;
    private TextView ultravioletPrompt;

    private TextView cold;
    private TextView coldPrompt;

    private TextView motion;
    private TextView motionPrompt;
    private TextView airPollution;
    private TextView airPollutionPrompt;
    private RecyclerView gridView;
    public ArrayList<ItemGridViewBean> Data;

    private ImageView refreshWeather ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t15_layout_weather);

//        getSupportActionBar().hide();
        Data = new ArrayList<>();
        date = findViewById(R.id.date);
//        city = findViewById(R.id.city);
        refreshWeather = (ImageView) findViewById(R.id.refresh_weather);
        temperature = findViewById(R.id.temperature);
        weather = findViewById(R.id.weather);

        dress = findViewById(R.id.dress);
        dressPrompt = findViewById(R.id.dress_prompt);

        ultraviolet = findViewById(R.id.ultraviolet);
        ultravioletPrompt = findViewById(R.id.ultraviolet_prompt);

        cold = findViewById(R.id.cold);
        coldPrompt = findViewById(R.id.cold_prompt);

        motion = findViewById(R.id.motion);
        motionPrompt = findViewById(R.id.motion_prompt);
        airPollution = findViewById(R.id.air_pollution);
        airPollutionPrompt = findViewById(R.id.air_pollution_prompt);
        gridView = findViewById(R.id.grid_view);


        Handler handler = new Handler(); // 每隔3秒刷新一次数据
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                query();
                handler.postDelayed(this, 3000);
            }
        };
        handler.postDelayed(runnable, 0);
        // 点击图标刷新数据
        refreshWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query();
                Toast.makeText(T15MainActivity.this, "天气数据已经刷新", Toast.LENGTH_LONG).show();
            }
        });

    }


    public void query() {
        String url = "http://124.93.196.45:10001/prod-api/api/common/weather";
        JSONObject jr = new JSONObject();
        RequestQueue rq = Volley.newRequestQueue(T15MainActivity.this);
        JsonObjectRequest jor = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("onResponse", response.toString());
                Gson gson = new Gson();
                WeatherBean weatherBean = gson.fromJson(response.toString(), WeatherBean.class);
                initData(weatherBean);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onResponse", error.toString());
            }
        });
        rq.add(jor);
    }

    private void ShowGrid() {
        ArrayList<ItemGridViewBean> data = new ArrayList<>(); // 新建数组存放未来4天天气
        data.add(Data.get(2));
        data.add(Data.get(3));
        data.add(Data.get(4));
        data.add(Data.get(5));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        gridView.setLayoutManager(gridLayoutManager);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(data);
        gridView.setAdapter(gridViewAdapter);

    }

    private void initData(WeatherBean weatherBean) {

        if (weatherBean.getCode() == 200) {
            for (int j = 0; j < weatherBean.getData().getWeatherList().size(); j++) {
                Log.d("onResponse",
                        " 时间" + weatherBean.getData().getWeatherList().get(j).getDay() +
                                " 温度" + weatherBean.getData().getWeatherList().get(j).getMinTemperature() + "~" + weatherBean.getData().getWeatherList().get(j).getMaxTemperature() + "℃" +
                                " 天气" + weatherBean.getData().getWeatherList().get(j).getWeather()
                );
                ItemGridViewBean itemGridViewBean = new ItemGridViewBean();
                itemGridViewBean.date = weatherBean.getData().getWeatherList().get(j).getDay();
                itemGridViewBean.weather = weatherBean.getData().getWeatherList().get(j).getWeather();
                itemGridViewBean.temperature = weatherBean.getData().getWeatherList().get(j).getMinTemperature() + "~" + weatherBean.getData().getWeatherList().get(j).getMaxTemperature() + "℃";
                Data.add(itemGridViewBean);
            }
            date.setText(weatherBean.getData().getWeatherList().get(1).getDay());
            weather.setText(weatherBean.getData().getWeatherList().get(1).getWeather());
            temperature.setText(weatherBean.getData().getWeatherList().get(1).getMinTemperature() + "~" + weatherBean.getData().getWeatherList().get(1).getMaxTemperature() + "℃");
            double co = weatherBean.getData().getToday().getAirQuantity().getCo();
            double pm25 = weatherBean.getData().getToday().getAirQuantity().getPm25();
            double apparentTemperature = weatherBean.getData().getToday().getComfortLevel().getApparentTemperature();
            double uv = weatherBean.getData().getToday().getComfortLevel().getUv();

            if (uv < 1000) {
                ultraviolet.setText("紫外线强度(弱)");
                ultravioletPrompt.setText("辐射较弱，涂擦SPF12~15、PA+护肤品");
            } else if (uv < 3000) {
                ultraviolet.setText("紫外线强度(中等)");
                ultravioletPrompt.setText("涂擦SPF大于15、PA+防晒护肤品");
            } else {
                ultraviolet.setText("紫外线强度(强)");
                ultravioletPrompt.setText("尽量减少外出，需要涂抹高倍数防晒霜");
            }

            if (pm25 < 30) {
                airPollution.setText("空气污染扩散指数(优)");
                airPollutionPrompt.setText("空气质量非常好，非常适合户外活动，趁机出去多呼吸");
            } else if (pm25 < 100) {
                airPollution.setText("空气污染扩散指数(良)");
                airPollutionPrompt.setText("易感人群应适当减少室外活动");
            } else {
                airPollution.setText("空气污染扩散指数(污染)");
                airPollutionPrompt.setText("空气质量差，不适合户外活动");
            }


            if (co < 3000) {
                motion.setText("空气污染扩散指数(适宜)");
                motionPrompt.setText("气候适宜，推荐您进行户外运动");
            } else if (co < 6000) {
                motion.setText("空气污染扩散指数(中)");
                motionPrompt.setText("易感人群应适当减少室外活动");
            } else {
                motion.setText("空气污染扩散指数(较不宜)");
                motionPrompt.setText("空气氧气含量低，请在室内进行休闲运动");
            }

            if (apparentTemperature < 12) {
                dress.setText("穿衣指数(冷)");
                dressPrompt.setText("建议穿长袖衬衫、单裤等服装");
            } else if (apparentTemperature < 21) {
                dress.setText("穿衣指数(舒适)");
                dressPrompt.setText("建议穿短袖衬衫、单裤等服装");
            } else {
                dress.setText("穿衣指数(热)");
                dressPrompt.setText("适合穿T恤、短薄外套等夏季服装");
            }

            if (apparentTemperature < 8) {
                cold.setText("感冒指数(较易发)");
                coldPrompt.setText("温度低，风较大，较易发生感冒，注意防护");
            } else {
                cold.setText("感冒指数(少发)");
                coldPrompt.setText("温度低，风较大，较易发生感冒，注意防护");
            }


            ShowGrid();

        }


    }


}
