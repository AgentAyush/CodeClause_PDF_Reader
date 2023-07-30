package com.ayush.pdfviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Read_pdf extends AppCompatActivity {
    private List<File> pdfList;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_pdf);
        listView = findViewById(R.id.listView);

        // Check for storage permission
        runtimePermission();
    }

    private void runtimePermission() {
        Dexter.withContext(Read_pdf.this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        // Permission granted, find and display the PDF files
                        pdfList = findPdf(Environment.getExternalStorageDirectory()); // Start searching from external storage directory
                        setListViewAdapter();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(Read_pdf.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();
    }

    public ArrayList<File> findPdf(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        if (file != null) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File singleFile : files) {
                    if (singleFile.isDirectory() && !singleFile.isHidden()) {
                        arrayList.addAll(findPdf(singleFile));
                    } else {
                        if (singleFile.getName().endsWith(".pdf")) {
                            arrayList.add(singleFile);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private void setListViewAdapter() {
        ArrayList<String> items = new ArrayList<>();
        for (File file : pdfList) {
            String name = file.getName();
            String itemName = name.substring(0, name.lastIndexOf('.'));
            items.add(itemName); // Add the name without extension to the items list
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(Read_pdf.this, android.R.layout.simple_expandable_list_item_1, items);
        listView.setAdapter(adapter);
    }
}