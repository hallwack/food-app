package com.pam.foodapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        Button loginButton = findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        Button registerButton = findViewById(R.id.button_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){
            currentUser.reload();
        }
    }

    public void login() {
        TextView usernameTextView = findViewById(R.id.username_form);
        TextView passwordTextView = findViewById(R.id.password_form);

        String username = usernameTextView.getText().toString();
        String password = passwordTextView.getText().toString();

        Log.d("print", "Username : " + username);
        Log.d("print", "Password : " + password);

        mAuth.signInWithEmailAndPassword(username, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                        MainActivity.this.finish();
                    } else {
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        Toast.makeText(MainActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
            });

//        if (username.equals("test") && password.equals("123456")) {
//            Log.d("success", "Login berhasil!");
//
//            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//            startActivity(intent);
//            this.finish();
//        } else {
//            Log.d("failed", "Login gagal!");
//            Toast warnToast = Toast.makeText(getApplicationContext(), "Username atau Password Salah!", Toast.LENGTH_SHORT);
//            warnToast.show();
//        }
    }
}