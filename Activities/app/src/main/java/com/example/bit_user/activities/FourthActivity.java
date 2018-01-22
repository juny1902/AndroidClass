package com.example.bit_user.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by bit-user on 2018-01-22.
 */

public class FourthActivity extends Activity{
    EditText textEntry;
    Button goBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fourth);
        textEntry = findViewById(R.id.textEntry);
        goBack = findViewById(R.id.btnBack_4th);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(),SecondActivity.class);
                outIntent.putExtra("text4th",textEntry.getText().toString());
                setResult(RESULT_OK,outIntent);
                finish();
            }
        });
    }
}
