package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.adapter.WelcomeAdapter;
import com.frontend.tutorcave.model.WelcomeModel;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private WelcomeAdapter adapter;
    private final ArgbEvaluator evaluator = new ArgbEvaluator();
    private int cardPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button button;
        List<WelcomeModel> models;

        viewPager = findViewById(R.id.vwPgrWelcome);
        button = findViewById(R.id.btnWelcome);

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

        Integer[] colors = {
                getResources().getColor(R.color.welcome_shading1),
                getResources().getColor(R.color.welcome_shading2),
                getResources().getColor(R.color.welcome_shading3)
        };

        // TODO: replace with addOnPageListener()
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount()-1)
                        && position < (colors.length-1)) {
                    viewPager.setBackgroundColor(
                            (Integer) evaluator.evaluate(positionOffset, colors[position], colors[position +1])
                    );
                } else
                    viewPager.setBackgroundColor(colors[colors.length-1]);
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

        button.setOnClickListener(view -> {
            Intent intent;

            switch (cardPosition) {
                case 0:
                    intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
                    startActivity(intent);
                    break;
                case 2:
                    // test
                    intent = new Intent(WelcomeActivity.this, UserMenuActivity.class);
                    startActivity(intent);

                    // TODO: complete below task
                    //intent = new Intent(WelcomeActivity.this, GuestMenuActivity.class);
                    //startActivity(intent);
                    break;
                default:
                    Toast.makeText(WelcomeActivity.this, R.string.selection_invalid, Toast.LENGTH_SHORT).show();
            }
        });
    }
}