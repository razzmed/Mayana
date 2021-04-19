package com.example.mayana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextEmployerName;
    private EditText editTextEmployerPosition;
    private EditText editTextEmployerSalary;
    private Spinner spinnerPersonalDeduction;
    //private int monthSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextEmployerName = findViewById(R.id.editTextEmployerName);
        editTextEmployerPosition = findViewById(R.id.editTextEmployerPosition);
        editTextEmployerSalary = findViewById(R.id.editTextEmployerSalary);
        spinnerPersonalDeduction = findViewById(R.id.spinnerPersonalDeduction);

    }

    public void onClickCalculateSalary(View view) {
        String employerName = editTextEmployerName.getText().toString().trim();
        String employerPosition = editTextEmployerPosition.getText().toString().trim();
        String employerSalary = editTextEmployerSalary.getText().toString().trim();
        String personalDeduction = spinnerPersonalDeduction.getSelectedItem().toString();
        Note note = new Note(employerName, employerPosition, employerSalary, personalDeduction);
        MainActivity.notes.add(note);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}