package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

// here we show the response from server in Listview
// we use model class (Student with attribute sid and name)
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

        volleyRequestShowData();

        // the below lines tests the code for listview without volley request, comment above function and uncomment below lines
//        ArrayList<Student> studentList = new ArrayList<>();
//        studentList.add(new Student(1,"Santosh"));
//        studentList.add(new Student(2,"Someone"));
//
//        ListView listView = findViewById(R.id.lv);
//        MyListAdapter adapter = new MyListAdapter(this, R.layout.list_item, studentList);
//        listView.setAdapter(adapter);
    }

    private void volleyRequestShowData(){
        // URL to send the GET request to
        String url = "http://192.168.1.108:8000/getData.php";

        // Instantiate the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);

        // Create a GET request
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // decode and make model class out of response data
                        ArrayList<Student> studentList = decodeJSON(response);

                        // show the data in listview
                        ListView listView = findViewById(R.id.lv);
                        MyListAdapter adapter = new MyListAdapter(MainActivity.this, R.layout.list_item, studentList);
                        listView.setAdapter(adapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        // Add the request to the RequestQueue
        queue.add(stringRequest);
    }

    private ArrayList<Student> decodeJSON(String response){
        ArrayList<Student> studentList = new ArrayList<>();
        try{
            JSONObject result = new JSONObject(response);
            JSONArray array = result.getJSONArray("data");
            for(int i = 0; i < array.length(); i++){
                JSONObject studentObject = array.getJSONObject(i);
                int sid = studentObject.getInt("sid");
                String name= studentObject.getString("name");
                Student student = new Student(sid,name);
                studentList.add(student);
            }
        }catch (Exception ex){
            Log.d("exception", ex.toString());
        }
        return studentList;
    }
}