package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        TextView txtResult = view.findViewById(R.id.txtResult);
        Button btnBack = view.findViewById(R.id.btnBack);

        // Retrieve the result from the arguments
        Bundle bundle = getArguments();
        if (bundle != null) {
            double result = bundle.getDouble("result", 0);
            txtResult.setText("Result: " + result);
        }

        btnBack.setOnClickListener(v -> {
            ((MainActivity) getActivity()).loadFragment(new InputFragment(), false);
        });

        return view;
    }
}