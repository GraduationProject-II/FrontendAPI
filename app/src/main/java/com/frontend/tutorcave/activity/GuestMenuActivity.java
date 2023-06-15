package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.fragment.GuestMenuHomeFragment;
import com.frontend.tutorcave.service.UserMenuService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class GuestMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_menu);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.gstMenuBaseLyt, new GuestMenuHomeFragment())
                .commit();

        UserMenuService menuService = new UserMenuService();
        BottomNavigationView navBottom;

        navBottom = findViewById(R.id.gstMenuBotNav);

        navBottom.setSelectedItemId(R.id.nav_home);
        navBottom.setOnItemSelectedListener(item -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.gstMenuBaseLyt, menuService.setGuestFragment(item))
                    .commit();
            return true;
        });
    }
}