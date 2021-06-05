package com.example.mayana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SendInfoActivity extends AppCompatActivity {

    private EditText editTextPlaceOfReq;
    private TextView textViewEmployeeName;
    private TextView textViewEmployeePosition;
    private TextView textViewEmployeeSalary;
    private TextView textViewEmployeePersonalWage;
    private TextView textViewEmployeeMonthSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_info);
        editTextPlaceOfReq = findViewById(R.id.editTextSendPlaceOfRequirement);
        textViewEmployeeName = findViewById(R.id.textViewEmployeeName);
        textViewEmployeePosition = findViewById(R.id.textViewEmployeePosition);
        textViewEmployeeSalary = findViewById(R.id.textViewEmployeeSalary);
        textViewEmployeePersonalWage = findViewById(R.id.textViewEmployeePersonalWage);
        textViewEmployeeMonthSalary = findViewById(R.id.textViewEmployeeMonthSalary);
////
        if (getIntent() != null) {
            Note note = (Note) getIntent().getSerializableExtra("key");
            textViewEmployeeName.setText(note.getEmployerName());
            textViewEmployeePosition.setText(note.getEmployerPosition());
            textViewEmployeeSalary.setText(note.getEmployerSalary());
            textViewEmployeePersonalWage.setText(note.getPersonalWage());
            textViewEmployeeMonthSalary.setText(note.getMonthSalary());

        }
    }

    public void onClickSendEmployeeInfo(View view) {
        String placeOfReq = editTextPlaceOfReq.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(intent.EXTRA_TEXT, placeOfReq);
        Intent chosenIntent = Intent.createChooser(intent, getString(R.string.chooser));
        startActivity(chosenIntent);
    }
}