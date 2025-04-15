package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<Student>{
    Context context;
    int resource;
   ArrayList<Student> studentList;

    public MyListAdapter(Context context, int resource, ArrayList<Student> studentList) {
        super(context, resource, studentList);
        this.context = context;
        this.resource = resource;
        this.studentList = studentList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate layout if it's not already created
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, parent, false);
        }

        // Get the item at the current position
        Student student = studentList.get(position);

        // Find the TextView and set data
        TextView idTV = convertView.findViewById(R.id.idTV);
        TextView nameTV = convertView.findViewById(R.id.nameTV);

        if (student != null) {
            idTV.setText(String.valueOf(student.getSid()));
            nameTV.setText(student.getName());
        }

        return convertView;
    }
}