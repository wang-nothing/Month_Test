package com.mjd.month_test.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.mjd.month_test.R;

public class WebActivity extends AppCompatActivity {
    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Intent intent = getIntent();
        String banner = intent.getStringExtra("banner");
        webview = findViewById(R.id.webview);
        webview.loadUrl(banner);
    }
}
