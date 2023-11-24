package com.example.editetext;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private WebView web;
    private EditText editTextSearch;
    private Button buttonGo;
    private Button onBackPressedButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.WebView);
        editTextSearch = findViewById(R.id.editTextSearch);
        buttonGo = findViewById(R.id.buttonGo);
        onBackPressedButton = findViewById(R.id.onBackPressed);
        WebSettings ws = web.getSettings();
        ws.setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = editTextSearch.getText().toString();
                if (!query.isEmpty()) {
                    String searchUrl = "https://www.google.com/search?q=" + query;
                    web.loadUrl(searchUrl);
                }
            }
        });
        onBackPressedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (web.canGoBack()) {
                    web.goBack();
                }
            }
        });
        web.loadUrl("https://www.google.com/?hl=RU");
    }

    @Override
    public void onBackPressed() {
        if (web.canGoBack()) {
            web.goBack();
        } else {
            super.onBackPressed();
        }
    }
}

