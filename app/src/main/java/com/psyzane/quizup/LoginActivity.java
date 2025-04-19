package com.psyzane.quizup;

import static com.psyzane.quizup.global.validPassword;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageButton backButton = findViewById(R.id.back_btn);
        Button loginButton = findViewById(R.id.sign_up_btn);
        EditText emailBox = findViewById(R.id.email_box);
        EditText passwordBox = findViewById(R.id.create_password_box);

        backButton.setOnClickListener(v -> {
            // TO-DO: Working
            finish();
        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }

        });

        loginButton.setOnClickListener(v -> {

            // TO-DO: Working
            String email = emailBox.getText().toString();
            String password = passwordBox.getText().toString();

            //TO-DO: Working (implement backend)
            //Email validation
            if (email.trim().isEmpty()) {
                emailBox.setError("Please enter your email");
                return;
            }

            //Password validation
            if (password.trim().isEmpty()) {
                passwordBox.setError("Please enter your Password");
                return;
            }
            if (!validPassword(password)) {
                passwordBox.setError("Password must contain at least one letter, one number and one special character");
                return;
            }

            // TO-DO: Working
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }


}