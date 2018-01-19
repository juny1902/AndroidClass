package com.example.bit_user.intentintro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by bit-user on 2018-01-19.
 */

public class SecondActivity extends Activity {

    Button btnReturn;
    TextView text2ndActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        text2ndActivity = findViewById(R.id.text2ndActivity);
        btnReturn = findViewById(R.id.btnReturn);
        Intent intent = getIntent();
        text2ndActivity.setText(intent.getStringExtra("str1stActivity"));
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }



}
