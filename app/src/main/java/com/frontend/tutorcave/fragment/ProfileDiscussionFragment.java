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
import com.frontend.tutorcave.adapter.DiscussionListAdapter;
import com.frontend.tutorcave.model.DiscussionListItemModel;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ProfileDiscussionFragment extends Fragment {

    public ProfileDiscussionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView;
        DiscussionListAdapter listAdapter;
        List<DiscussionListItemModel> discussionListItemModels;

        recyclerView = view.findViewById(R.id.profileFrgDiscussionListRecyclerVw);

        discussionListItemModels = new ArrayList<>();
        // TODO: below model assignment is for test purposes
        // retrieve actual data from backend api and delete below assignments
        discussionListItemModels.add(new DiscussionListItemModel(
                1,
                "This is an example title #1 among others",
                "test_username_1",
                "29/09/1923",
                "30/08/2023",
                "82"
        ));
        discussionListItemModels.add(new DiscussionListItemModel(
                2,
                "This is an example title #2 among others",
                "test_username_2",
                "23/04/1956",
                "30/08/2010",
                "15"
        ));
        discussionListItemModels.add(new DiscussionListItemModel(
                3,
                "This is an example title #3 among others",
                "test_username_3",
                "17/02/2023",
                "27/03/2023",
                "-3"
        ));
        discussionListItemModels.add(new DiscussionListItemModel(
                4,
                "This is an example title #4 among others",
                "test_username_4",
                "01/01/1989",
                "05/11/2013",
                "2350"
        ));
        discussionListItemModels.add(new DiscussionListItemModel(
                5,
                "This is an example title #5 among others",
                "test_username_5",
                "14/02/1921",
                "16/10/2019",
                "-14"
        ));

        listAdapter = new DiscussionListAdapter(discussionListItemModels, view.getContext());
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