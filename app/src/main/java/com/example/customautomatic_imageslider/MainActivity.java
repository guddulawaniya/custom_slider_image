package com.example.customautomatic_imageslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    TabLayout tabLayout;
    List<module> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        list.add(new module(R.drawable.img));
        list.add(new module(R.drawable.img));
        list.add(new module(R.drawable.img));
        list.add(new module(R.drawable.img));
        list.add(new module(R.drawable.img));
        list.add(new module(R.drawable.img));
        list.add(new module(R.drawable.img));
        list.add(new module(R.drawable.img));
        list.add(new module(R.drawable.img));
        list.add(new module(R.drawable.img));
        list.add(new module(R.drawable.img));


        pager = findViewById(R.id.my_pager) ;



        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new The_slide_timer(),2000,3000);
        adapter a = new adapter(list,this);
        pager.setAdapter(a);

    }

    public class The_slide_timer extends TimerTask {
        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (pager.getCurrentItem()< list.size()-1) {
                        pager.setCurrentItem(pager.getCurrentItem()+1);
                    }
                    else
                        pager.setCurrentItem(0);
                }
            });
        }
    }
}