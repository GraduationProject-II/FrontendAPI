package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;

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
        getSupportFragmentManager().beginTransaction().replace(R.id.lytRelativeParent, new MenuHomeFragment()).commit();

        UserMenuService menuService = new UserMenuService();
        BottomNavigationView navBottom;

        navBottom = (BottomNavigationView) findViewById(R.id.navVwUserMenu);

        // TODO: set anim

        navBottom.setSelectedItemId(R.id.nav_home);
        navBottom.setOnItemSelectedListener(item -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.lytRelativeParent, menuService.setFragment(item))
                    .commit();
            return true;
        });
    }
}