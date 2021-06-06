package com.example.mayana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextEmployerName;
    private EditText editTextEmployerPosition;
    private EditText editTextEmployerSalary;
    private EditText editTextBonus;
    private Spinner spinnerPersonalDeduction;
    private int monthSalary;
    private int bonus;
    private String selected;
    private String totalResult;

    private NotesDatabase database;

    private Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        database = App.getInstance().getDatabase();

        note = (Note) getIntent().getSerializableExtra("note");


        editTextEmployerName = findViewById(R.id.editTextEmployerName);
        editTextEmployerPosition = findViewById(R.id.editTextEmployerPosition);
        editTextEmployerSalary = findViewById(R.id.editTextEmployerSalary);
        editTextBonus = findViewById(R.id.editTextBonus);
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

        if (note != null) {
            editTextEmployerName.setText(note.getEmployerName());
            editTextEmployerPosition.setText(note.getEmployerPosition());
            editTextEmployerSalary.setText(note.getMonthSalary());
            editTextBonus.setText(note.getBonus());
        }
    }

    public void onClickCalculateSalary(View view) {
        String employerName = editTextEmployerName.getText().toString().trim();
        String employerPosition = editTextEmployerPosition.getText().toString().trim();
        String employerSalary = editTextEmployerSalary.getText().toString().trim();
        String employerBonus = editTextBonus.getText().toString().trim();
        if (isFilled(employerName, employerPosition, employerSalary, employerBonus)) {
            finish();
            String personalDeduction = spinnerPersonalDeduction.getSelectedItem().toString();
            monthSalary = Integer.parseInt(employerSalary);
            bonus = Integer.parseInt(employerBonus);
            double taxSalaryMain = (((monthSalary + bonus) - (monthSalary + bonus) * 0.1) - 650) * 0.1;
            double resultMain = ((monthSalary + bonus) - ((monthSalary + bonus) * 0.1)) - taxSalaryMain;

            double taxSalaryComb = (((monthSalary + bonus) - ((monthSalary + bonus) * 0.1))) * 0.1;
            double resultComb = (monthSalary + bonus) - ((monthSalary + bonus) * 0.1) - taxSalaryComb;


            if (selected.equals("Основной")) {
                totalResult = Double.toString(resultMain);
            } else {
                totalResult = Double.toString(resultComb);
            }


            if (note != null) {
                note.setEmployerName(employerName);
                note.setEmployerPosition(employerPosition);
                note.setEmployerSalary(employerSalary);
                note.setBonus(employerBonus);
                note.setPersonalWage(personalDeduction);
                note.setMonthSalary(totalResult);
                App.getInstance().getDatabase().notesDao().update(note);
            } else {
                note = new Note();
                note.setEmployerName(employerName);
                note.setEmployerPosition(employerPosition);
                note.setEmployerSalary(employerSalary);
                note.setBonus(employerBonus);
                note.setPersonalWage(personalDeduction);
                note.setMonthSalary(totalResult);
                App.getInstance().getDatabase().notesDao().insertNote(note);
            }
            finish();
        } else {
            Toast.makeText(this, R.string.warning_fill_fields, Toast.LENGTH_SHORT).show();
        }

    }

    //Проверка заполнености всех полей
    private boolean isFilled(String employerName, String employerPosition, String employerSalary, String employerBonus) {
        return !employerName.isEmpty() && !employerPosition.isEmpty() && !employerSalary.isEmpty() && !employerBonus.isEmpty();
    }
}