package com.example.i_vocabuilder;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainInterface extends AppCompatActivity {

    TextView daily,weekly,monthly,all;
    ViewPager viewPager;
    PagerViewAdapter pagerViewAdapter;
    FloatingActionButton fab;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_interface);

        daily = findViewById(R.id.daily);
        weekly = findViewById(R.id.weekly);
        monthly = findViewById(R.id.monthly);
        all = findViewById(R.id.all);

        viewPager = findViewById(R.id.fragment_container);

        fab = findViewById(R.id.fabId);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddingWord.class));
            }
        });

        pagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerViewAdapter);

        daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }

        });
        weekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        monthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);
            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }


            @Override
            public void onPageSelected(int position) {
                onChangeTab(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void onChangeTab(int position) {

        if(position==0){
            daily.setTextSize(25);
            daily.setTextColor(getColor(R.color.ghost_white));

            weekly.setTextSize(20);
            weekly.setTextColor(getColor(R.color.ghost_white));

            monthly.setTextSize(20);
            monthly.setTextColor(getColor(R.color.ghost_white));

            all.setTextSize(20);
            all.setTextColor(getColor(R.color.ghost_white));

        }
        if(position==1){
            daily.setTextSize(20);
            daily.setTextColor(getColor(R.color.ghost_white));

            weekly.setTextSize(25);
            weekly.setTextColor(getColor(R.color.ghost_white));

            monthly.setTextSize(20);
            monthly.setTextColor(getColor(R.color.ghost_white));

            all.setTextSize(20);
            all.setTextColor(getColor(R.color.ghost_white));

        }
        if(position==2){
            daily.setTextSize(20);
            daily.setTextColor(getColor(R.color.ghost_white));

            weekly.setTextSize(20);
            weekly.setTextColor(getColor(R.color.ghost_white));

            monthly.setTextSize(25);
            monthly.setTextColor(getColor(R.color.ghost_white));

            all.setTextSize(20);
            all.setTextColor(getColor(R.color.ghost_white));

        }
        if(position==3){
            daily.setTextSize(20);
            daily.setTextColor(getColor(R.color.ghost_white));

            weekly.setTextSize(20);
            weekly.setTextColor(getColor(R.color.ghost_white));

            monthly.setTextSize(20);
            monthly.setTextColor(getColor(R.color.ghost_white));

            all.setTextSize(25);
            all.setTextColor(getColor(R.color.ghost_white));

        }

    }


}