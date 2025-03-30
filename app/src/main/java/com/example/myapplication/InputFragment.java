package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InputFragment extends Fragment {
    EditText num1, num2;
    RadioGroup operations;
    Button btnCalculate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        num1 = view.findViewById(R.id.editNum1);
        num2 = view.findViewById(R.id.editNum2);
        operations = view.findViewById(R.id.radioGroupOperations);
        btnCalculate = view.findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(v -> {
            double number1 = Double.parseDouble(num1.getText().toString());
            double number2 = Double.parseDouble(num2.getText().toString());
            double result = 0;
            int selectedOperation = operations.getCheckedRadioButtonId();

            if (selectedOperation == R.id.radioAdd) {
                result = number1 + number2;
            } else if (selectedOperation == R.id.radioSubtract) {
                result = number1 - number2;
            } else if (selectedOperation == R.id.radioMultiply) {
                result = number1 * number2;
            } else if (selectedOperation == R.id.radioDivide) {
                if (number2 != 0) {
                    result = number1 / number2;
                }
            }

            // Pass the result to ResultFragment
            ResultFragment resultFragment = new ResultFragment();
            Bundle bundle = new Bundle();
            bundle.putDouble("result", result);
            resultFragment.setArguments(bundle);

            ((MainActivity) getActivity()).loadFragment(resultFragment, true);
        });

        return view;
    }
}