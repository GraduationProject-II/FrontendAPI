package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.service.SettingsService;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class SettingsSecPrivActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_sec_priv);

        SettingsService settingsService = new SettingsService();
        RelativeLayout blocklist;
        RelativeLayout changeMail;
        RelativeLayout changePassword;
        AppCompatImageView btnBackspace;

        blocklist = findViewById(R.id.setOptRltLytSecPrivBlocklist);
        changeMail = findViewById(R.id.setOptRltLytSecPrivChangeMail);
        changePassword = findViewById(R.id.setOptRltLytSecPrivChangePassword);
        btnBackspace = findViewById(R.id.setSecPrivHeaderBackspace);

        settingsService.redirect(blocklist, SettingsSecPrivActivity.this, "Blocklist");
        settingsService.redirect(changeMail, SettingsSecPrivActivity.this, "Change mail");
        settingsService.redirect(changePassword, SettingsSecPrivActivity.this, "Change password");
        settingsService.redirect(btnBackspace, SettingsSecPrivActivity.this, SettingsActivity.class);
    }
}