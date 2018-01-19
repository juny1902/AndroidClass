package com.example.bit_user.intentintro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by bit-user on 2018-01-19.
 */

public class ThirdActivity extends Activity {

    Button btnReturn2;
    Button btnTo4th;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        btnReturn2 = findViewById(R.id.btnReturn2);
        btnTo4th = findViewById(R.id.btnTo4th);
        btnReturn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnTo4th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(), FourthActivity.class);
                startActivity(intent3);
            }
        });

    }
}
