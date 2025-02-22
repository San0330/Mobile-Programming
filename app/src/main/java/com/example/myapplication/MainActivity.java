package com.example.myapplication;

import android.content.res.Resources;
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

        //get string arrays from resources
        Resources res = getResources();
        String[] planets = res.getStringArray(R.array.planets);

        for (int i = 0; i < planets.length; i++){
            Log.i("Mainactivity", planets[i]);
        }
    }
}