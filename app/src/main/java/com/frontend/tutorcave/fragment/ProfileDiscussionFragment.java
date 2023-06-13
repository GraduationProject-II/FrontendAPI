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
import com.frontend.tutorcave.adapter.DiscussionListAdapter;
import com.frontend.tutorcave.model.DiscussionListItemModel;
import com.frontend.tutorcave.service.ApiService;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ProfileDiscussionFragment extends Fragment {

    private final ApiService apiService = new ApiService();
    private List<DiscussionListItemModel> passedList = new ArrayList<>();
    private String userId;
    private String userIdOther;

    public ProfileDiscussionFragment() {
        // Required empty public constructor
    }

    public ProfileDiscussionFragment(String userId) {
        this.userId = userId;
    }

    public ProfileDiscussionFragment(String userId, String userIdOther) {
        this.userId = userId;
        this.userIdOther = userIdOther;
    }

    public ProfileDiscussionFragment(List<DiscussionListItemModel> passedList, String userId) {
        this.passedList = passedList;
        this.userId = userId;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        RecyclerView recyclerView;
        DiscussionListAdapter listAdapter;

        recyclerView = view.findViewById(R.id.profileFrgDiscussionListRecyclerVw);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        if (!passedList.isEmpty())
            listAdapter = new DiscussionListAdapter(passedList, view.getContext());
        else {
            if (userIdOther == null) {
                List<DiscussionListItemModel> discussionListItemModels = new ArrayList<>(apiService.listDiscussions(userId));
                listAdapter = new DiscussionListAdapter(discussionListItemModels, view.getContext());
            }
            else {
                List<DiscussionListItemModel> discussionListItemModels = new ArrayList<>(apiService.listDiscussions(userIdOther));
                listAdapter = new DiscussionListAdapter(discussionListItemModels, view.getContext());
            }
        }
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_discussion, container, false);
    }
}