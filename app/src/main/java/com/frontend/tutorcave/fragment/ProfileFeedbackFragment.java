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
import com.frontend.tutorcave.adapter.FeedbackListAdapter;
import com.frontend.tutorcave.model.FeedbackListItemModel;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ProfileFeedbackFragment extends Fragment {

    public ProfileFeedbackFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        RecyclerView recyclerView;
        FeedbackListAdapter listAdapter;
        List<FeedbackListItemModel> feedbackListItemModels;

        recyclerView = view.findViewById(R.id.profileFrgFeedbackListRecyclerVw);

        feedbackListItemModels = new ArrayList<>();
        // TODO: below model assignment is for test purposes
        // retrieve actual data from backend api and delete below assignments
        feedbackListItemModels.add(new FeedbackListItemModel(
                R.drawable.test_profile_pic_1,
                "username1",
                "23",
                "Title #1",
                "Dfafsfasffcdeffdscfdusghckashushdksubsfjabfbasjsldla"
        ));
        feedbackListItemModels.add(new FeedbackListItemModel(
                R.drawable.test_profile_pic_2,
                "username2",
                "415",
                "Title #2",
                "jhlhsıhefofwefhowefhgwegfsahfhwofhwgfldfhoefghowfgoıewhfofgowgwlglıwglıwgw"
        ));
        feedbackListItemModels.add(new FeedbackListItemModel(
                R.drawable.test_profile_pic_3,
                "username3",
                "1934",
                "Title #3",
                "pjdfshılhlsıdhhnglsıhgıghpsşgskdg"
        ));
        feedbackListItemModels.add(new FeedbackListItemModel(
                R.drawable.test_profile_pic_4,
                "username4",
                "8",
                "Title #4",
                "jfwfjflıjwılfhwhljsldhfsdhllgknolghsdngösdngkbwsölndlgkbslbgdlöbg"
        ));

        listAdapter = new FeedbackListAdapter(feedbackListItemModels, view.getContext());
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_feedback, container, false);
    }
}