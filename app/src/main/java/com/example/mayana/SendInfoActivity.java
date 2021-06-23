package com.example.mayana;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.print.pdf.PrintedPdfDocument;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Documented;

public class SendInfoActivity extends AppCompatActivity {

    private TextView textViewEmployeeInfo, textViewEmployeeName, textViewEmployeePosition, textViewEmployeeSalary, textViewBonus,
            textViewEmployeePersonalWage, textViewEmployeeMonthSalary;
    private Button btnAdd, btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_info);

        btnAdd = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);
        textViewEmployeeInfo = findViewById(R.id.textViewEmployeeInfo);
        textViewEmployeeName = findViewById(R.id.textViewEmployeeName);
        textViewEmployeePosition = findViewById(R.id.textViewEmployeePosition);
        textViewEmployeeSalary = findViewById(R.id.textViewEmployeeSalary);
        textViewBonus = findViewById(R.id.textViewEmployeeBonus);
        textViewEmployeePersonalWage = findViewById(R.id.textViewEmployeePersonalWage);
        textViewEmployeeMonthSalary = findViewById(R.id.textViewEmployeeMonthSalary);
        if (getIntent() != null) {
            Note note = (Note) getIntent().getSerializableExtra("key");
            textViewEmployeeName.setText(note.getEmployerName());
            textViewEmployeePosition.setText(note.getEmployerPosition());
            textViewEmployeeSalary.setText(note.getEmployerSalary());
            textViewBonus.setText(note.getBonus());
            textViewEmployeePersonalWage.setText(note.getPersonalWage());
            textViewEmployeeMonthSalary.setText(note.getMonthSalary());
        }
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String employeeInfo = textViewEmployeeInfo.getText().toString();
                String employeeName = textViewEmployeeName.getText().toString();
                String employeePosition = textViewEmployeePosition.getText().toString();
                String employeeSalary = textViewEmployeeSalary.getText().toString();
                String employeeBonus = textViewBonus.getText().toString();
                String employeePersonalWage = textViewEmployeePersonalWage.getText().toString();
                String employeeMonthSalary = textViewEmployeeMonthSalary.getText().toString();

                String path = getExternalFilesDir(null).toString() + "/employeeInfo.pdf";
                File file = new File(path);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                Document document = new Document(PageSize.A4);
                try {
                    PdfWriter.getInstance(document, new FileOutputStream(file.getAbsoluteFile()));
                } catch (DocumentException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                document.open();

                Font font = new Font(Font.FontFamily.HELVETICA, 32, Font.BOLD);

                Paragraph paragraph = new Paragraph();
                paragraph.add(new Paragraph("Employee Information" + employeeInfo, font));
                paragraph.add(new Paragraph("\n"));
                paragraph.add(new Paragraph("Employee Name: " + employeeName, font));
                paragraph.add(new Paragraph("\n"));
                paragraph.add(new Paragraph("Position: " + employeePosition, font));
                paragraph.add(new Paragraph("\n"));
                paragraph.add(new Paragraph("Salary: " + employeeSalary, font));
                paragraph.add(new Paragraph("\n"));
                paragraph.add(new Paragraph("Bonus: " + employeeBonus, font));
                paragraph.add(new Paragraph("\n"));
                paragraph.add(new Paragraph("Personal Wage: " + employeePersonalWage, font));
                paragraph.add(new Paragraph("\n"));
                paragraph.add(new Paragraph("Month salary: " + employeeMonthSalary, font));

                try {
                    document.add(paragraph);
                } catch (DocumentException e) {
                    e.printStackTrace();
                }

                document.close();

                Toast.makeText(SendInfoActivity.this, "PDF документ создан!", Toast.LENGTH_SHORT).show();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ViewPdfActivity.class);
                startActivity(intent);
            }
        });
    }

}