package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.fragment.ProfileAccoladeFragment;
import com.frontend.tutorcave.fragment.ProfileDiscussionFragment;
import com.frontend.tutorcave.fragment.ProfilePrivilegeFragment;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ProfileActivity extends AppCompatActivity {

    private AppCompatImageView btnSettings;
    private CardView lytDiscussion, lytPrivilege, lytAccolades, lytFeedback;
    //private HorizontalScrollView scrollViewObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportFragmentManager().beginTransaction().replace(R.id.profileBottomSelectionView, new ProfileDiscussionFragment()).commit();

        // TODO: set anim

        btnSettings = (AppCompatImageView) findViewById(R.id.profileSettings);
        lytDiscussion = (CardView) findViewById(R.id.profileScrollObjectDiscussion);
        lytPrivilege = (CardView) findViewById(R.id.profileScrollObjectPrivilege);
        lytAccolades = (CardView) findViewById(R.id.profileScrollObjectAccolades);
        lytFeedback = (CardView) findViewById(R.id.profileScrollObjectFeedbacks);
        //scrollViewObjects = (HorizontalScrollView) findViewById(R.id.profileHorizontalScrollVw);

        // TODO: complete below task
        //scrollViewObjects.setLeftEdgeEffectColor();
        //scrollViewObjects.setRightEdgeEffectColor();

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        lytDiscussion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: set bg and txt colors
                getSupportFragmentManager().beginTransaction().replace(R.id.profileBottomSelectionView, new ProfileDiscussionFragment()).commit();
            }
        });

        lytPrivilege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: set bg and txt colors
                getSupportFragmentManager().beginTransaction().replace(R.id.profileBottomSelectionView, new ProfilePrivilegeFragment()).commit();
            }
        });

        lytAccolades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: set bg and txt colors
                getSupportFragmentManager().beginTransaction().replace(R.id.profileBottomSelectionView, new ProfileAccoladeFragment()).commit();
            }
        });

        lytFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: implement logic, set bg and txt colors
            }
        });
    }
}