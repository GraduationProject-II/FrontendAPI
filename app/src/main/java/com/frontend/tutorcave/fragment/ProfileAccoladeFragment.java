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
import com.frontend.tutorcave.adapter.AccoladeListAdapter;
import com.frontend.tutorcave.model.AccoladeListItemModel;
import com.frontend.tutorcave.service.ApiService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ProfileAccoladeFragment extends Fragment {

    private final ApiService apiService = new ApiService();
    private String userId;

    public ProfileAccoladeFragment() {
        // Required empty public constructor
    }

    public ProfileAccoladeFragment(String userId) {
        this.userId = userId;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        RecyclerView recyclerView;
        AccoladeListAdapter listAdapter;

        recyclerView = view.findViewById(R.id.profileFrgAccoladeListRecyclerVw);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        List<AccoladeListItemModel> accoladeListItemModels = new ArrayList<>(listAccolades());
        listAdapter = new AccoladeListAdapter(accoladeListItemModels, view.getContext());
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_accolade, container, false);
    }

    private List<AccoladeListItemModel> listAccolades() {
        Map<String, String> accoladeList = new HashMap<>(apiService.listAccolades(userId));
        List<AccoladeListItemModel> itemModels = new ArrayList<>();
        accoladeList.forEach((k,v) -> {
            itemModels.add(new AccoladeListItemModel(k, v));
        });
        return itemModels;
    }
}