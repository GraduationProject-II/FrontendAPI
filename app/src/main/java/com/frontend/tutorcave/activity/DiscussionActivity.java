package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.adapter.DiscussionAnswerAdapter;
import com.frontend.tutorcave.model.DiscussionAnswerModel;
import com.frontend.tutorcave.model.DiscussionListItemModel;
import com.frontend.tutorcave.model.DiscussionWithAnswersModel;
import com.frontend.tutorcave.model.UserInfoModel;
import com.frontend.tutorcave.service.ApiService;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class DiscussionActivity extends AppCompatActivity {

    private final ApiService apiService = new ApiService();
    private final Intent currentIntent = getIntent();
    private final String userId = currentIntent.getStringExtra("userId");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion);

        TextView votes;
        TextView title;
        TextView desc;
        TextView date;
        TextView username;
        ImageView profilePic;
        LinearLayout lytGoToUser;
        RecyclerView recyclerVwAnswers;
        DiscussionAnswerAdapter listAdapter;

        votes = findViewById(R.id.dscTxtVote);
        title = findViewById(R.id.dscTxtTitle);
        desc = findViewById(R.id.dscTxtDesc);
        date = findViewById(R.id.dscTxtDate);
        username = findViewById(R.id.dscTxtUsername);
        profilePic = findViewById(R.id.dscImgVwPP);
        lytGoToUser = findViewById(R.id.discussionLytUser);
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

        byte[] imageData = apiService.getUserInfo(userId).getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.length);

        profilePic.setImageBitmap(bitmap);
        votes.setText(discussionModel.getVote());
        title.setText(discussionModel.getTitle());
        date.setText(discussionModel.getDateOfCreation());
        username.setText(discussionModel.getUsername());
        desc.setText(discussionModel.getDesc());

        listAdapter = new DiscussionAnswerAdapter(answers, DiscussionActivity.this, userId);
        recyclerVwAnswers.setAdapter(listAdapter);
        recyclerVwAnswers.setLayoutManager(new LinearLayoutManager(DiscussionActivity.this));

        lytGoToUser.setOnClickListener(view -> {
            String userId = apiService.getUserId(discussionModel.getUsername());
            UserInfoModel userModel = apiService.getUserInfo(userId);
            Intent intent = new Intent(view.getContext(), ViewProfileActivity.class);
            intent.putExtra("image", userModel.getImage());
            intent.putExtra("username", userModel.getUsername());
            intent.putExtra("accountType", userModel.getAccType());
            intent.putExtra("rep", userModel.getAccType());
            intent.putExtra("name", userModel.getFullName());
            intent.putExtra("userId", userId);
            startActivity(intent);
        });
    }
}