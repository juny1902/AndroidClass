package com.example.bit_user.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by bit-user on 2018-01-22.
 */

public class ThirdActivity extends Activity {
    TextView txtView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_third);
        txtView = findViewById(R.id.textView);
        Intent intent = getIntent();
        String textFromMain = intent.getStringExtra("text3rd");
        txtView.setText(textFromMain);
    }
}
