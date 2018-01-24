package com.example.bit_user.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this,MusicService.class);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
                android.util.Log.i("서비스 테스트", "startService()");
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                stopService(intent);
                android.util.Log.i("서비스 테스트", "stopService()");
            }
        });
    }
}
