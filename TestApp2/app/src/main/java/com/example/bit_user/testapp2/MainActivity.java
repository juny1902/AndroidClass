package com.example.bit_user.testapp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    RadioButton male,female;
    RadioGroup gender;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        male = findViewById(R.id.radioMale);
        female = findViewById(R.id.radioFemale);
        text1 = findViewById(R.id.text1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText("잘가요 ~~");
                Toast.makeText(getApplicationContext(), "작별인사를 전했습니다.", Toast.LENGTH_SHORT).show();
                text1.setTextSize(50);
                btn1.setVisibility(View.INVISIBLE);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, btn2.getText() + "을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
