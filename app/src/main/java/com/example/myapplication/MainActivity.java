package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EditText emailEditText = findViewById(R.id.emailEt);

        // method 1: on register button, need separate RegisterClickListener class
        Button myButton = findViewById(R.id.registerBtn);
        myButton.setOnClickListener(new RegisterClickListener());

        // method 2 : on login button
        Button loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                Toast.makeText(getApplicationContext(),"Login Button clicked, email: " + email, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class RegisterClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Register Button Clicked!", Toast.LENGTH_SHORT)
                    .show();
        }
    }

}
