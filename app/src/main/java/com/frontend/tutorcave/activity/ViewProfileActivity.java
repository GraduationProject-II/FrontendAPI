package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
        BottomNavigationView bottomNav;

        profilePic = findViewById(R.id.vwPrfImgPP);
        name = findViewById(R.id.vwPrfTxtName);
        username = findViewById(R.id.vwPrfTxtUsername);
        rep = findViewById(R.id.vwPrfTxtRep);
        accType = findViewById(R.id.vwPrfTxtAccType);
        bottomNav = findViewById(R.id.VwPrfBottomNav);


        byte[] imageData = currentIntent.getByteArrayExtra("image");
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.length);
        profilePic.setImageBitmap(bitmap);
        username.setText(currentIntent.getStringExtra("username"));
        rep.setText(currentIntent.getStringExtra("rep"));
        name.setText(currentIntent.getStringExtra("name"));
        accType.setText(currentIntent.getStringExtra("accountType"));

        bottomNav.setSelectedItemId(R.id.vwPrfDiscNav);
        bottomNav.setOnItemSelectedListener(item -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.vwPrfLytViewSel, service.setFragment(item))
                    .commit();
            return true;
        });
    }
}