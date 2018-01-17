package com.example.bit_user.a180117;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn3;
    Switch sw1;
    LinearLayout lay1, lay2, lay3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button1);
        btn3 = findViewById(R.id.button3);
        sw1 = findViewById(R.id.switch1);
        lay1 = findViewById(R.id.Lay1);
        lay2 = findViewById(R.id.Lay2);
        lay3 = findViewById(R.id.Lay3);
        final int c1 = lay1.getSolidColor();
        final int c2 = lay2.getSolidColor();
        final int c3 = lay3.getSolidColor();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "버튼 1 클릭.", Toast.LENGTH_SHORT).show();
            }
        });

        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (sw1.isChecked()) {
                    btn1.setVisibility(View.VISIBLE);
                    btn3.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "버튼이 보입니다.", Toast.LENGTH_SHORT).show();
                } else {
                    btn1.setVisibility(View.INVISIBLE);
                    btn3.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "버튼을 숨깁니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "버튼 3 클릭.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
