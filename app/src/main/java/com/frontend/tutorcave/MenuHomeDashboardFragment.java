package com.frontend.tutorcave;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frontend.tutorcave.adapter.HomeDashboardListAdapter;
import com.frontend.tutorcave.model.HomeMenuDashboardItemModel;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class MenuHomeDashboardFragment extends Fragment {

    public MenuHomeDashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView;
        HomeDashboardListAdapter listAdapter;
        List<HomeMenuDashboardItemModel> dashboardItemModels;

        recyclerView = view.findViewById(R.id.frgHomeDashRecyclerVw);

        dashboardItemModels = new ArrayList<>();
        // TODO: below model assignment is for test purposes
        // retrieve actual data from backend api and delete below assignments
        dashboardItemModels.add(new HomeMenuDashboardItemModel(
                "Alex Robert",
                "username#1",
                "32",
                R.drawable.test_profile_pic_1
        ));
        dashboardItemModels.add(new HomeMenuDashboardItemModel(
                "Leidolf Sommer",
                "username#2",
                "5463",
                R.drawable.test_profile_pic_2
        ));
        dashboardItemModels.add(new HomeMenuDashboardItemModel(
                "Ipanea Ivy",
                "username#3",
                "8",
                R.drawable.test_profile_pic_3
        ));
        dashboardItemModels.add(new HomeMenuDashboardItemModel(
                "Portul Lammers",
                "username#4",
                "56",
                R.drawable.test_profile_pic_4
        ));

        listAdapter = new HomeDashboardListAdapter(dashboardItemModels, view.getContext());
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_home_dashboard, container, false);
    }
}