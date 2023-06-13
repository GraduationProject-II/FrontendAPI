package com.frontend.tutorcave.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.frontend.tutorcave.R;
import com.frontend.tutorcave.model.RegisterModel;

//* Copyright (c) 2022, Samet Vural Üstün, All rights reserved.
/** @author Samet Vural Üstün */

public class RegisterActivity extends AppCompatActivity {

    private RegisterModel registerPayload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText txtUsername;
        EditText txtPassword;
        EditText txtEmail;
        EditText txtName;
        EditText txtSurname;
        EditText btnForward;

        txtUsername = findViewById(R.id.editTextUsernameRegister);
        txtPassword = findViewById(R.id.editTextPasswordRegister);
        txtEmail = findViewById(R.id.editTextEmailRegister);
        txtName = findViewById(R.id.editTextNameRegister);
        txtSurname = findViewById(R.id.editTextSurnameRegister);
        btnForward = findViewById(R.id.btnRegister);

        btnForward.setOnClickListener(view -> {
            if (isTextEmpty(txtUsername.getText().toString()))
                invalidInput(R.string.invalid_username);
            if (isTextEmpty(txtPassword.getText().toString()))
                invalidInput(R.string.invalid_password);
            if (isTextEmpty(txtEmail.getText().toString()))
                invalidInput(R.string.invalid_email);

            if (isCredentials(
                    txtUsername.getText().toString(),
                    txtPassword.getText().toString(),
                    txtEmail.getText().toString()
                )
            ) {
                registerPayload = assignPayloadAttr(
                        txtUsername,
                        txtPassword,
                        txtEmail,
                        txtName,
                        txtSurname
                );
                // TODO: redirect payload to backend api
                // TODO: new intent for main menu
            }
        });
    }

    private RegisterModel assignPayloadAttr(
            EditText username,
            EditText password,
            EditText email,
            EditText name,
            EditText surname
    ) {
        RegisterModel payload = new RegisterModel();
        payload.setUsername(username.getText().toString());
        payload.setEmail(email.getText().toString());

        if (isPasswordLength(password.getText().toString()))
            payload.setPassword(password.getText().toString());
        else invalidInput(R.string.invalid_password_length);

        if (!isTextEmpty(name.getText().toString()))
            payload.setFirstName(name.getText().toString());

        if (!isTextEmpty(surname.getText().toString()))
            payload.setLastName(surname.getText().toString());

        return payload;
    }

    private boolean isTextEmpty(String text) {
        return text.isEmpty();
    }

    private void invalidInput(int warning) {
        Toast.makeText(RegisterActivity.this, warning, Toast.LENGTH_SHORT).show();
    }

    private boolean isCredentials(String username, String password, String email) {
        return !username.isEmpty() && !password.isEmpty() && !email.isEmpty();
    }

    private boolean isPasswordLength(String password) {
        return password.length() >= 6 && password.length() <= 22;
    }
}