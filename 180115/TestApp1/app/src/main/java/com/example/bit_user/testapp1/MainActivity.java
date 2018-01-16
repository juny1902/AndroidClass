package com.example.bit_user.testapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    TextView text1;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button1);
        btn1.setText("눌러서 인사");
        text1 = (TextView) findViewById(R.id.textView);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == false) {
                    btn1.setText("눌러서 안녕");
                    text1.setText("잘가세요 ~");
                    flag = true;
                } else {
                    btn1.setText("눌러서 인사");
                    text1.setText("안녕하세요 !");
                    flag = false;
                }
            }
        });
    }
}
