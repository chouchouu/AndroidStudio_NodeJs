package com.example.asm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import api.API;
import api.RetrofitClient;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;

public class Login_Activity extends AppCompatActivity {
ImageView img_back;
TextView txt_signup;
Button btn_login;
EditText edt_name, edt_password;
API api;
RetrofitClient retrofitClient =new RetrofitClient();
CompositeDisposable compositeDisposable =new CompositeDisposable();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        img_back =findViewById(R.id.img_back);
        txt_signup=findViewById(R.id.txt_signup);
        btn_login=findViewById(R.id.btn_login);
        edt_name=findViewById(R.id.edt_name);
        edt_password=findViewById(R.id.edt_pasword);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Intent i=new Intent(Login_Activity.this,Home_Activity.class);
               startActivity(i);
            }
        });
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login_Activity.this,MainActivity.class);
                startActivity(i);
            }
        });
        txt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Login_Activity.this,SignupActivity.class);
                startActivity(i);
            }
        });


    }

}
