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

    private final ApiService apiService = new ApiService();
    private static final String USER_ID = "userId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final Intent currentIntent = getIntent();
        final String userId = currentIntent.getStringExtra(USER_ID);
        getSupportFragmentManager().beginTransaction().replace(R.id.profileBottomSelectionView, new ProfileDiscussionFragment(userId)).commit();

        AppCompatImageView profileImage;
        AppCompatImageView btnBackspace;
        AppCompatImageView btnCreateDisc;
        CardView lytDiscussion;
        CardView lytPrivilege;
        CardView lytAccolades;
        CardView lytFeedback;
        CardView lytSettings;
        TextView txtFullName;
        TextView txtUsername;
        TextView txtReputation;
        TextView txtAccType;

        profileImage = findViewById(R.id.profileImageVw);
        btnBackspace = findViewById(R.id.profileBackspace);
        btnCreateDisc = findViewById(R.id.prfNewDisc);
        lytDiscussion = findViewById(R.id.profileScrollObjectDiscussion);
        lytPrivilege = findViewById(R.id.profileScrollObjectPrivilege);
        lytAccolades = findViewById(R.id.profileScrollObjectAccolades);
        lytFeedback = findViewById(R.id.profileScrollObjectFeedbacks);
        lytSettings = findViewById(R.id.profileCrdVwSettings);
        txtFullName = findViewById(R.id.profileTxtFullName);
        txtUsername = findViewById(R.id.profileTxtUsername);
        txtReputation = findViewById(R.id.profileTxtReputation);
        txtAccType = findViewById(R.id.profileTxtAccType);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        UserInfoModel userInfo = apiService.getUserInfo(userId);
        Bitmap bitmap = BitmapFactory.decodeByteArray(userInfo.getImage(), 0, userInfo.getImage().length);
        profileImage.setImageBitmap(bitmap);
        txtFullName.setText(userInfo.getFullName());
        txtUsername.setText(userInfo.getUsername());
        txtAccType.setText(userInfo.getAccType());
        txtReputation.setText(userInfo.getReputation());

        lytSettings.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
            intent.putExtra(USER_ID, userId);
            startActivity(intent);
        });

        lytDiscussion.setOnClickListener(view -> {
            redirect(R.id.profileBottomSelectionView, new ProfileDiscussionFragment(userId));
        });

        lytPrivilege.setOnClickListener(view -> {
            redirect(R.id.profileBottomSelectionView, new ProfilePrivilegeFragment(userId));
        });

        lytAccolades.setOnClickListener(view -> {
            redirect(R.id.profileBottomSelectionView, new ProfileAccoladeFragment(userId));
        });

        lytFeedback.setOnClickListener(view -> {
            redirect(R.id.profileBottomSelectionView, new ProfileFeedbackFragment(userId));
        });

        btnBackspace.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, UserMenuActivity.class);
            intent.putExtra(USER_ID, userId);
            startActivity(intent);
        });

        btnCreateDisc.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, CreateDiscussionActivity.class);
            intent.putExtra(USER_ID, userId);
            startActivity(intent);
        });
    }

    private void redirect(int viewId, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(viewId, fragment).commit();
    }
}