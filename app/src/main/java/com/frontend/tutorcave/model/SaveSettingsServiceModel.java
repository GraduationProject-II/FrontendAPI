package com.frontend.tutorcave.model;

import android.content.Context;

import androidx.appcompat.widget.SwitchCompat;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class SaveSettingsServiceModel {
    private Context context;
    private SwitchCompat nightTheme;
    private SwitchCompat notifications;
    private SwitchCompat accountPrivacy;

    public SaveSettingsServiceModel() {
        // required empty constructor
    }

    public SwitchCompat getNightTheme() {
        return nightTheme;
    }

    public void setNightTheme(SwitchCompat nightTheme) {
        this.nightTheme = nightTheme;
    }

    public SwitchCompat getNotifications() {
        return notifications;
    }

    public void setNotifications(SwitchCompat notifications) {
        this.notifications = notifications;
    }

    public SwitchCompat getAccountPrivacy() {
        return accountPrivacy;
    }

    public void setAccountPrivacy(SwitchCompat accountPrivacy) {
        this.accountPrivacy = accountPrivacy;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getNightThemeOn() {
        return "Night Theme Checked";
    }

    public String getNightThemeOff() {
        return "Night Theme Not Checked";
    }

    public String getNotificationsOn() {
        return "Notifications Checked";
    }

    public String getNotificationsOff() {
        return "Notifications Not Checked";
    }

    public String getAccountPrivacyOn() {
        return "Acc Privacy Checked";
    }

    public String getAccountPrivacyOff() {
        return "Acc Privacy Not Checked";
    }
}