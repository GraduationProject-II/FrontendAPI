package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.fragment.MenuHomeFragment;
import com.frontend.tutorcave.service.UserMenuService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class UserMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);

        Intent currentIntent = getIntent();
        final String userId = currentIntent.getStringExtra("userId");
        getSupportFragmentManager().beginTransaction().replace(R.id.lytRelativeParent, new MenuHomeFragment(userId)).commit();

        UserMenuService menuService = new UserMenuService();
        BottomNavigationView navBottom;

        navBottom = findViewById(R.id.navVwUserMenu);

        navBottom.setSelectedItemId(R.id.nav_home);
        navBottom.setOnItemSelectedListener(item -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.lytRelativeParent, menuService.setFragment(item, userId))
                    .commit();
            return true;
        });
    }
}