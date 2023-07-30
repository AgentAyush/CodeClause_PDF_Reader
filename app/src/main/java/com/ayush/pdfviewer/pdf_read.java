package com.ayush.pdfviewer;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class pdf_read extends AppCompatActivity {
    private ListView listView;
    private List<File> pdfList;
    private static final int STORAGE_PERMISSION_CODE = 1;

    // ... (other parts of your code)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_read);
        listView = findViewById(R.id.listView);

        // Check for storage permission
        runtimePermission();
    }

    private void runtimePermission() {
        Dexter.withContext(pdf_read.this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        // Permission granted, find and display the PDF files
                        pdfList = findPdf(Environment.getExternalStorageDirectory()); // Start searching from external storage directory
                        setListViewAdapter();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(pdf_read.this, "Permission Denied", Toast.LENGTH_SHORT).show();
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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(pdf_read.this, android.R.layout.simple_expandable_list_item_1, items);
        listView.setAdapter(adapter);
}
}
