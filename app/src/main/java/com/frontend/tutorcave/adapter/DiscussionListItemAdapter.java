package com.frontend.tutorcave.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.model.DiscussionListItemModel;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class DiscussionListItemAdapter extends PagerAdapter {

    private LayoutInflater inflater;
    private Context context;

    public DiscussionListItemAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.profile_vw_pgr_discussion, container, false);

        RecyclerView recyclerView;
        RecyclerViewDiscussionAdapter listAdapter;
        List<DiscussionListItemModel> discussionListItemModels;

        recyclerView = view.findViewById(R.id.profileDiscussionListRecyclerVw);

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

        listAdapter = new RecyclerViewDiscussionAdapter(discussionListItemModels, view.getContext());
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}