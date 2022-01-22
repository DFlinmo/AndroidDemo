package com.example.demo.ui.dashboard;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.demo.databinding.T13FragmentHomeBinding;
import com.example.demo.ui.dashboard.adapter.JieMianAdapter;
import com.example.demo.ui.dashboard.addUser.add_user;

public class DashboardFragment extends Fragment {
    private RecyclerView recyclerView;
    private Button add_button;
    String[] str_all = {"电费84688468|4-2-1","水费84688468|4-2-1","电费84688468|4-2-5","水费84688468|4-2-5"};
    String[] str_parent = {"电费84688468|4-2-5","水费84688468|4-2-5"};
    String[] str_landlord = {"电费84688468|4-2-1","水费84688468|4-2-1"};
    String[] str_friend = {"电费84688468|4-2-7","水费84688468|4-2-7"};
    String[] str_zidingyi = new String[10];
    private T13FragmentHomeBinding binding;
    private JieMianAdapter adapter1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.t13_fragment_dashboard,container,false);
        recyclerView = v.findViewById(R.id.button_recycler_view);
        Button add = (Button) v.findViewById(R.id.t13_add);
        add_button = (Button)v.findViewById(R.id.dashboard_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText input = new EditText(v.getContext());
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("添加分组");
                builder.setMessage("添加分组：");
                builder.setView(input);
                builder.setNegativeButton("取消", null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        LinearLayout layout =  (LinearLayout)v.findViewById(R.id.name_row_list);
                        Button button = new Button(v.getContext());
                        button.setText(input.getText().toString());
                        button.setHeight(200);
                        layout.addView(button);
                        System.out.println(input.getText().toString());
                        Intent intent = new Intent(v.getContext(),add_user.class);
                        intent.putExtra("name",input.getText().toString());
                        startActivity(intent);

                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                adapter1 = new JieMianAdapter(str_zidingyi);
                                recyclerView.setAdapter(adapter1);
                                recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
                                add_button.setVisibility(v.VISIBLE);
                                add_button.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        final EditText input = new EditText(v.getContext());
                                        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                                        builder.setTitle("请输入你要添加的缴费类别及户号");
                                        builder.setView(input);
                                        builder.setNegativeButton("取消", null);
                                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                String str = input.getText().toString();
                                                for (int j = 0; j <= str_zidingyi.length -1; j++) {
                                                    if (str_zidingyi[j] == null) {
                                                        str_zidingyi[j] = str;
                                                        break;
                                                    }
                                                }
                                                adapter1 = new JieMianAdapter(str_zidingyi);
                                                recyclerView.setAdapter(adapter1);
                                            }
                                        });
                                        builder.show();
                                    }
                                });

                            }
                        });
                    }
                });
                builder.show();

//
            }
        });



        Button all = (Button)v.findViewById(R.id.dashboard_all);
        Button parent = (Button)v.findViewById(R.id.dashboard_parent);
        Button landlord = (Button)v.findViewById(R.id.dashboard_landlord);
        Button friend = (Button)v.findViewById(R.id.dashboard_friend);

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter1 = new JieMianAdapter(str_all);
                recyclerView.setAdapter(adapter1);
                recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
            }
        });

        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter1 = new JieMianAdapter(str_parent);
                recyclerView.setAdapter(adapter1);
                recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
            }
        });

        landlord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter1 = new JieMianAdapter(str_landlord);
                recyclerView.setAdapter(adapter1);
                recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
            }
        });


        friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter1 = new JieMianAdapter(str_friend);
                recyclerView.setAdapter(adapter1);
                recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
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