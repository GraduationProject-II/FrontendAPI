package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.EditText;
import android.widget.Toast;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.model.NewDiscussionPayload;
import com.frontend.tutorcave.service.ApiService;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class CreateDiscussionActivity extends AppCompatActivity {

    private final ApiService apiService = new ApiService();
    private static final String OP_SUCCESSFUL = "Operation successful";
    private static final String OP_FAILED = "Operation failed!";
    private static final String USER_ID = "userId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_discussion);

        final Intent currentIntent = getIntent();
        final String userId = currentIntent.getStringExtra(USER_ID);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        EditText txtTitle;
        EditText txtDesc;
        CardView btnBackspace;
        CardView btnSave;

        txtTitle = findViewById(R.id.dscTxtTitleNew);
        txtDesc = findViewById(R.id.dscTxtDescNew);
        btnBackspace = findViewById(R.id.crtDiscCrdVwBackspace);
        btnSave = findViewById(R.id.crtDiscCrdVwSave);

        btnBackspace.setOnClickListener(view -> {
            Intent intent = new Intent(CreateDiscussionActivity.this, ProfileActivity.class);
            intent.putExtra(USER_ID, userId);
            startActivity(intent);
        });

        btnSave.setOnClickListener(view -> {
            NewDiscussionPayload payload = new NewDiscussionPayload();
            if (txtTitle.getText() != null && txtDesc.getText() != null) {
                payload.setDiscussionTitle(txtTitle.getText().toString());
                payload.setDiscussionDescription(txtDesc.getText().toString());
                apiCall(userId, payload);

                Intent intent = new Intent(CreateDiscussionActivity.this, ProfileActivity.class);
                intent.putExtra(USER_ID, userId);
                startActivity(intent);
            }
            else
                Toast.makeText(this, "Invalid arguments set!", Toast.LENGTH_SHORT).show();
        });
    }

    private void apiCall(String userId, NewDiscussionPayload payload) {
        int status = apiService.newDiscussion(userId, payload);
        if (status == 0)
            Toast.makeText(this, OP_FAILED, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, OP_SUCCESSFUL, Toast.LENGTH_SHORT).show();
    }
}