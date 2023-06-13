package com.frontend.tutorcave.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.activity.ProfileActivity;
import com.frontend.tutorcave.activity.SettingsStatsActivity;
import com.frontend.tutorcave.service.ApiService;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class MenuHomeFragment extends Fragment {

    private final ApiService apiService = new ApiService();

    private String userId;

    public MenuHomeFragment() {
        // Required empty public constructor
    }

    public MenuHomeFragment(String userId) {
        this.userId = userId;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getParentFragmentManager().beginTransaction().replace(R.id.frgHomeDashVwLyt, new MenuHomeDashboardFragment(userId)).commit();

        AppCompatImageView btnProfile;
        TextView viewStats;
        TextView accoladeCount;
        TextView repCount;
        TextView feedbackCount;

        viewStats = requireView().findViewById(R.id.frgHomeBtnViewAllStats);
        btnProfile = requireView().findViewById(R.id.frgHomeBtnProfile);
        accoladeCount = view.findViewById(R.id.homeAccoladeCount);
        repCount = view.findViewById(R.id.homeRepCount);
        feedbackCount = view.findViewById(R.id.homeFeedbackCount);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        accoladeCount.setText(apiService.getAccoladeCount(userId));
        repCount.setText(apiService.getReputation(apiService.getUserInfo(userId).getUsername()));
        feedbackCount.setText(apiService.getFeedbackCount(userId));

        viewStats.setOnClickListener(view1 -> {
            Intent intent = new Intent(MenuHomeFragment.this.getContext(), SettingsStatsActivity.class);
            intent.putExtra("userId", userId);
            startActivity(intent);
        });

        btnProfile.setOnClickListener(view12 -> {
            Intent intent;
            intent = new Intent(MenuHomeFragment.this.getContext(), ProfileActivity.class);
            intent.putExtra("userId", userId);
            startActivity(intent);
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_home, container, false);
    }
}