package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //- enable edge-to-edge display
        //- could be excluded
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        //- used to handle window insets in an Android app
        //- could be excluded
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //- Insets represent the areas of the screen occupied by system UI
        //- elements like the status bar, navigation bar, and gesture insets.

        Log.i("MainActivity", "Activity created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "Activity started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "Activity resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "Activity paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "Activity stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity", "Activity destroyed");
    }
}