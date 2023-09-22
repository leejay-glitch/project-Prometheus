package com.example.prometheus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    private EditText nameEditText, emailEditText, passwordEditText, IDEditText, numberEditText;
    private Button signupButton, goToLoginButton;

    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("users"); // Adjust the reference as needed

        nameEditText = findViewById(R.id.editTextname);
        emailEditText = findViewById(R.id.editTextEmailAddress);
        IDEditText = findViewById(R.id.editTextNumber);
        numberEditText = findViewById(R.id.editTextPhone);
        passwordEditText = findViewById(R.id.editTextPassword);

        signupButton = findViewById(R.id.buttonSignup);
//        goToLoginButton = findViewById(R.id.buttonGoToLogin);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = nameEditText.getText().toString();
                final String email = emailEditText.getText().toString();
                final String IdNo = IDEditText.getText().toString();
                final String phoneNo = numberEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Signup successful, proceed to main activity
                                    User user = new User(name, email, IdNo, phoneNo);
                                    saveUserToDatabase(user);

                                    startActivity(new Intent(SignupActivity.this, MainActivity.class));
                                    finish();
                                } else {
                                    // Signup failed, show an error message
                                    Toast.makeText(SignupActivity.this, "Signup failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        goToLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    // This method can be used to save user information to the database
    private void saveUserToDatabase(User user) {
        String userId = mAuth.getCurrentUser().getUid(); // Get the current user's UID
        databaseReference.child(userId).setValue(user); // Save the user object to the database
    }
}
