package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.fragment.ProfileAccoladeFragment;
import com.frontend.tutorcave.fragment.ProfileDiscussionFragment;
import com.frontend.tutorcave.fragment.ProfileFeedbackFragment;
import com.frontend.tutorcave.fragment.ProfilePrivilegeFragment;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ProfileActivity extends AppCompatActivity {

    //private HorizontalScrollView scrollViewObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportFragmentManager().beginTransaction().replace(R.id.profileBottomSelectionView, new ProfileDiscussionFragment()).commit();

        AppCompatImageView btnSettings;
        CardView lytDiscussion;
        CardView lytPrivilege;
        CardView lytAccolades;
        CardView lytFeedback;

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

        btnSettings.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        lytDiscussion.setOnClickListener(view -> {
            // TODO: set bg and txt colors
            redirect(R.id.profileBottomSelectionView, new ProfileDiscussionFragment());
        });

        lytPrivilege.setOnClickListener(view -> {
            // TODO: set bg and txt colors
            redirect(R.id.profileBottomSelectionView, new ProfilePrivilegeFragment());
        });

        lytAccolades.setOnClickListener(view -> {
            // TODO: set bg and txt colors
            redirect(R.id.profileBottomSelectionView, new ProfileAccoladeFragment());
        });

        lytFeedback.setOnClickListener(view -> {
            // TODO: set bg and txt colors
            redirect(R.id.profileBottomSelectionView, new ProfileFeedbackFragment());
        });
    }

    private void redirect(int viewId, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(viewId, fragment).commit();
    }
}