package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.EditText;
import android.widget.Toast;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.model.LoginModel;
import com.frontend.tutorcave.service.ApiService;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class LoginActivity extends AppCompatActivity {

    private final ApiService apiService = new ApiService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editTextUsername;
        EditText editTextPassword;
        EditText btnLogin;

        editTextUsername = findViewById(R.id.editTextUsernameLogin);
        editTextPassword = findViewById(R.id.editTextPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        btnLogin.setOnClickListener(view -> {
            if (isCredentials(
                    editTextUsername.getText().toString(),
                    editTextPassword.getText().toString()
            ))
                Toast.makeText(LoginActivity.this, R.string.invalid_credentials, Toast.LENGTH_SHORT).show();
            else {
                LoginModel loginPayload = setPayload(editTextUsername.getText().toString(), editTextPassword.getText().toString());
                String userId = apiService.login(loginPayload);

                Intent intent = new Intent(LoginActivity.this, UserMenuActivity.class);
                intent.putExtra("userId", userId);
                startActivity(intent);
            }
        });
    }

    private boolean isCredentials(String username, String password) {
        return username.isEmpty() || password.isEmpty();
    }

    private LoginModel setPayload(String username, String password) {
        LoginModel payload = new LoginModel();
        payload.setUsername(username);
        payload.setPassword(password);
        return payload;
    }
}