package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.fragment.ProfileAccoladeFragment;
import com.frontend.tutorcave.fragment.ProfileDiscussionFragment;
import com.frontend.tutorcave.fragment.ProfileFeedbackFragment;
import com.frontend.tutorcave.fragment.ProfilePrivilegeFragment;
import com.frontend.tutorcave.model.UserInfoModel;
import com.frontend.tutorcave.service.ApiService;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ProfileActivity extends AppCompatActivity {

    private ApiService apiService = new ApiService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportFragmentManager().beginTransaction().replace(R.id.profileBottomSelectionView, new ProfileDiscussionFragment()).commit();

        AppCompatImageView btnSettings;
        AppCompatImageView profileImage;
        CardView lytDiscussion;
        CardView lytPrivilege;
        CardView lytAccolades;
        CardView lytFeedback;
        TextView txtFullName;
        TextView txtUsername;
        TextView txtReputation;
        TextView txtAccType;

        // TODO: set anim

        btnSettings = (AppCompatImageView) findViewById(R.id.profileSettings);
        profileImage = findViewById(R.id.profileImageVw);
        lytDiscussion = (CardView) findViewById(R.id.profileScrollObjectDiscussion);
        lytPrivilege = (CardView) findViewById(R.id.profileScrollObjectPrivilege);
        lytAccolades = (CardView) findViewById(R.id.profileScrollObjectAccolades);
        lytFeedback = (CardView) findViewById(R.id.profileScrollObjectFeedbacks);
        //scrollViewObjects = (HorizontalScrollView) findViewById(R.id.profileHorizontalScrollVw);
        txtFullName = findViewById(R.id.profileTxtFullName);
        txtUsername = findViewById(R.id.profileTxtUsername);
        txtReputation = findViewById(R.id.profileTxtReputation);
        txtAccType = findViewById(R.id.profileTxtAccType);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        UserInfoModel userInfo = apiService.getUserInfo("999");
        Bitmap bitmap = BitmapFactory.decodeByteArray(userInfo.getImage(), 0, userInfo.getImage().length);
        profileImage.setImageBitmap(bitmap);
        txtFullName.setText(userInfo.getFullName());
        txtUsername.setText(userInfo.getUsername());
        txtAccType.setText(userInfo.getAccType());
        txtReputation.setText(userInfo.getReputation());

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