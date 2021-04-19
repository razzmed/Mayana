package com.example.mayana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextEmployerName;
    private EditText editTextEmployerPosition;
    private EditText editTextEmployerSalary;
    private Spinner spinnerPersonalDeduction;
    private int monthSalary;
    private String selected;
    private String totalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextEmployerName = findViewById(R.id.editTextEmployerName);
        editTextEmployerPosition = findViewById(R.id.editTextEmployerPosition);
        editTextEmployerSalary = findViewById(R.id.editTextEmployerSalary);
        spinnerPersonalDeduction = findViewById(R.id.spinnerPersonalDeduction);
        spinnerPersonalDeduction.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected = spinnerPersonalDeduction.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

    public void onClickCalculateSalary(View view) {
        String employerName = editTextEmployerName.getText().toString().trim();
        String employerPosition = editTextEmployerPosition.getText().toString().trim();
        String employerSalary = editTextEmployerSalary.getText().toString().trim();
        String personalDeduction = spinnerPersonalDeduction.getSelectedItem().toString();
        monthSalary = Integer.parseInt(employerSalary);
        double taxSalaryMain = (monthSalary - (monthSalary * 0.1) - 650) * 0.1;
        double resultMain = monthSalary - (monthSalary * 0.1) - taxSalaryMain;

        double taxSalaryComb = (monthSalary - (monthSalary * 0.1)) * 0.1;
        double resultComb = monthSalary - (monthSalary * 0.1) - taxSalaryComb;


        if (selected.equals("Основной")) {
            totalResult = Double.toString(resultMain);
        } else {
            totalResult = Double.toString(resultComb);
        }

                Note note = new Note(employerName, employerPosition, employerSalary, personalDeduction, totalResult);
        MainActivity.notes.add(note);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}