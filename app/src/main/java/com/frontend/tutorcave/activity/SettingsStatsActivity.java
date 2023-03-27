package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.service.SettingsService;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class SettingsStatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_stats);

        SettingsService settingsService = new SettingsService();
        RelativeLayout viewRep;
        RelativeLayout viewAccolades;
        RelativeLayout viewPrivileges;
        RelativeLayout viewDiscussionsInvolved;
        RelativeLayout viewTutoringSrv;
        RelativeLayout viewFeedbacks;
        AppCompatImageView btnBackspace;

        viewRep = findViewById(R.id.setOptRltLytStatsRep);
        viewAccolades = findViewById(R.id.setOptRltLytStatsAccolade);
        viewPrivileges = findViewById(R.id.setOptRltLytStatsPrivilege);
        viewDiscussionsInvolved = findViewById(R.id.setOptRltLytStatsDisInv);
        viewTutoringSrv = findViewById(R.id.setOptRltLytStatsTutSrv);
        viewFeedbacks = findViewById(R.id.setOptRltLytStatsFeedback);
        btnBackspace = findViewById(R.id.setStatsHeaderBackspace);

        settingsService.redirect(viewRep, SettingsStatsActivity.this, "Reputation");
        settingsService.redirect(viewAccolades, SettingsStatsActivity.this, "Accolades");
        settingsService.redirect(viewPrivileges, SettingsStatsActivity.this, "Privileges");
        settingsService.redirect(viewDiscussionsInvolved, SettingsStatsActivity.this, "Discussions involved");
        settingsService.redirect(viewTutoringSrv, SettingsStatsActivity.this, "Tutoring services");
        settingsService.redirect(viewFeedbacks, SettingsStatsActivity.this, "Feedbacks");
        settingsService.redirect(btnBackspace, SettingsStatsActivity.this, SettingsActivity.class);
    }
}