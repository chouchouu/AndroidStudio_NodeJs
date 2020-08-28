package com.example.asm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home_Activity extends AppCompatActivity {
    BottomNavigationView bottom_nav;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        //màn hình mặc định khi vào
        bottom_nav = findViewById(R.id.botom_nav);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain,
                    new Fragment_Home()).commit();
            bottom_nav.setSelectedItemId(R.id.home);
        }
        //
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)
                bottom_nav.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());
        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.main:
                        //actionBar.hide();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain,
                                new Fragment_Home()).commit();
                        return true;
                    case R.id.home:
                        //actionBar.hide();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain,
                                new Fragment_Main()).commit();
                        return true;
                    case R.id.sotre:
                      //  actionBar.hide();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain,
                                new Fragment_user()).commit();
                        return true;

                }
                return false;
            }
        });
    }
}
