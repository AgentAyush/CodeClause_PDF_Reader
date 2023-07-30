package com.ayush.pdfviewer;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class PdfViewerActivity extends AppCompatActivity {

    private WebView pdfWebView;
    private String pdfPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        pdfPath = getIntent().getStringExtra("pdf_path");

        pdfWebView = findViewById(R.id.pdfWebView);
        setupWebView();
    }

    private void setupWebView() {
        WebSettings webSettings = pdfWebView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enable JavaScript if required

        pdfWebView.setWebViewClient(new WebViewClient());
        pdfWebView.loadUrl("file://" + pdfPath);
    }
}
