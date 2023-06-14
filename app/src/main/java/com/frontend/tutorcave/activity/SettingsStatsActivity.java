package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.fragment.ProfileAccoladeFragment;
import com.frontend.tutorcave.fragment.ProfilePrivilegeFragment;
import com.frontend.tutorcave.service.ApiService;
import com.frontend.tutorcave.service.SettingsService;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class SettingsStatsActivity extends AppCompatActivity {

    private final ApiService apiService = new ApiService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_stats);

        final Intent currentIntent = getIntent();
        final String userId = currentIntent.getStringExtra("userId");

        SettingsService settingsService = new SettingsService();
        RelativeLayout viewRep;
        RelativeLayout viewAccolades;
        RelativeLayout viewPrivileges;
        AppCompatImageView btnBackspace;

        viewRep = findViewById(R.id.setOptRltLytStatsRep);
        viewAccolades = findViewById(R.id.setOptRltLytStatsAccolade);
        viewPrivileges = findViewById(R.id.setOptRltLytStatsPrivilege);
        btnBackspace = findViewById(R.id.setStatsHeaderBackspace);

        viewRep.setOnClickListener(view -> {
            String username = apiService.getUserInfo(userId).getUsername();
            Toast.makeText(this, apiService.getReputation(username), Toast.LENGTH_SHORT).show();
        });

        viewAccolades.setOnClickListener(view -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.setStatsLytBase, new ProfileAccoladeFragment(userId))
                    .commit();
        });

        viewPrivileges.setOnClickListener(view -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.setStatsLytBase, new ProfilePrivilegeFragment(userId))
                    .commit();
        });

        settingsService.redirect(btnBackspace, SettingsStatsActivity.this, SettingsActivity.class, userId);
    }
}