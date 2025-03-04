package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_layout);

        // receiving data
        Intent i = getIntent();
        int id = i.getIntExtra("id",0);
        String name= i.getStringExtra("name");
        String address = i.getStringExtra("address");

        // display received data in textview
        TextView tv1 = findViewById(R.id.tv1);
        tv1.setText("Id = " + id + "\nName = " + name + "\nAddress = " + address);
    }
}
