package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.adapter.ChatAdapter;
import com.frontend.tutorcave.model.MessageOtherModel;
import com.frontend.tutorcave.model.MessageOwnModel;

import java.util.ArrayList;
import java.util.List;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        final Intent currentIntent = getIntent();
        final String userId = currentIntent.getStringExtra("userId");

        ImageView profilePic;
        AppCompatImageView btnBackspace;
        TextView name;
        TextView username;
        EditText messageInput;
        AppCompatImageView btnSend;
        RecyclerView recyclerView;
        List<Object> finestModelList;
        ChatAdapter listAdapter;

        profilePic = findViewById(R.id.chatImgPP);
        btnBackspace = findViewById(R.id.chatBackspace);
        name = findViewById(R.id.chatTxtName);
        username = findViewById(R.id.chatTxtUsername);
        messageInput = findViewById(R.id.chatTxtMsgInp);
        btnSend = findViewById(R.id.chatImgSend);
        recyclerView = findViewById(R.id.chatMsgListVw);

        profilePic.setImageResource(currentIntent.getIntExtra("image", R.drawable.test_profile_pic_1));
        name.setText(currentIntent.getStringExtra("name"));
        username.setText(getString(R.string.placeholder_username));


        // below model assignments are for test purposes
        finestModelList = new ArrayList<>();
        finestModelList.add(new MessageOwnModel("Hey Leon! How's it going?", "23/04/2001 12:10"));
        finestModelList.add(new MessageOtherModel("All fine, Freya. Had a hard week full of hassles, tho. But things got better now. What about you?", "23/04/2001 12:14"));
        finestModelList.add(new MessageOwnModel("Glad to hear things got better on your side. On the contrary, my week started with lots of responsibilities. I have so many tasks to complete.", "23/04/2001 12:16"));
        finestModelList.add(new MessageOtherModel("Sounds painful. Is there anything I could help?", "23/04/2001 12:19"));
        finestModelList.add(new MessageOwnModel("Not really. Unless you know molecular biology ))", "23/04/2001 12:25"));
        finestModelList.add(new MessageOtherModel("Nope ))", "23/04/2001 12:27"));
        finestModelList.add(new MessageOtherModel("Good luck to you Freya!", "23/04/2001 12:28"));
        finestModelList.add(new MessageOwnModel("Thanks", "23/04/2001 12:30"));
        finestModelList.add(new MessageOwnModel("Wish you best in your new (and better apparently) week )", "23/04/2001 12:31"));
        finestModelList.add(new MessageOtherModel("Thank you", "23/04/2001 12:32"));

        listAdapter = new ChatAdapter(finestModelList, ChatActivity.this);
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ChatActivity.this));

        btnBackspace.setOnClickListener(view -> {
            Intent intent = new Intent(ChatActivity.this, UserMenuActivity.class);
            intent.putExtra("userId", userId);
            startActivity(intent);
        });

        btnSend.setOnClickListener(view1 -> {
            Toast.makeText(ChatActivity.this, "Successfully send !!!", Toast.LENGTH_SHORT).show();
        });
    }
}