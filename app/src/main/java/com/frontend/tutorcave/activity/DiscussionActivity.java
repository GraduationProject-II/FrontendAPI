package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.adapter.DiscussionAnswerAdapter;
import com.frontend.tutorcave.model.DiscussionAnswerModel;
import com.frontend.tutorcave.model.DiscussionListItemModel;
import com.frontend.tutorcave.model.DiscussionWithAnswersModel;
import com.frontend.tutorcave.model.UserInfoModel;
import com.frontend.tutorcave.service.ApiService;
import com.frontend.tutorcave.util.TimerUtil;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class DiscussionActivity extends AppCompatActivity {

    private final ApiService apiService = new ApiService();
    private static final String USER_ID = "userId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion);

        final Intent currentIntent = getIntent();
        final String userId = currentIntent.getStringExtra(USER_ID);

        TextView votes;
        TextView title;
        TextView desc;
        TextView date;
        TextView username;
        ImageView profilePic;
        AppCompatImageView btnVoteUp;
        AppCompatImageView btnBackspace;
        AppCompatImageView btnNewAnswer;
        LinearLayout lytGoToUser;
        RecyclerView recyclerVwAnswers;
        DiscussionAnswerAdapter listAdapter;

        votes = findViewById(R.id.dscTxtVote);
        title = findViewById(R.id.dscTxtTitle);
        desc = findViewById(R.id.dscTxtDesc);
        date = findViewById(R.id.dscTxtDate);
        username = findViewById(R.id.dscTxtUsername);
        profilePic = findViewById(R.id.dscImgVwPP);
        btnVoteUp = findViewById(R.id.dscImgVwVote);
        btnBackspace = findViewById(R.id.dscBackspace);
        btnNewAnswer = findViewById(R.id.dscNewAnswer);
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

        btnVoteUp.setOnClickListener(view -> {
            String newVote = apiService.voteUpDiscussion(discussionModel.getId());
            votes.setText(newVote);
            Toast.makeText(this, "Operation successful", Toast.LENGTH_SHORT).show();
            TimerUtil.disableVote(btnVoteUp, DiscussionActivity.class.getName());
            btnVoteUp.setEnabled(true);
        });

        lytGoToUser.setOnClickListener(view -> {
            String userIdA = apiService.getUserId(discussionModel.getUsername());
            UserInfoModel userModel = apiService.getUserInfo(userId);
            Intent intent = new Intent(view.getContext(), ViewProfileActivity.class);
            intent.putExtra("image", userModel.getImage());
            intent.putExtra("username", userModel.getUsername());
            intent.putExtra("accountType", userModel.getAccType());
            intent.putExtra("rep", userModel.getAccType());
            intent.putExtra("name", userModel.getFullName());
            intent.putExtra(USER_ID, userIdA);
            startActivity(intent);
        });

        btnBackspace.setOnClickListener(view -> {
            Intent intent = new Intent(DiscussionActivity.this, UserMenuActivity.class);
            intent.putExtra(USER_ID, userId);
            startActivity(intent);
        });

        btnNewAnswer.setOnClickListener(view -> {
            Intent intent = new Intent(DiscussionActivity.this, CreateAnswerActivity.class);
            intent.putExtra(USER_ID, userId);
            intent.putExtra("discussionId", discussionModel.getId());
            startActivity(intent);
        });
    }
}