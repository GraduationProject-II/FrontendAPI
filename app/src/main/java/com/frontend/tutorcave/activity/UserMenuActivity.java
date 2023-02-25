package com.frontend.tutorcave.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.fragment.MenuDiscussionFragment;
import com.frontend.tutorcave.fragment.MenuHomeFragment;
import com.frontend.tutorcave.fragment.MenuMessageFragment;
import com.frontend.tutorcave.fragment.MenuSearchTutorFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class UserMenuActivity extends AppCompatActivity {

    private BottomNavigationView navBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);

        navBottom = (BottomNavigationView) findViewById(R.id.navVwUserMenu);

        // TODO: set anim

        getSupportFragmentManager().beginTransaction().replace(R.id.lytRelativeParent, new MenuHomeFragment()).commit();
        navBottom.setSelectedItemId(R.id.nav_home);
        navBottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                // TODO: replace case param ids
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragment = new MenuHomeFragment();
                        break;
                    case R.id.nav_discussion:
                        fragment = new MenuDiscussionFragment();
                        break;
                    case R.id.nav_search_tutor:
                        fragment = new MenuSearchTutorFragment();
                        break;
                    case R.id.nav_message:
                        fragment = new MenuMessageFragment();
                        break;
                    default:
                        Toast.makeText(UserMenuActivity.this, R.string.invalid_selection, Toast.LENGTH_SHORT).show();
                        fragment = new MenuHomeFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.lytRelativeParent, fragment).commit();
                return true;
            }
        });
    }
}