package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        setContentView(R.layout.linear);

        //- used to handle window insets in an Android app
        //- could be excluded
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //- Insets represent the areas of the screen occupied by system UI
        //- elements like the status bar, navigation bar, and gesture insets.

        Button addButton = findViewById(R.id.buttonAdd);
        Button multiplyButton = findViewById(R.id.buttonMultiply);
        EditText firstNumberEditText = findViewById(R.id.firstNumET);
        EditText secondNumberEditText = findViewById(R.id.secondNumET);
        TextView resultTv = findViewById(R.id.resultTV);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstNumStr = firstNumberEditText.getText().toString();
                Double firstNum = Double.parseDouble(firstNumStr);

                String secondNumStr = secondNumberEditText.getText().toString();
                Double secondNum = Double.parseDouble(secondNumStr);

                Double result = firstNum + secondNum;

                resultTv.setText(result.toString());
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstNumStr = firstNumberEditText.getText().toString();
                Double firstNum = Double.parseDouble(firstNumStr);

                String secondNumStr = secondNumberEditText.getText().toString();
                Double secondNum = Double.parseDouble(secondNumStr);

                Double result = firstNum * secondNum;

                resultTv.setText(result.toString());
            }
        });
    }
}