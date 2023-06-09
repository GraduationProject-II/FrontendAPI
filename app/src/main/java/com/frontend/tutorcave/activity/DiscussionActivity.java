package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.adapter.DiscussionAnswerAdapter;
import com.frontend.tutorcave.model.DiscussionAnswerModel;
import com.frontend.tutorcave.model.DiscussionListItemModel;
import com.frontend.tutorcave.model.DiscussionWithAnswersModel;
import com.frontend.tutorcave.service.ApiService;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class DiscussionActivity extends AppCompatActivity {

    private ApiService apiService = new ApiService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion);

        // TODO: set anim

        TextView votes;
        TextView title;
        TextView desc;
        TextView date;
        TextView username;
        ImageView profilePic;
        RecyclerView recyclerVwAnswers;
        DiscussionAnswerAdapter listAdapter;
        Intent currentIntent = getIntent();

        votes = findViewById(R.id.dscTxtVote);
        title = findViewById(R.id.dscTxtTitle);
        desc = findViewById(R.id.dscTxtDesc);
        date = findViewById(R.id.dscTxtDate);
        username = findViewById(R.id.dscTxtUsername);
        profilePic = findViewById(R.id.dscImgVwPP);
        recyclerVwAnswers = findViewById(R.id.dscRcyVwAnswers);

        DiscussionWithAnswersModel responseModel =
                apiService.viewDiscussionWithAnswers(currentIntent.getStringExtra("id"));
        List<DiscussionAnswerModel> answers = new ArrayList<>(responseModel.getAnswerList());
        DiscussionListItemModel discussionModel = new DiscussionListItemModel(
                responseModel.getDiscussion().getId(),
                responseModel.getDiscussion().getTitle(),
                responseModel.getDiscussion().getDesc(),
                responseModel.getDiscussion().getUsername(),
                responseModel.getDiscussion().getDateOfCreation(),
                responseModel.getDiscussion().getLastUpdated(),
                responseModel.getDiscussion().getVote()
        );

        votes.setText(discussionModel.getVote());
        title.setText(discussionModel.getTitle());
        date.setText(discussionModel.getDateOfCreation());
        username.setText(discussionModel.getUsername());
        desc.setText(discussionModel.getDesc());
        profilePic.setImageResource(R.drawable.test_profile_pic_1);

        listAdapter = new DiscussionAnswerAdapter(answers, DiscussionActivity.this);
        recyclerVwAnswers.setAdapter(listAdapter);
        recyclerVwAnswers.setLayoutManager(new LinearLayoutManager(DiscussionActivity.this));

        username.setOnClickListener(view -> {
            // TODO: test purposes, delete afterwards and impl logic
            Toast.makeText(this, R.string.username, Toast.LENGTH_SHORT).show();
        });

    }
}