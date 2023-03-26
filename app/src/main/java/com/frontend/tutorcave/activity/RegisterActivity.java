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

        // TODO: set anim

        txtUsername = findViewById(R.id.editTextUsernameRegister);
        txtPassword = findViewById(R.id.editTextPasswordRegister);
        txtEmail = findViewById(R.id.editTextEmailRegister);
        txtName = findViewById(R.id.editTextNameRegister);
        txtSurname = findViewById(R.id.editTextSurnameRegister);
        btnForward = findViewById(R.id.btnRegister);

        btnForward.setOnClickListener(view -> {
            if (txtUsername.getText().toString().isEmpty())
                Toast.makeText(RegisterActivity.this, R.string.invalid_username, Toast.LENGTH_SHORT).show();
            if (txtPassword.getText().toString().isEmpty())
                Toast.makeText(RegisterActivity.this, R.string.invalid_password, Toast.LENGTH_SHORT).show();
            if (txtEmail.getText().toString().isEmpty())
                Toast.makeText(RegisterActivity.this, R.string.invalid_email, Toast.LENGTH_SHORT).show();

            if (!txtUsername.getText().toString().isEmpty()
                    && !txtPassword.getText().toString().isEmpty()
                    && !txtEmail.getText().toString().isEmpty()) {

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

        if (password.getText().toString().length() >= 6
                && password.getText().toString().length() <= 22)
            payload.setPassword(password.getText().toString());
        else Toast.makeText(RegisterActivity.this, R.string.invalid_password_length, Toast.LENGTH_SHORT).show();

        if (!name.getText().toString().isEmpty())
            payload.setFirstName(name.getText().toString());
        if (!surname.getText().toString().isEmpty())
            payload.setLastName(surname.getText().toString());

        return payload;
    }
}