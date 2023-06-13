package com.frontend.tutorcave.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.adapter.TutorListAdapter;
import com.frontend.tutorcave.model.TutorListItemModel;
import com.frontend.tutorcave.service.ApiService;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class MenuTutorListFragment extends Fragment {

    private final ApiService apiService = new ApiService();
    private List<TutorListItemModel> rawList = new ArrayList<>();
    private String userId;

    public MenuTutorListFragment() {
        // Required empty public constructor
    }

    public MenuTutorListFragment(String userId) {
        this.userId = userId;
    }

    public MenuTutorListFragment(List<TutorListItemModel> rawList, String userId) {
        this.rawList = rawList;
        this.userId = userId;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        RecyclerView recyclerView;
        TutorListAdapter listAdapter;

        recyclerView = view.findViewById(R.id.frgTutorRecyclerVw);

        if (rawList.isEmpty()) {
            List<TutorListItemModel> tutorListItemModels = new ArrayList<>(apiService.listTutorWithHighRep());
            listAdapter = new TutorListAdapter(tutorListItemModels, view.getContext(), userId);
        }
        else
            listAdapter = new TutorListAdapter(rawList, view.getContext(), userId);

        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_tutor_list, container, false);
    }
}