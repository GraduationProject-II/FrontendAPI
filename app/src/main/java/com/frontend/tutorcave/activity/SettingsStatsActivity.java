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

public class SettingsStatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_stats);

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

        setOptionOnClick(viewRep, "Reputation");
        setOptionOnClick(viewAccolades, "Accolades");
        setOptionOnClick(viewPrivileges, "Privileges");
        setOptionOnClick(viewDiscussionsInvolved, "Discussions involved");
        setOptionOnClick(viewTutoringSrv, "Tutoring services");
        setOptionOnClick(viewFeedbacks, "Feedbacks");

        btnBackspace.setOnClickListener(view -> {

            Intent intent = new Intent(SettingsStatsActivity.this, SettingsActivity.class);
            startActivity(intent);
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