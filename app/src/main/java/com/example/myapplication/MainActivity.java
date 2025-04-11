package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

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

        DBHelper dbHelper = new DBHelper(this);
        EditText idEditText = findViewById(R.id.edtId);
        EditText nameEditText = findViewById(R.id.edtName);
        EditText addressEditText = findViewById(R.id.edtAddr);

        Button insertBtn = findViewById(R.id.btnInsert);
        Button selectBtn = findViewById(R.id.btnSelect);

        ListView listView = findViewById(R.id.listView);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(idEditText.getText().toString());
                String name = nameEditText.getText().toString();
                String address = addressEditText.getText().toString();

                dbHelper.insertData(id, name, address);
                Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
            }
        });

        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Integer> ids = new ArrayList<Integer>();
                ArrayList<String> names= new ArrayList<String>();
                ArrayList<String> addresses= new ArrayList<String>();

                Cursor cursor = dbHelper.selectData();
                while(cursor.moveToNext()){
                    ids.add(cursor.getInt(0));
                    names.add(cursor.getString(1));
                    addresses.add(cursor.getString(2));
                }

                ListAdapter adapter = new ListAdapter(MainActivity.this,R.layout.list, ids, names, addresses);
                listView.setAdapter(adapter);

            }
        });

    }
}