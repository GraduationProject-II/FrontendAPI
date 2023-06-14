package com.frontend.tutorcave.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.activity.UserMenuActivity;
import com.frontend.tutorcave.service.ApiService;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class MenuDiscussionFragment extends Fragment {

    private final ApiService apiService = new ApiService();
    private String userId;

    public MenuDiscussionFragment() {
        // Required empty public constructor
    }

    public MenuDiscussionFragment(String userId) {
        this.userId = userId;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        AppCompatImageView btnBackspace;
        TextView discussionCount;
        TextView discInvolved;
        TextView upvotesReceived;
        SearchView searchView;

        getParentFragmentManager().beginTransaction().replace(R.id.frgHomeDiscussionVwLyt, new ProfileDiscussionFragment(userId)).commit();

        btnBackspace = view.findViewById(R.id.frgMenuDiscBackspace);
        discussionCount = view.findViewById(R.id.menuDiscTxtDiscCount);
        discInvolved = view.findViewById(R.id.menuDiscTxtDInv);
        upvotesReceived = view.findViewById(R.id.menuDiscTxtUpV);
        searchView = view.findViewById(R.id.frgDiscussionSearchVw);

        discussionCount.setText(apiService.getAllDiscCount());
        discInvolved.setText(apiService.getDiscussionsInvolved(userId));
        upvotesReceived.setText(apiService.getVotesReceived(userId));

        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frgHomeDiscussionVwLyt, new ProfileDiscussionFragment(
                                apiService.searchDiscussion(query),
                                userId
                        ))
                        .commit();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frgHomeDiscussionVwLyt, new ProfileDiscussionFragment(
                                apiService.searchDiscussion(newText),
                                userId
                        ))
                        .commit();
                return false;
            }
        });

        btnBackspace.setOnClickListener(view1 -> {
            Intent intent = new Intent(view.getContext(), UserMenuActivity.class);
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
        return inflater.inflate(R.layout.fragment_menu_discussion, container, false);
    }
}