package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.fragment.ProfileDiscussionFragment;
import com.frontend.tutorcave.service.ViewProfileService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ViewProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.vwPrfLytViewSel, new ProfileDiscussionFragment())
                .commit();

        // TODO: set anim

        ViewProfileService service = new ViewProfileService();
        Intent currentIntent = getIntent();
        ImageView profilePic;
        TextView name;
        TextView username;
        TextView rep;
        TextView accType;
        TextView aboutMe;
        BottomNavigationView bottomNav;

        profilePic = findViewById(R.id.vwPrfImgPP);
        name = findViewById(R.id.vwPrfTxtName);
        username = findViewById(R.id.vwPrfTxtUsername);
        rep = findViewById(R.id.vwPrfTxtRep);
        accType = findViewById(R.id.vwPrfTxtAccType);
        aboutMe = findViewById(R.id.vwPrfTxtAboutMe);
        bottomNav = findViewById(R.id.VwPrfBottomNav);

        username.setText(currentIntent.getStringExtra("username"));
        profilePic.setImageResource(currentIntent.getIntExtra("image", 0)); // TODO: check runtime behavior

        if (isExtra(currentIntent.getStringExtra("rep")))
            rep.setText(currentIntent.getStringExtra("rep"));

        if (isExtra(currentIntent.getStringExtra("name")))
            name.setText(currentIntent.getStringExtra("name"));

        if (isExtra(currentIntent.getStringExtra("bio")))
            aboutMe.setText(currentIntent.getStringExtra("bio"));

        bottomNav.setSelectedItemId(R.id.vwPrfDiscNav);
        bottomNav.setOnItemSelectedListener(item -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.vwPrfLytViewSel, service.setFragment(item))
                    .commit();
            return true;
        });
    }

    private boolean isExtra(String res) {
        return res != null;
    }
}