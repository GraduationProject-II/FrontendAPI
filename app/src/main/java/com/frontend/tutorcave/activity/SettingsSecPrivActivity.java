package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.frontend.tutorcave.R;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class SettingsSecPrivActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_sec_priv);

        RelativeLayout blocklist;
        RelativeLayout changeMail;
        RelativeLayout changePassword;
        AppCompatImageView btnBackspace;

        blocklist = findViewById(R.id.setOptRltLytSecPrivBlocklist);
        changeMail = findViewById(R.id.setOptRltLytSecPrivChangeMail);
        changePassword = findViewById(R.id.setOptRltLytSecPrivChangePassword);
        btnBackspace = findViewById(R.id.setSecPrivHeaderBackspace);

        setOptionOnClick(blocklist, "Blocklist");
        setOptionOnClick(changeMail, "Change mail");
        setOptionOnClick(changePassword, "Change password");

        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsSecPrivActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    // TODO: replace param testMessage with appropriate param(s) after test
    private void setOptionOnClick(RelativeLayout layout, String testMessage) {
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: impl logic
                // below task is for test purposes, delete afterwards
                Toast.makeText(view.getContext(), testMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}