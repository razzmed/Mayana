package com.example.mayana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class ViewPdfActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf);

        pdfView = findViewById(R.id.viewPdf);

        String path = getExternalFilesDir(null).toString() + "/employeeInfo.pdf";
        File file = new File(path);

        pdfView.fromFile(file).swipeHorizontal(false).enableDoubletap(true).enableAnnotationRendering(false).defaultPage(0).scrollHandle(null)
                .password(null).load();
    }
}