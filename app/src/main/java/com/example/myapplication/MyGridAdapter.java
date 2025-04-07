package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyGridAdapter extends ArrayAdapter<String>{
    Context context;
    int resource;
    String[] titles;
    String[] descriptions;
    int[] images;

    public MyGridAdapter(Context context, String[] titles, String[] descriptions, int[] images) {
        super(context, R.layout.item, titles);
        this.context = context;
        this.titles = titles;
        this.descriptions = descriptions;
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate layout if it's not already created

        LayoutInflater inflater = LayoutInflater.from(context);
        View rowView = inflater.inflate(R.layout.item, null, true);

        // Get the item at the current position
        String title = titles[position];
        String description  = descriptions[position];
        int image = images[position];

        // Find the TextView and set data
        TextView titleTV = rowView.findViewById(R.id.name);
        TextView descTV = rowView.findViewById(R.id.desc);
        ImageView imageView = rowView.findViewById(R.id.image);

        if (titleTV != null) {
            titleTV.setText(title);
            descTV.setText(description);
            imageView.setImageResource(image);
        }

        return rowView;
    }
}