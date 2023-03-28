package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.model.LoginModel;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class LoginActivity extends AppCompatActivity {

    private LoginModel loginPayload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editTextUsername;
        EditText editTextPassword;
        EditText btnLogin;

        // TODO: set anim

        editTextUsername = findViewById(R.id.editTextUsernameLogin);
        editTextPassword = findViewById(R.id.editTextPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(view -> {
            if (isCredentials(
                    editTextUsername.getText().toString(),
                    editTextPassword.getText().toString()
            ))
                Toast.makeText(LoginActivity.this, R.string.invalid_credentials, Toast.LENGTH_SHORT).show();
            else {
                setPayload(editTextUsername.getText().toString(), editTextPassword.getText().toString());
                //TODO: send payload to backend api
                //TODO: new intent for main menu
            }
        });
    }

    private boolean isCredentials(String username, String password) {
        return username.isEmpty() || password.isEmpty();
    }

    private void setPayload(String username, String password) {
        loginPayload.setUsername(username);
        loginPayload.setPassword(password);
    }
}