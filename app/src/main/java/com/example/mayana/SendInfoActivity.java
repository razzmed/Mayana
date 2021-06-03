package com.example.mayana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SendInfoActivity extends AppCompatActivity {

    private EditText editTextPlaceOfReq;
//    private TextView textViewEmployeeInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_info);
        editTextPlaceOfReq = findViewById(R.id.editTextSendPlaceOfRequirement);
////        textViewEmployeeInfo = findViewById(R.id.textViewEmployeeInfo);
////
////        Intent intent = getIntent();
////        if (intent.hasExtra("employee_name")) {
////            String nameEmployee = intent.getStringExtra("employee_name");
////            textViewEmployeeInfo.setText(nameEmployee);
//        }
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