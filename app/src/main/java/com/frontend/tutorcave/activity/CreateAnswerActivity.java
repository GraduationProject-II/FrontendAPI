package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.EditText;
import android.widget.Toast;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.service.ApiService;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class CreateAnswerActivity extends AppCompatActivity {

    private final ApiService apiService = new ApiService();
    private static final String USER_ID = "userId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_answer);

        final Intent currentIntent = getIntent();
        final String userId = currentIntent.getStringExtra(USER_ID);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        EditText txtContent;
        CardView btnBackspace;
        CardView btnSave;

        txtContent = findViewById(R.id.answerTxtDescNew);
        btnBackspace = findViewById(R.id.crtAnswerCrdVwBackspace);
        btnSave = findViewById(R.id.crtAnswerCrdVwSave);

        btnSave.setOnClickListener(view -> {
            if (txtContent.getText() != null) {
                String content = txtContent.getText().toString();
                String discussionId = currentIntent.getStringExtra("discussionId");
                apiCall(userId, discussionId, content);

                Intent intent = new Intent(CreateAnswerActivity.this, UserMenuActivity.class);
                intent.putExtra(USER_ID, userId);
                startActivity(intent);
            }
            else
                Toast.makeText(this, "Invalid arguments set!", Toast.LENGTH_SHORT).show();
        });

        btnBackspace.setOnClickListener(view -> {
            Intent intent = new Intent(CreateAnswerActivity.this, UserMenuActivity.class);
            intent.putExtra(USER_ID, userId);
            startActivity(intent);
        });
    }

    private void apiCall(String userId, String discussionId, String payload) {
        int status = apiService.newAnswer(userId, discussionId, payload);
        if (status == 0)
            Toast.makeText(this, "Operation failed!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Operation successful", Toast.LENGTH_SHORT).show();
    }
}