package com.pam.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    public void login() {
        TextView usernameTextView = findViewById(R.id.username_form);
        TextView passwordTextView = findViewById(R.id.password_form);

        String username = usernameTextView.getText().toString();
        String password = passwordTextView.getText().toString();

        Log.d("print", "Username : " + username);
        Log.d("print", "Password : " + password);

        if (username.equals("test") && password.equals("123456")) {
            Log.d("success", "Login berhasil!");

            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            this.finish();
        } else {
            Log.d("failed", "Login gagal!");
            Toast warnToast = Toast.makeText(getApplicationContext(), "Username atau Password Salah!", Toast.LENGTH_SHORT);
            warnToast.show();
        }
    }
}