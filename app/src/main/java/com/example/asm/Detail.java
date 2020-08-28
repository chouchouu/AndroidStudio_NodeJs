package com.example.asm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import api.API;
import api.RetrofitClient;
import model.buy;

public class Detail extends AppCompatActivity {
    ImageView img_view,btnback;
    TextView tv_view,tv_price_view,tv_mt_view;
    RetrofitClient retrofitClient =new RetrofitClient();
    API api;
    buy buy =new buy();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        img_view=findViewById(R.id.img_view);
        btnback=findViewById(R.id.btnBack);
        tv_view=findViewById(R.id.tv_view);
        tv_price_view=findViewById(R.id.tv_price_view);
        tv_mt_view=findViewById(R.id.tv_mt_view);

        Intent intent = getIntent();
        String idbuy = intent.getStringExtra("id");

        api =retrofitClient.getClient().create(API.class);

        for (buy item: Fragment_Main.buyList){
            if (item.get_id().equals(idbuy)){
                Picasso.with(Detail.this).load("http://192.168.1.9:8000/" +item.getImage()).into(img_view);
                tv_view.setText(item.getName());
                tv_price_view.setText(item.getPrice());
                tv_mt_view.setText(item.getDescribe());
            }
        }
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
