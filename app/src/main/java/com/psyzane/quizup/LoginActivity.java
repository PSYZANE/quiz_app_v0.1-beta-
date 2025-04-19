package com.psyzane.quizup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageButton backButton = findViewById(R.id.back_btn);
        Button loginButton = findViewById(R.id.login_btn);
        EditText emailBox = findViewById(R.id.email_box);
        EditText passwordBox = findViewById(R.id.password_box);

        backButton.setOnClickListener(v -> {
            // TO-DO: Working
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
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
            if (!hasAllTypesOfCharacters(password)) {
                passwordBox.setError("Password must contain at least one letter, one number and one special character");
                return;
            }

            // TO-DO: Working
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }

    //Check whether the password contain a alphabet, number and special character
    private static boolean hasAllTypesOfCharacters(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false; // Or throw an exception, depending on your requirements
        }

        // Define patterns for each type of character
        Pattern alphabetPattern = Pattern.compile("[a-zA-Z]"); // Letters (a-z, A-Z)
        Pattern numberPattern = Pattern.compile("[0-9]");       // Numbers (0-9)
        Pattern specialCharPattern = Pattern.compile("[^a-zA-Z0-9]"); // Anything not a letter or number

        // Check for matches
        Matcher alphabetMatcher = alphabetPattern.matcher(str);
        Matcher numberMatcher = numberPattern.matcher(str);
        Matcher specialCharMatcher = specialCharPattern.matcher(str);

        // Return true only if all patterns match at least once
        return alphabetMatcher.find() && numberMatcher.find() && specialCharMatcher.find();
    }
}