package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.adapter.DiscussionListItemAdapter;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ProfileActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private DiscussionListItemAdapter discussionAdapter;
    private AppCompatImageView btnSettings;
    private CardView lytDiscussion, lytPrivilege, lytAccolades, lytFeedback;
    private HorizontalScrollView scrollViewObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // TODO: set anim

        btnSettings = (AppCompatImageView) findViewById(R.id.profileSettings);
        lytDiscussion = (CardView) findViewById(R.id.profileScrollObjectDiscussion);
        lytPrivilege = (CardView) findViewById(R.id.profileScrollObjectPrivilege);
        lytAccolades = (CardView) findViewById(R.id.profileScrollObjectAccolades);
        lytFeedback = (CardView) findViewById(R.id.profileScrollObjectFeedbacks);
        scrollViewObjects = (HorizontalScrollView) findViewById(R.id.profileHorizontalScrollVw);
        viewPager = (ViewPager) findViewById(R.id.profileVwPager);

        discussionAdapter = new DiscussionListItemAdapter(this);
        viewPager.setAdapter(discussionAdapter);

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
                // TODO: implement logic, set bg and txt colors
            }
        });

        lytPrivilege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: implement logic, set bg and txt colors
            }
        });

        lytAccolades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: implement logic, set bg and txt colors
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