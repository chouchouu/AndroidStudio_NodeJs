package com.example.asm;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter_view.Adapter_sp;

import Adapter_view.adapter_catagory;
import api.API;
import api.RetrofitClient;
import model.Data;
import model.catagory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_user extends Fragment {
    public static List<catagory> catagories = new ArrayList<>();
    RetrofitClient retrofitClient = new RetrofitClient();
    adapter_catagory adapter_catagory;
    API api;
    private RecyclerView rv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        rv=view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity(), 1);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(manager);
        getCategoriesList();


        return view;
    }



    public void getCategoriesList(){
        api = retrofitClient.getClient().create(API.class);
        Call<List<catagory>> call = api.getCatagory();
        call.enqueue(new Callback<List<catagory>>() {
            @Override
            public void onResponse(Call<List<catagory>> call, Response<List<catagory>> response) {
                catagories=response.body();
                if (response.isSuccessful()) {
                        adapter_catagory =new adapter_catagory(getActivity(),catagories);
                        rv.setAdapter(adapter_catagory);


                }

            }

            @Override
            public void onFailure(Call<List<catagory>> call, Throwable t) {

            }
        });
    }

}
