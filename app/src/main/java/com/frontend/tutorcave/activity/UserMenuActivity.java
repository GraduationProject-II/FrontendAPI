package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.fragment.MenuDiscussionFragment;
import com.frontend.tutorcave.fragment.MenuHomeFragment;
import com.frontend.tutorcave.fragment.MenuMessageFragment;
import com.frontend.tutorcave.fragment.MenuSearchTutorFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class UserMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);
        getSupportFragmentManager().beginTransaction().replace(R.id.lytRelativeParent, new MenuHomeFragment()).commit();

        BottomNavigationView navBottom;

        navBottom = (BottomNavigationView) findViewById(R.id.navVwUserMenu);

        // TODO: set anim

        navBottom.setSelectedItemId(R.id.nav_home);
        navBottom.setOnItemSelectedListener(item -> {

            final int navHomeID = R.id.nav_home;
            final int navDiscussionID = R.id.nav_discussion;
            final int navFindTutorID = R.id.nav_search_tutor;
            final int navMessageID = R.id.nav_message;
            Fragment fragment = null;

            switch (item.getItemId()) {
                case navHomeID:
                    fragment = new MenuHomeFragment();
                    break;
                case navDiscussionID:
                    fragment = new MenuDiscussionFragment();
                    break;
                case navFindTutorID:
                    fragment = new MenuSearchTutorFragment();
                    break;
                case navMessageID:
                    fragment = new MenuMessageFragment();
                    break;
                default:
                    Toast.makeText(UserMenuActivity.this, R.string.invalid_selection, Toast.LENGTH_SHORT).show();
                    fragment = new MenuHomeFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.lytRelativeParent, fragment).commit();
            return true;
        });
    }
}