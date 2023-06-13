package com.frontend.tutorcave.activity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.service.ApiService;
import com.frontend.tutorcave.service.SettingsService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class SettingsActivity extends AppCompatActivity {

    private ImageView profileImage;
    private final ApiService apiService = new ApiService();
    private int mCounter = 0;
    private final Intent currentIntent = getIntent();
    private final String userId = currentIntent.getStringExtra("userId");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // declarations
        SettingsService settingsService = new SettingsService();
        AppCompatImageView btnBackspace;
        AppCompatButton btnEditPP;
        AppCompatButton btnSaveSettings;
        RelativeLayout btnNavToSecurity;
        RelativeLayout btnNavToStats;
        RelativeLayout btnNavToApplyTutor;
        RelativeLayout btnLogout;

        // assignments
        btnBackspace = findViewById(R.id.settingsImgVwBackspace);
        btnEditPP = findViewById(R.id.settingsBtnEditPP);
        profileImage = findViewById(R.id.settingsImgVwPP);
        btnSaveSettings = findViewById(R.id.settingsBtnSave);
        btnNavToSecurity = findViewById(R.id.settingsOptionRltLytNavSec);
        btnNavToStats = findViewById(R.id.settingsOptionRltLytNavStats);
        btnNavToApplyTutor = findViewById(R.id.settingsOptionRltLytNavApplyTutor);
        btnLogout = findViewById(R.id.settingsOptionRltLytLogout);

        settingsService.redirect(btnBackspace, SettingsActivity.this, ProfileActivity.class, userId);
        settingsService.redirect(btnNavToSecurity, SettingsActivity.this, SettingsSecPrivActivity.class, userId);
        settingsService.redirect(btnNavToStats, SettingsActivity.this, SettingsStatsActivity.class, userId);

        // TODO: refactor
        settingsService.redirect(btnNavToApplyTutor, SettingsActivity.this, "Navigate to About Us");
        settingsService.redirect(btnLogout, SettingsActivity.this, "Logout");

        btnEditPP.setOnClickListener(view -> {
            chooseImage();
            mCounter++;
        });

        btnSaveSettings.setOnClickListener(view -> {
            if (mCounter == 0)
                Toast.makeText(this, "No changes have been made!", Toast.LENGTH_SHORT).show();
            else {
                BitmapDrawable bitmapDrawable = ((BitmapDrawable) profileImage.getDrawable());
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] imageData = stream.toByteArray();
                bitmap.recycle();
                apiService.saveImage(userId, imageData, setFileName());
            }
        });
    }

    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        launchActivity.launch(intent);
    }

    private String setFileName() {
        return "image_" + UUID.randomUUID().toString();
    }

    ActivityResultLauncher<Intent> launchActivity = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null && data.getData() != null) {
                        Uri imageUri = data.getData();
                        Bitmap imageBitmap;
                        try {
                            imageBitmap = MediaStore.Images.Media.getBitmap(
                                    this.getContentResolver(),
                                    imageUri);
                        } catch (IOException exception) {
                            throw new RuntimeException(exception.getMessage());
                        }
                        profileImage.setImageBitmap(imageBitmap);
                    }
                }
            }
    );
}