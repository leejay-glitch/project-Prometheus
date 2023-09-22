package com.example.prometheus;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    private Button loginButton;
    private Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Initialize buttons
        loginButton = findViewById(R.id.button);
        signInButton = findViewById(R.id.button2);

        // Set a click listener for the "Login" button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add your code here to navigate to the login page
                startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
            }
        });

        // Set a click listener for the "Sign In" button
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add your code here to navigate to the sign-in page
                startActivity(new Intent(WelcomeActivity.this, SignupActivity.class));
            }
        });
    }
}
