package com.project.eperda.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.webkit.WebView;

import com.project.eperda.R;

import java.util.Objects;

public class LiveChatActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_chat);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar_live);
        setSupportActionBar(mToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        webView = findViewById(R.id.livechat);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://eperda-chat.et.r.appspot.com");
    }
}