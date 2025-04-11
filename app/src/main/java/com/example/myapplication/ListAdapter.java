package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<String>{
    Context context;
    int resource;
    ArrayList<Integer> ids;
    ArrayList<String> names;
    ArrayList<String> addresses;

    public ListAdapter(Context context, int resource, ArrayList<Integer> ids, ArrayList<String> names, ArrayList<String> addresses) {
        super(context, resource, names);
        this.context = context;
        this.resource = resource;
        this.ids = ids;
        this.names = names;
        this.addresses = addresses;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate layout if it's not already created
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, parent, false);
        }

        // Get the item at the current position
        String name = names.get(position).toString();
        String address  = addresses.get(position).toString();
        String id = ids.get(position).toString();

        // Find the TextView and set data
        TextView nameTV = convertView.findViewById(R.id.name);
        TextView addressTV = convertView.findViewById(R.id.address);
        TextView idTV = convertView.findViewById(R.id.id);

        if (nameTV != null) {
            nameTV.setText(name);
            addressTV.setText(address);
            idTV.setText(id);
        }

        return convertView;
    }
}