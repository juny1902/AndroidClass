package com.example.bit_user.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by bit-user on 2018-01-22.
 */

public class SecondActivity extends Activity {
    Button btn4th;
    TextView textFrom4th;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_second);
        btn4th = findViewById(R.id.btn4th);
        textFrom4th = findViewById(R.id.textFrom4th);
        btn4th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_4th = new Intent(getApplicationContext(),FourthActivity.class);
                startActivityForResult(intent_4th,0);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            textFrom4th.setText(data.getStringExtra("text4th"));
        }
    }
}
