package com.example.asm;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter_view.Adapter_sp;
import api.API;
import api.RetrofitClient;
import model.Data;
import model.buy;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_Main extends Fragment {
    public static List<buy> buyList = new ArrayList<>();
    List<buy> searchlist;
    EditText edtSearch;
    RetrofitClient retrofitClient = new RetrofitClient();
    ImageView img_back;
    Adapter_sp adapterView;
    API api;
    private RecyclerView rv;
    Intent intent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        rv = view.findViewById(R.id.rv);
        img_back = view.findViewById(R.id.img_back);
        edtSearch = view.findViewById(R.id.edtSearch);



        RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity(), 1);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(manager);

        getData();
        //back
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
            }
        });
        //tìm kiếm
        edtSearch.addTextChangedListener(new TextWatcher() {
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


                adapterView = new Adapter_sp(getContext(), searchlist);
                rv.setAdapter(adapterView);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;


    }

    void getData() {
        //Creating an object of our api interface
        api = retrofitClient.getClient().create(API.class);
        //Defining the method
        api.getBuys().enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (response.isSuccessful()) {
                    Data data = response.body();
                    buyList = data.getData();
                    adapterView = new Adapter_sp(getActivity(), buyList);
                    rv.setAdapter(adapterView);
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("loi",t.toString());

            }
        });


    }


}