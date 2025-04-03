package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class MyListAdapter extends ArrayAdapter<String>{
    Context context;
    int resource;
    String[] titles;
    String[] descriptions;
    int[] images;

    public MyListAdapter(Context context, int resource, String[] titles, String[] descriptions, int[] images) {
        super(context, resource, titles);
        this.context = context;
        this.resource = resource;
        this.titles = titles;
        this.descriptions = descriptions;
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate layout if it's not already created
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, parent, false);
        }

        // Get the item at the current position
        String title = titles[position];
        String description  = descriptions[position];
        int image = images[position];


        // Find the TextView and set data
        TextView titleTV = convertView.findViewById(R.id.name);
        TextView descTV = convertView.findViewById(R.id.desc);
        ImageView imageView = convertView.findViewById(R.id.image);

        if (titleTV != null) {
            titleTV.setText(title);
            descTV.setText(description);
            imageView.setImageResource(image);
        }

        return convertView;
    }
}