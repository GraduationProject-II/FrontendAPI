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

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class DiscussionActivity extends AppCompatActivity {

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
        List<DiscussionAnswerModel> discussionModels;
        Intent currentIntent = getIntent();

        votes = findViewById(R.id.dscTxtVote);
        title = findViewById(R.id.dscTxtTitle);
        desc = findViewById(R.id.dscTxtDesc);
        date = findViewById(R.id.dscTxtDate);
        username = findViewById(R.id.dscTxtUsername);
        profilePic = findViewById(R.id.dscImgVwPP);
        recyclerVwAnswers = findViewById(R.id.dscRcyVwAnswers);

        // TODO: retrieve actual data from backend api, delete below test assignments afterwards
        votes.setText(currentIntent.getStringExtra("vote"));
        title.setText(currentIntent.getStringExtra("title"));
        date.setText(currentIntent.getStringExtra("date"));
        username.setText(currentIntent.getStringExtra("username"));
        desc.setText(R.string.placeholder_desc);
        profilePic.setImageResource(R.drawable.test_profile_pic_1);

        // TODO: below model assignments are for test purposes
        // retrieve actual data from backend api and delete below piece of code
        discussionModels = new ArrayList<>();
        discussionModels.add(new DiscussionAnswerModel(
                1,
                "Title #1",
                "henvrıllısıhhılserılsnvılsrvılrvırhsılglıgıgnls",
                "username #1",
                R.drawable.test_profile_pic_1,
                "29/10/1923",
                "29"
        ));
        discussionModels.add(new DiscussionAnswerModel(
                2,
                "Title #2",
                "hensfgsdgsggsdgsgsgsgsgsdgsgsdgsgsgthgtdgdsfgfdvrıllısıhhılserılsnvılsrvılrvırhsılglıgıgnls",
                "username #2",
                R.drawable.test_profile_pic_2,
                "29/10/1933",
                "4872"
        ));
        discussionModels.add(new DiscussionAnswerModel(
                3,
                "Title #3",
                "henvrıllıllsvılrvırhsılglıgıgnls",
                "username #3",
                R.drawable.test_profile_pic_3,
                "29/10/1943",
                "7"
        ));
        discussionModels.add(new DiscussionAnswerModel(
                4,
                "Title #4",
                "henvrhyjfgfbdfşogogşfgşodfgjşodfjgoşdfhjdşofhjşdofhjşdofhşodfhjşodhşofdhjdoşhjoşdfhşodfhşdhdıllısıhhılserılsnvılsrvılrvırhsılglıgıgnls",
                "username #4",
                R.drawable.test_profile_pic_4,
                "29/10/1953",
                "29890"
        ));
        discussionModels.add(new DiscussionAnswerModel(
                5,
                "Title #5",
                "henvrıllısıhhılsrererılsnvılsrvılrvırhsılglıgıgnls",
                "username #5",
                R.drawable.test_profile_pic_1,
                "29/10/1963",
                "102"
        ));

        listAdapter = new DiscussionAnswerAdapter(discussionModels, DiscussionActivity.this);
        recyclerVwAnswers.setAdapter(listAdapter);
        recyclerVwAnswers.setLayoutManager(new LinearLayoutManager(DiscussionActivity.this));

        username.setOnClickListener(view -> {
            // TODO: test purposes, delete afterwards and impl logic
            Toast.makeText(this, R.string.username, Toast.LENGTH_SHORT).show();
        });

    }
}