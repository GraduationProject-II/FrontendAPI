package com.frontend.tutorcave.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.adapter.PrivilegeListAdapter;
import com.frontend.tutorcave.model.PrivilegeListItemModel;
import com.frontend.tutorcave.service.ApiService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ProfilePrivilegeFragment extends Fragment {

    private final ApiService apiService = new ApiService();
    private String userId;

    public ProfilePrivilegeFragment() {
        // Required empty public constructor
    }

    public ProfilePrivilegeFragment(String userId) {
        this.userId = userId;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView;
        PrivilegeListAdapter listAdapter;

        recyclerView = view.findViewById(R.id.profileFrgPrivListRecyclerVw);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        List<PrivilegeListItemModel> privilegeListItemModels = new ArrayList<>(listPrivileges());
        listAdapter = new PrivilegeListAdapter(privilegeListItemModels, view.getContext());
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_privilege, container, false);
    }

    private List<PrivilegeListItemModel> listPrivileges() {
        Map<String, String> privilegeList = new HashMap<>(apiService.listPrivileges(userId));
        List<PrivilegeListItemModel> itemModels = new ArrayList<>();
        privilegeList.forEach((k,v) -> {
            itemModels.add(new PrivilegeListItemModel(k, v));
        });
        return itemModels;
    }
}