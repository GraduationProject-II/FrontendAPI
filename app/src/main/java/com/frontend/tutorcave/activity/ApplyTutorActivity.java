package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.service.ApiService;

public class ApplyTutorActivity extends AppCompatActivity {

    private final ApiService apiService = new ApiService();
    private static final String USER_ID = "userId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_tutor);

        final Intent currentIntent = getIntent();
        final String userId = currentIntent.getStringExtra(USER_ID);

        AppCompatImageView btnBackspace;
        RelativeLayout btnApply;

        btnBackspace = findViewById(R.id.applyTutorBck);
        btnApply = findViewById(R.id.applyTutorRltLytApply);

        btnBackspace.setOnClickListener(view -> {
            Intent intent = new Intent(ApplyTutorActivity.this, SettingsActivity.class);
            intent.putExtra(USER_ID, userId);
            startActivity(intent);
        });

        btnApply.setOnClickListener(view -> {
            int resultCode = apiService.applyTutor(userId);
            if (resultCode == 1) {
                Toast.makeText(this, "Successfully applied", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ApplyTutorActivity.this, SettingsActivity.class);
                intent.putExtra(USER_ID, userId);
                startActivity(intent);
            }
            else
                Toast.makeText(this, "Requirements are not met!", Toast.LENGTH_SHORT).show();
        });
    }
}