package com.example.bit_user.intentintro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    Button btnSecond;
    RadioGroup radioGroup;
    EditText edit1stActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSecond = findViewById(R.id.btnNewActivity);
        edit1stActivity = findViewById(R.id.edit1stActivity);
        radioGroup = findViewById(R.id.radioGroup);
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioSecond:
                        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                        intent.putExtra("str1stActivity",edit1stActivity.getText().toString());
                        startActivity(intent);
                    break;
                    case R.id.radioThird:
                        Intent intent2 = new Intent(getApplicationContext(), ThirdActivity.class);
                        startActivity(intent2);
                        break;
                }
            }
        });
    }
}
