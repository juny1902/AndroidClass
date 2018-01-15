package com.example.bit_user.testapp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    RadioButton male, female;
    RadioGroup gender;
    TextView text1;
    EditText nameEntry;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        male = findViewById(R.id.radioMale);
        female = findViewById(R.id.radioFemale);
        gender = findViewById(R.id.radioGroup1);
        text1 = findViewById(R.id.text1);
        nameEntry = findViewById(R.id.edittext1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameEntry.getText() != null) {
                    name = nameEntry.getText().toString();
                    if (male.isChecked()) {
                        text1.setText("잘가요 ~~");
                        Toast.makeText(getApplicationContext(), name + "군이 작별인사를 전했습니다.", Toast.LENGTH_SHORT).show();
                        text1.setTextSize(50);
                    } else if (female.isChecked()) {
                        text1.setText("잘가요 ~~");
                        Toast.makeText(getApplicationContext(), name + "양이 작별인사를 전했습니다.", Toast.LENGTH_SHORT).show();
                        text1.setTextSize(50);
                    } else {
                        Toast.makeText(getApplicationContext(), name + "의 성별을 선택하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"이름을 입력하세요.",Toast.LENGTH_SHORT).show();
                }

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
