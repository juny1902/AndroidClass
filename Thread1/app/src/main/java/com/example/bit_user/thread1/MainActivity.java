package com.example.bit_user.thread1;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb1;
    SeekBar sb1, sb2;
    Button btn1, btn2, btnsb1, btnsb2;
    TextView tvThread1, tvThread2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1 = findViewById(R.id.pb1);
        sb1 = findViewById(R.id.sb1);
        sb2 = findViewById(R.id.sb2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btnsb1 = findViewById(R.id.btnsb1);
        btnsb2 = findViewById(R.id.btnsb2);
        tvThread1 = findViewById(R.id.tvThread1);
        tvThread2 = findViewById(R.id.tvThread2);


        btnsb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    @Override
                    public void run() {
                        while(true)
                        for (int i = 0; i < 100; i += 1) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    sb1.setProgress(sb1.getProgress() + 1);
                                    tvThread1.setText(sb1.getProgress() + "%");

                                }
                            });
                            SystemClock.sleep(33);
                        }
                    }
                }.start();
            }
        });
        btnsb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    @Override
                    public void run() {
                        while(true)
                        for (int i = 0; i < 100; i += 1) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    sb2.setProgress(sb2.getProgress() + 1);
                                    tvThread2.setText(sb2.getProgress() + "%");
                                }
                            });
                            SystemClock.sleep(66);
                        }
                    }
                }.start();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pb1.getProgress() == 100) pb1.setProgress(0);
                else pb1.setProgress(pb1.getProgress() + 10);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pb1.getProgress() == 0) pb1.setProgress(0);
                else pb1.setProgress(pb1.getProgress() - 10);
            }
        });
    }
}
