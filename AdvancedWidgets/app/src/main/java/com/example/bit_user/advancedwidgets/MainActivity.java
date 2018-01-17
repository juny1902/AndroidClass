package com.example.bit_user.advancedwidgets;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    Chronometer ch1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ch1 = findViewById(R.id.ch1);
    }
    public void mOnClick(View v){
        switch(v.getId()){
            case R.id.btnStart:
                ch1.start();
                break;
            case R.id.btnStop:
                ch1.stop();
                break;
            case R.id.btnRestart:
                ch1.setBase(SystemClock.elapsedRealtime());
                break;
        }
    }
}
