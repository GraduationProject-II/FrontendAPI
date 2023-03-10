package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SwitchCompat;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.frontend.tutorcave.R;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class SettingsActivity extends AppCompatActivity {

    // declarations
    private AppCompatImageView btnBackspace;
    private AppCompatButton btnEditPP, btnSaveSettings;
    private SwitchCompat swNightTheme, swNotification, swAccPrivacy;
    private RelativeLayout btnNavToSecurity, btnNavToStats, btnNavToAboutUs, btnLogout;
    private Dialog dlgSecPriv, dlgStats; // TODO: design dialog about us and logout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

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
        dlgSecPriv = new Dialog(this);
        dlgStats = new Dialog(this);

        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: add a pop-up saying discard changes and implement logic
                Intent intent = new Intent(SettingsActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        btnNavToSecurity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchPopUpSecAndPriv();
            }
        });

        btnNavToStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchPopUpStats();
            }
        });

        btnNavToAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: impl logic

                // TODO: below task is for test purposes, delete afterwards
                Toast.makeText(SettingsActivity.this, "Navigate to About Us", Toast.LENGTH_SHORT).show();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: impl logic

                // TODO: below task is for test purposes, delete afterwards
                Toast.makeText(SettingsActivity.this, "Logout", Toast.LENGTH_SHORT).show();
            }
        });

        btnEditPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: implement logic

                // TODO: below task is for test purposes, delete afterwards
                Toast.makeText(SettingsActivity.this, "Edit PP", Toast.LENGTH_SHORT).show();
            }
        });

        btnSaveSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: implement logic

                // TODO: below task till end of the method is for test purposes, delete afterwards
                boolean isNightTheme;
                boolean isNotification;
                boolean isAccPrivacy;
                isNightTheme = swNightTheme.isChecked();
                isNotification = swNotification.isChecked();
                isAccPrivacy = swAccPrivacy.isChecked();

                if (isNightTheme)
                    Toast.makeText(SettingsActivity.this, "Night Theme Checked", Toast.LENGTH_SHORT).show();
                else Toast.makeText(SettingsActivity.this, "Night Theme Not Checked", Toast.LENGTH_SHORT).show();

                if (isNotification)
                    Toast.makeText(SettingsActivity.this, "Notifications Checked", Toast.LENGTH_SHORT).show();
                else Toast.makeText(SettingsActivity.this, "Notifications Not Checked", Toast.LENGTH_SHORT).show();

                if (isAccPrivacy)
                    Toast.makeText(SettingsActivity.this, "Acc Privacy Checked", Toast.LENGTH_SHORT).show();
                else Toast.makeText(SettingsActivity.this, "Acc Privacy Not Checked", Toast.LENGTH_SHORT).show();

                Thread timer = new Thread() {
                    @Override
                    public void run() {
                        try {
                            sleep(8000);
                        }
                        catch (InterruptedException exception) {
                            exception.printStackTrace();
                        }
                        finally {
                            finish();
                        }
                    }
                };
                timer.start();
                Toast.makeText(SettingsActivity.this, "Saved changes", Toast.LENGTH_SHORT).show();
                // delete till here
            }
        });
    }

    private void initPopUp(final Dialog dialog, final int componentId) {
        dialog.setContentView(componentId);
    }

    private void launchPopUpSecAndPriv() {
        initPopUp(dlgSecPriv, R.layout.popup_settings_sec_and_privacy);
        dlgSecPriv.show();

        RelativeLayout blocklist, changeMail, changePassword;

        blocklist = (RelativeLayout) dlgSecPriv.findViewById(R.id.setOptRltLytSecPrivBlocklist);
        changeMail = (RelativeLayout) dlgSecPriv.findViewById(R.id.setOptRltLytSecPrivChangeMail);
        changePassword = (RelativeLayout) dlgSecPriv.findViewById(R.id.setOptRltLytSecPrivChangePassword);

        dialogOnClick(blocklist, "Blocklist");
        dialogOnClick(changeMail, "Change mail");
        dialogOnClick(changePassword, "Change password");
    }

    private void launchPopUpStats() {
        initPopUp(dlgStats, R.layout.popup_settings_stats);
        dlgStats.show();

        RelativeLayout rep, accolade, privilege, discussionInvolved, tutoringServices, feedback;

        rep = (RelativeLayout) dlgStats.findViewById(R.id.setOptRltLytStatsRep);
        accolade = (RelativeLayout) dlgStats.findViewById(R.id.setOptRltLytStatsAccolade);
        privilege = (RelativeLayout) dlgStats.findViewById(R.id.setOptRltLytStatsPrivilege);
        discussionInvolved = (RelativeLayout) dlgStats.findViewById(R.id.setOptRltLytStatsDisInv);
        tutoringServices = (RelativeLayout) dlgStats.findViewById(R.id.setOptRltLytStatsTutSrv);
        feedback = (RelativeLayout) dlgStats.findViewById(R.id.setOptRltLytStatsFeedback);

        dialogOnClick(rep, "Reputation");
        dialogOnClick(accolade, "Accolades");
        dialogOnClick(privilege, "Privileges");
        dialogOnClick(discussionInvolved, "Discussions involved");
        dialogOnClick(tutoringServices, "Tutoring services");
        dialogOnClick(feedback, "Feedbacks");
    }

    // TODO: replace param testMessage with appropriate param(s) after test
    private void dialogOnClick(RelativeLayout layout, String testMessage) {
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: impl logic

                // below task is for test purposes, delete afterwards
                Toast.makeText(SettingsActivity.this, testMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}