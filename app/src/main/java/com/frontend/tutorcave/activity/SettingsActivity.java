package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.model.SaveSettingsServiceModel;
import com.frontend.tutorcave.service.SettingsService;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // declarations
        SettingsService settingsService = new SettingsService();
        AppCompatImageView btnBackspace;
        AppCompatButton btnEditPP;
        AppCompatButton btnSaveSettings;
        SwitchCompat swNightTheme;
        SwitchCompat swNotification;
        SwitchCompat swAccPrivacy;
        RelativeLayout btnNavToSecurity;
        RelativeLayout btnNavToStats;
        RelativeLayout btnNavToAboutUs;
        RelativeLayout btnLogout;

        // TODO: set anim

        // assignments
        btnBackspace = (AppCompatImageView) findViewById(R.id.settingsImgVwBackspace);
        btnEditPP = (AppCompatButton) findViewById(R.id.settingsBtnEditPP);
        btnSaveSettings = (AppCompatButton) findViewById(R.id.settingsBtnSave);
        swNightTheme = (SwitchCompat) findViewById(R.id.settingsOptionSwitchNightTheme);
        swNotification = (SwitchCompat) findViewById(R.id.settingsOptionSwitchNotification);
        swAccPrivacy = (SwitchCompat) findViewById(R.id.settingsOptionSwitchPrivateAcc);
        btnNavToSecurity = (RelativeLayout) findViewById(R.id.settingsOptionRltLytNavSec);
        btnNavToStats = (RelativeLayout) findViewById(R.id.settingsOptionRltLytNavStats);
        btnNavToAboutUs = (RelativeLayout) findViewById(R.id.settingsOptionRltLytNavAboutUs);
        btnLogout = (RelativeLayout) findViewById(R.id.settingsOptionRltLytLogout);

        settingsService.redirect(btnBackspace, SettingsActivity.this, ProfileActivity.class); // TODO: add a pop-up saying discard changes and implement logic
        settingsService.redirect(btnNavToSecurity, SettingsActivity.this, SettingsSecPrivActivity.class);
        settingsService.redirect(btnNavToStats, SettingsActivity.this, SettingsStatsActivity.class);
        settingsService.redirect(btnNavToAboutUs, SettingsActivity.this, "Navigate to About Us");
        settingsService.redirect(btnLogout, SettingsActivity.this, "Logout");
        settingsService.redirect(btnEditPP, SettingsActivity.this, "Edit PP");

        SaveSettingsServiceModel saveModel = new SaveSettingsServiceModel();
        saveModel.setContext(SettingsActivity.this);
        saveModel.setNightTheme(swNightTheme);
        saveModel.setNotifications(swNotification);
        saveModel.setAccountPrivacy(swAccPrivacy);
        saveModel.setClassName(SettingsActivity.class.getName());
        settingsService.saveSettings(btnSaveSettings, saveModel);
    }
}