package com.example.bit_user.simplewebview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

class WebViewClient extends android.webkit.WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

        return super.shouldOverrideUrlLoading(view, request);
    }
}

public class MainActivity extends AppCompatActivity {
    Button btnGo, btnBack, btnForward;
    WebView brw;
    EditText urlEntry1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGo = findViewById(R.id.btnGo);
        btnBack = findViewById(R.id.btnBack);
        btnForward = findViewById(R.id.btnFront);
        brw = findViewById(R.id.webView1);
        brw.setWebViewClient(new WebViewClient());
        WebSettings webSet = brw.getSettings();
        webSet.setBuiltInZoomControls(true);
        webSet.setJavaScriptEnabled(true);

        urlEntry1 = findViewById(R.id.urlEntry1);
        urlEntry1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    btnGo.callOnClick();
                }
                return false;
            }
        });
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (urlEntry1.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "주소를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else {
                    brw.loadUrl(urlEntry1.getText().toString());
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brw.goBack();
            }
        });

        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brw.goForward();
            }
        });

    }
}
