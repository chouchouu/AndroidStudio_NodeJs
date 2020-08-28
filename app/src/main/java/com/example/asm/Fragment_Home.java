package com.example.asm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter_view.adapter_home;
import model.fashion_home;

public class Fragment_Home extends Fragment {

    private RecyclerView recyclerView;

    ViewFlipper view_flipper;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView= view.findViewById(R.id.rcy);
        view_flipper = view.findViewById(R.id.view_flipper);



        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        recyclerView.setHasFixedSize(true);
        List<fashion_home> flists = new ArrayList<>();
        flists.add(new fashion_home(R.drawable.ao,"200"));
        flists.add(new fashion_home(R.drawable.ao1,"200"));
        flists.add(new fashion_home(R.drawable.ao8,"200"));
        flists.add(new fashion_home(R.drawable.ao7,"200"));
        flists.add(new fashion_home(R.drawable.non2,"200"));
        flists.add(new fashion_home(R.drawable.non,"200"));
        flists.add(new fashion_home(R.drawable.kep,"200"));
        flists.add(new fashion_home(R.drawable.kep2,"200"));
        flists.add(new fashion_home(R.drawable.day,"200"));
        adapter_home adapter_home = new adapter_home(flists,getContext());
        recyclerView.setAdapter(adapter_home);

        //view_flipper
        int images[] = {R.drawable.truee, R.drawable.one, R.drawable.pea, R.drawable.three,R.drawable.four};
        //loop
        for (int image : images) {
            flipperImages(image);
        }
        return view;
//
    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(image);
        view_flipper.addView(imageView);
        view_flipper.setFlipInterval(2000);
        view_flipper.setAutoStart(true);
        //animation
        view_flipper.setInAnimation(getActivity(), android.R.anim.slide_in_left);
        view_flipper.setOutAnimation(getActivity(), android.R.anim.slide_out_right);
    }
}
