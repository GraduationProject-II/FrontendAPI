package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.adapter.WelcomeAdapter;
import com.frontend.tutorcave.model.WelcomeModel;
import com.frontend.tutorcave.service.WelcomeService;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private WelcomeAdapter adapter;
    private int cardPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        WelcomeService service = new WelcomeService();
        Button btnGoTo;
        List<WelcomeModel> models;
        List<Class<?>> classList;
        Integer[] colors = {
                getResources().getColor(R.color.welcome_shading1),
                getResources().getColor(R.color.welcome_shading2),
                getResources().getColor(R.color.welcome_shading3)
        };

        viewPager = findViewById(R.id.vwPgrWelcome);
        btnGoTo = findViewById(R.id.btnWelcome);

        classList = new ArrayList<>();
        classList.add(LoginActivity.class);
        classList.add(RegisterActivity.class);
        classList.add(GuestMenuActivity.class);

        models = new ArrayList<>();
        // login
        models.add(new WelcomeModel(
                R.drawable.login,
                getString(R.string.login),
                getString(R.string.login_desc)
        ));
        //register
        models.add(new WelcomeModel(
                R.drawable.register,
                getString(R.string.register),
                getString(R.string.register_desc)
        ));
        // guest
        models.add(new WelcomeModel(
                R.drawable.guest,
                getString(R.string.guest),
                getString(R.string.guest_desc)
        ));

        adapter = new WelcomeAdapter(models, this);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        // TODO: replace with addOnPageListener()
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                service.setCardBackground(
                        viewPager,
                        adapter,
                        position,
                        positionOffset,
                        colors
                );
            }

            @Override
            public void onPageSelected(int position) {
                cardPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // dummy method
            }
        });

        btnGoTo.setOnClickListener(view -> service.redirect(
                WelcomeActivity.this,
                cardPosition,
                classList
        ));
    }
}