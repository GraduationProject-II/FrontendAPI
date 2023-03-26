package com.frontend.tutorcave.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.activity.ProfileActivity;
import com.frontend.tutorcave.activity.SettingsStatsActivity;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class MenuHomeFragment extends Fragment {

    private TextView viewStats;
    private AppCompatImageView btnProfile;

    // TODO: set anim

    public MenuHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        getParentFragmentManager().beginTransaction().replace(R.id.frgHomeDashVwLyt, new MenuHomeDashboardFragment()).commit();

        viewStats = (TextView) requireView().findViewById(R.id.frgHomeBtnViewAllStats);
        btnProfile = (AppCompatImageView) requireView().findViewById(R.id.frgHomeBtnProfile);

        viewStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuHomeFragment.this.getContext(), SettingsStatsActivity.class);
                startActivity(intent);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MenuHomeFragment.this.getContext(), ProfileActivity.class);
                startActivity(intent);
            }
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