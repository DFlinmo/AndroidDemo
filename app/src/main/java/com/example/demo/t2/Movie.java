package com.example.deomo.t2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.deomo.R;
import com.example.deomo.t2.adapter.MovieAdapter;
import com.example.deomo.t2.bean.M_List;
import com.google.gson.Gson;

import org.json.JSONObject;

public class Movie extends AppCompatActivity {

    private ListView movies_list;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t2_movie);

        movies_list = (ListView) findViewById(R.id.movies_list);
        movies();
        movies_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Movie.this,"你点击了第"+(i+1)+"项",Toast.LENGTH_SHORT).show();
            }
        });
        movies();
    }

    private void movies(){
        String url = "http://124.93.196.45:10001/prod-api/api/movie/film/list";

        RequestQueue rq = Volley.newRequestQueue(Movie.this);
        JsonObjectRequest jor = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                M_List movies = gson.fromJson(response.toString(),M_List.class);
                movieAdapter = new MovieAdapter(movies.getRows(),Movie.this);
                movies_list.setAdapter(movieAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("List",error.toString());
            }
        });

        rq.add(jor);
    }


}
