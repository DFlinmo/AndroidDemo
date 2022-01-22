package com.sfsq.demo17.T17ui.notifications;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.sfsq.demo3.R;
import com.sfsq.demo17.T17Bean.Resume;
import com.sfsq.demo17.T17Bean.User;
import com.sfsq.demo17.T17ui.MyJsonObjectRequest;
import com.sfsq.demo17.T17ui.home.HomeViewModel;

import org.json.JSONException;
import org.json.JSONObject;

public class NotificationsFragment extends Fragment {


    private HomeViewModel homeViewModel;
    //    private FragmentHomeBinding binding;
    private TextView username;
    private TextView sex;
    private TextView tel;
    private TextView account;
    private TextView email;
    private TextView mostEducation;
    private TextView positionName;
    private TextView address;
    private TextView education;
    private TextView individualResume;
    private TextView money1;
    private TextView experience;
    private Button editResume;
    private Button addResume;
    private  int userId;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.t17_fragment_notifications, container, false);
        editResume = (Button) view.findViewById(R.id.edit_resume);
        addResume = (Button) view.findViewById(R.id.add_resume);
        username = (TextView) view.findViewById(R.id.username);
        sex = (TextView) view.findViewById(R.id.sex);

        tel = (TextView) view.findViewById(R.id.tel);

        account = (TextView) view.findViewById(R.id.account);
        email = (TextView) view.findViewById(R.id.email);
        mostEducation = (TextView) view.findViewById(R.id.most_education);
        positionName = (TextView) view.findViewById(R.id.position_name);
        address = (TextView) view.findViewById(R.id.address);
        education = (TextView) view.findViewById(R.id.education);
        individualResume = (TextView) view.findViewById(R.id.individual_resume);
        money1 = (TextView) view.findViewById(R.id.money1);
        experience = (TextView) view.findViewById(R.id.experience);
        editResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(NotificationsFragment.this.getActivity(),"编辑",Toast.LENGTH_LONG).show();
                showEditDialog();
            }
        });
        addResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(NotificationsFragment.this.getActivity(),"新增",Toast.LENGTH_LONG).show();
                showAddDialog();
            }
        });

        queryUser();
        queryResume();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }

    protected void showAddDialog() {
        EditText mostEducation;
        EditText positionName;
        EditText address;
        EditText education;
        EditText individualResume;
        EditText money1;
        EditText experience;

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.t17layout_mydialog, null);
        mostEducation = (EditText) layout.findViewById(R.id.most_education);
        positionName = (EditText) layout.findViewById(R.id.position_name);
        address = (EditText) layout.findViewById(R.id.address);
        education = (EditText) layout.findViewById(R.id.education);
        individualResume = (EditText) layout.findViewById(R.id.individual_resume);
        money1 = (EditText) layout.findViewById(R.id.money1);
        experience = (EditText) layout.findViewById(R.id.experience);

        AlertDialog.Builder dialog = new AlertDialog.Builder(NotificationsFragment.this.getActivity());

        dialog.setTitle("新增简历").setView(layout);
        dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                JSONObject jr = new JSONObject();
                try {
                    jr.put("mostEducation", mostEducation.getText().toString());
                    jr.put("address", address.getText().toString());
                    jr.put("experience", experience.getText().toString());
                    jr.put("individualResume", individualResume.getText().toString());
                    jr.put("money", money1.getText().toString());
                    jr.put("positionName", positionName.getText().toString());
                    jr.put("education", education.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                addResume(jr);

            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        dialog.show();
    }

    protected void showEditDialog() {
        EditText mostEducation;
        EditText positionName;
        EditText address;
        EditText education;
        EditText individualResume;
        EditText money1;
        EditText experience;
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.t17layout_mydialog, null);
        mostEducation = (EditText) layout.findViewById(R.id.most_education);
        positionName = (EditText) layout.findViewById(R.id.position_name);
        address = (EditText) layout.findViewById(R.id.address);
        education = (EditText) layout.findViewById(R.id.education);
        individualResume = (EditText) layout.findViewById(R.id.individual_resume);
        money1 = (EditText) layout.findViewById(R.id.money1);
        experience = (EditText) layout.findViewById(R.id.experience);
        money1.setText(this.money1.getText().toString());
        education.setText(this.education.getText().toString());
        experience.setText(this.experience.getText().toString());
        positionName.setText(this.positionName.getText().toString());
        individualResume.setText(this.individualResume.getText().toString());
        address.setText(this.address.getText().toString());
        mostEducation.setText(this.mostEducation.getText().toString());


        AlertDialog.Builder dialog = new AlertDialog.Builder(NotificationsFragment.this.getActivity());

        dialog.setTitle("修改简历").setView(layout);
        dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                JSONObject jr = new JSONObject();
                try {
                    jr.put("mostEducation", mostEducation.getText().toString());
                    jr.put("address", address.getText().toString());
                    jr.put("experience", experience.getText().toString());
                    jr.put("individualResume", individualResume.getText().toString());
                    jr.put("money", money1.getText().toString());
                    jr.put("positionId", positionName.getText().toString());
                    jr.put("education", education.getText().toString());
                    jr.put("id", userId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                editResume(jr);

            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        dialog.show();
    }

    public void addResume(JSONObject jr) {
        String url = "http://124.93.196.45:10001/prod-api/api/job/resume";
//        JSONObject jr = new JSONObject();
        RequestQueue rq = Volley.newRequestQueue(NotificationsFragment.this.getActivity());
        MyJsonObjectRequest jor = new MyJsonObjectRequest(Request.Method.POST,url, jr, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d("onResponse", response.toString());
                if (response.optInt("code") == 200) {
                    Toast.makeText(NotificationsFragment.this.getActivity(), "新增简历成功", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(NotificationsFragment.this.getActivity(), "新增简历失败", Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onResponse", error.toString());
            }
        });
        rq.add(jor);
    }

    public void editResume(JSONObject jr) {

        String url = "http://124.93.196.45:10001/prod-api/api/job/resume";
//        JSONObject jr = new JSONObject();
        RequestQueue rq = Volley.newRequestQueue(NotificationsFragment.this.getActivity());
        MyJsonObjectRequest jor = new MyJsonObjectRequest(Request.Method.PUT,url, jr, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d("onResponse", response.toString());
                if (response.optInt("code") == 200) {
                    Toast.makeText(NotificationsFragment.this.getActivity(), "编辑简历成功", Toast.LENGTH_LONG).show();
                    queryResume();
                } else {
                    Toast.makeText(NotificationsFragment.this.getActivity(), "编辑简历失败", Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onResponse", error.toString());
            }
        });
        rq.add(jor);
    }


    public void queryUser() {

        String url = "http://124.93.196.45:10001/prod-api/api/common/user/getInfo";
        JSONObject jr = new JSONObject();
        RequestQueue rq = Volley.newRequestQueue(NotificationsFragment.this.getActivity());
        MyJsonObjectRequest jor = new MyJsonObjectRequest(url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d("onResponse", response.toString());
                Gson gson = new Gson();
                User user = gson.fromJson(response.toString(), User.class);
                if (user.getCode() == 200) {
                    tel.setText(user.getUser().getPhonenumber());
                    account.setText(user.getUser().getUserName());
                    username.setText(user.getUser().getNickName());
                    email.setText(user.getUser().getEmail());
                    sex.setText(user.getUser().getSex().equals("0") ? "男" : "女");
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onResponse", error.toString());
            }
        });
        jor.setRetryPolicy(new DefaultRetryPolicy(15 * 1000, 1, 1f));
        rq.add(jor);
    }

    public void queryResume() {
        String url = "http://124.93.196.45:10001/prod-api/api/job/resume/queryResumeByUserId/1";
        JSONObject jr = new JSONObject();
        RequestQueue rq = Volley.newRequestQueue(NotificationsFragment.this.getActivity());
        MyJsonObjectRequest jor = new MyJsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("onResponse", response.toString());
                Gson gson = new Gson();
                Resume resume = gson.fromJson(response.toString(), Resume.class);
                if (resume.getCode() == 200) {
                    money1.setText(resume.getData().getMoney());
                    education.setText(resume.getData().getEducation());
                    experience.setText(resume.getData().getExperience());
                    positionName.setText(resume.getData().getPositionId() + "");
                    individualResume.setText(resume.getData().getIndividualResume());
                    address.setText(resume.getData().getAddress());
                    mostEducation.setText(resume.getData().getMostEducation());
                    userId=resume.getData().getId();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onResponse", error.toString());
            }
        });
        jor.setRetryPolicy(new DefaultRetryPolicy(15 * 1000, 1, 1f));
        rq.add(jor);
    }
}