package com.example.asm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import Adapter_view.Adapter_sp;
import Adapter_view.adapter_loaisp;
import api.API;
import api.RetrofitClient;
import model.Data;
import model.buy;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Catagory extends AppCompatActivity {
    RecyclerView recyclerView;
    RetrofitClient retrofitClient = new RetrofitClient();
    List<buy> searchlist;
    API api;
    adapter_loaisp adapter_loaisp;
    List<buy> buyList =new ArrayList<>();
    EditText edtSearch_loai;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);

        recyclerView = findViewById(R.id.recycle_catagory);
        edtSearch_loai=findViewById(R.id.edtSearch_loai);

        RecyclerView.LayoutManager manager = new GridLayoutManager(Catagory.this, 1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
        getData();
        //tìm kiếm
        edtSearch_loai.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchlist = new ArrayList<>();
                if (s.length() == 0) {
                    searchlist = buyList;
                } else {
                    for (buy item : buyList) {
                        if (item.getName().toLowerCase().contains(s.toString().toLowerCase())
                                || item.getName().toLowerCase().contains(s.toString().toLowerCase())) {
                            searchlist.add(item);
                        }
                    }
                }


                adapter_loaisp = new adapter_loaisp(Catagory.this, searchlist);
                recyclerView.setAdapter(adapter_loaisp);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




    }

    private void getData() {
        Intent intent = getIntent();
        final String id = intent.getStringExtra("loaiId");
        API api = retrofitClient.getClient().create(API.class);

        api.getloaisanpham(id).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (response.isSuccessful()){
                    buyList = response.body().getData();
                    adapter_loaisp = new adapter_loaisp(Catagory.this, buyList);
                    recyclerView.setAdapter(adapter_loaisp);
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("loi",t.toString());
            }
        });









//        enqueue(new Callback<Data>() {
//            @Override
//            public void onResponse(Call<Data> call, Response<Data> response) {
//                if (response.isSuccessful()) {
//                    Toast.makeText(Catagory.this,"aaaaaaaaaa",Toast.LENGTH_SHORT).show();
//                    Data data = response.body();
//                    buyList = data.getData();
//                    adapter_loaisp = new adapter_loaisp(Catagory.this, buyList);
//                    recyclerView.setAdapter(adapter_loaisp);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Data> call, Throwable t) {
//                Log.d("loiloai",t.toString());
//            }
//        });
    }
}
