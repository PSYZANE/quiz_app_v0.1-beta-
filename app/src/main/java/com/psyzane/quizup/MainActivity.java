package com.psyzane.quizup;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toast exitToast;

    //Back function variables
    private boolean doubleBackToExitPressedOnce = false;
    private static final long DOUBLE_BACK_PRESS_DELAY = 2000;//in ms

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

        //Exit by back button
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (doubleBackToExitPressedOnce) {
                    finishAffinity(); //exit the app
                    return;
                }
                doubleBackToExitPressedOnce = true;
                exitToast = Toast.makeText(MainActivity.this, "Please press BACK again to exit",Toast.LENGTH_SHORT);
                exitToast.show();
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                        }
                    }, DOUBLE_BACK_PRESS_DELAY);
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(exitToast != null){
            exitToast.cancel();
        }
    }
}