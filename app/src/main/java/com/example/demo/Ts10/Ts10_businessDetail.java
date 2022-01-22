package com.example.demo.Ts10;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;

public class Ts10_businessDetail extends AppCompatActivity {
    private TextView businessName;
    private ImageView businessImg;
    private TextView businessArticle;
    private TextView businessCall;
    private ImageView call;

    private int[] busiimg = {R.mipmap.supermarket,R.mipmap.clinic,R.mipmap.broadband};
    private String[] businame = {"家乐福超市","同仁馆诊所","小区宽带服务"};
    private String[] busiadver = {"国庆狂欢，大礼疯狂送国庆狂欢,公司在第四期促销手册(时间:9月15日—10月15日)封面上印刷中秋、国庆现金券，现金券面值10元，凡顾客拿到我们的手册，" +
            "剪下现金券到我超市购物满100元可使用一张，直接省8元现金，购物满200元可使用两张，多买多用，依次类推。现金券不可兑换现金。" ,
            "医院渠道:在客户消费层次较高的群体中，一般对就医口腔的选择都比较谨慎，很多人在就医时会选择向医院咨询相关行业服务较好和环境优雅的地方。如果\n" +
            "通过相关人脉关系，通过医院渠道来提升卓越口腔在客户心中的高度，更易于推动客户选择卓越口腔。\n",
            "4、办理流程:\n" + "用户登记――审核/修改――检查号线资源――有线有号——受理――用户信息及时发送至我司开户负责人——录入工单――派发工单―一装维人员上门安装――工单回执——竣工处理――为用户办理免费提速2M活动(活动次月1号生效）——结束\n"};
    private String[] busitel = {"1231412","7879976","5674235"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ts10_business_detail);
        //侧边返回
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        businessName = (TextView) findViewById(R.id.business_name);
        businessImg = (ImageView) findViewById(R.id.business_img);
        businessArticle = (TextView) findViewById(R.id.business_article);
        businessCall = (TextView) findViewById(R.id.business_calltitle);
        call = (ImageView) findViewById(R.id.business_call);

        Intent intent = getIntent();
        String name = intent.getStringExtra("businame");
        System.out.println("businame======"+name);
        for (int i = 0;i<businame.length;i++){
            if (name.equals(businame[i])){
                businessImg.setImageResource(busiimg[i]);
                businessName.setText(businame[i]);
                businessArticle.setText(busiadver[i]);
                businessCall.setText("咨询电话："+busitel[i]);
            }
        }

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Ts10_businessDetail.this,"拨打咨询电话",Toast.LENGTH_SHORT).show();
            }
        });

    }


    //侧边返回方法重写
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
