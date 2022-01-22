package com.example.demo.ui.dashboard.addUser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.demo.R;

public class add_user extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t13_activity_add_user);
        Intent intent = this.getIntent();
        String str = intent.getStringExtra("name");
        System.out.println(str);
        TextView tv = this.findViewById(R.id.zidingyi);
        tv.setText(str);
        Button back = this.findViewById(R.id.add1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}