package com.frontend.tutorcave.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.activity.WelcomeActivity;
import com.frontend.tutorcave.adapter.GuestHomeListAdapter;
import com.frontend.tutorcave.model.HomeMenuDashboardItemModel;
import com.frontend.tutorcave.service.ApiService;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */
public class GuestMenuHomeFragment extends Fragment {

    private final ApiService apiService = new ApiService();

    public GuestMenuHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView;
        TextView btnStats;
        AppCompatImageView btnProfile;
        AppCompatImageView btnBackspace;
        GuestHomeListAdapter listAdapter;

        recyclerView = view.findViewById(R.id.frgGstHomeDashVwLyt);
        btnStats = view.findViewById(R.id.frgGstHomeBtnViewAllStats);
        btnProfile = view.findViewById(R.id.frgGstHomeBtnProfile);
        btnBackspace = view.findViewById(R.id.frgGstMenuHomeBackspace);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        List<HomeMenuDashboardItemModel> dashboardItemModels = new ArrayList<>(apiService.listHighRepUsers());
        listAdapter = new GuestHomeListAdapter(dashboardItemModels, view.getContext());
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        btnStats.setOnClickListener(view1 -> toast(view.getContext(), getString(R.string.login_to_access_stats)));
        btnProfile.setOnClickListener(view1 -> toast(view.getContext(), getString(R.string.login_to_access)));

        btnBackspace.setOnClickListener(view1 -> {
            Intent intent = new Intent(view.getContext(), WelcomeActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_guest_menu_home, container, false);
    }

    private void toast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}