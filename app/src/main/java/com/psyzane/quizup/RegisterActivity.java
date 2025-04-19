package com.psyzane.quizup;

import static com.psyzane.quizup.global.validPassword;
import static com.psyzane.quizup.global.validUsername;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ImageButton backButton = findViewById(R.id.back_btn);
        Button signUpButton = findViewById(R.id.sign_up_btn);

        EditText usernameBox = findViewById(R.id.username_box);
        EditText emailBox = findViewById(R.id.email_box);
        EditText passwordBox = findViewById(R.id.create_password_box);
        EditText con_passwordBox = findViewById(R.id.confirm_password_box);

        backButton.setOnClickListener(v -> {
            // TO-DO: Working
            finish();
        });

        signUpButton.setOnClickListener(view -> {
            String username = usernameBox.getText().toString();
            String email = emailBox.getText().toString();
            String password = passwordBox.getText().toString();
            String con_password = con_passwordBox.getText().toString();

            //TO-DO: Working (implement backend)
            //Username validation
            int usernameValid = validUsername(username);
            switch (usernameValid) {
                case 1:
                    usernameBox.setError("Please enter your username");
                    break;
                case 2:
                    usernameBox.setError("Username must be at least 3 characters");
                    break;
                case 3:
                    usernameBox.setError("Username must be at most 20 characters");
                    break;
                default:
                    usernameBox.setError("Error! Please try again");
                    break;
            }

            if (email.trim().isEmpty()) {
                emailBox.setError("Please enter your email");
                return;
            }

            //Password validation
            if (!validPassword(password)) {
                passwordBox.setError("Password must contain at least one letter, one number and one special character");
                return;
            }

            // TO-DO: Working
            Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
            startActivity(intent);

        });
    }
}