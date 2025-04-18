package com.psyzane.quizup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Change activity to home
        TextView textView = findViewById(R.id.guest_btn);
        textView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        });

        //Login Page
        Button loginButton = findViewById(R.id.login_btn);
        loginButton.setOnClickListener(v -> {
            // TO-DO: Working
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        //Register Page
        Button registerButton = findViewById(R.id.register_btn);
        registerButton.setOnClickListener(v -> {
            //TO-DO: Working
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}