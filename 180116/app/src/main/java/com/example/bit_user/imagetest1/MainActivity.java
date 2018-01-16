package com.example.bit_user.imagetest1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static boolean flag = false;
    Button btn;
    RadioGroup radioGrp1;
    TextView result;
    EditText value1;
    EditText value2;
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        btn = findViewById(R.id.btncalc);
        radioGrp1 = findViewById(R.id.radiogrp1);
        result = findViewById(R.id.textView);
        value1 = findViewById(R.id.editText1);
        value2 = findViewById(R.id.editText2);
        img1 = findViewById(R.id.imageView);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (value1.getText().toString().isEmpty() || value2.getText().toString().isEmpty() || radioGrp1.getCheckedRadioButtonId()==-1) {
                    // 라디오 그룹에 체크된 버튼이 없을 경우 -1 반환.
                    Toast.makeText(getApplicationContext(), "값이 비어있거나 연산을 선택하지 않았습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    if (!flag) {
                        result.setVisibility(View.VISIBLE);
                        Double tmp1, tmp2, res;
                        tmp1 = Double.parseDouble(value1.getText().toString());
                        tmp2 = Double.parseDouble(value2.getText().toString());
                        RadioButton rd = findViewById(radioGrp1.getCheckedRadioButtonId());
                        switch (rd.getId()) {
                            case R.id.radioadd:
                                img1.setImageResource(R.drawable.plus);
                                res = tmp1 + tmp2;
                                break;
                            case R.id.radiosub:
                                img1.setImageResource(R.drawable.minus);
                                res = tmp1 - tmp2;
                                break;
                            case R.id.radiomul:
                                img1.setImageResource(R.drawable.mul);
                                res = tmp1 * tmp2;
                                break;
                            case R.id.radiodiv:
                                img1.setImageResource(R.drawable.divide);
                                res = tmp1 / tmp2;
                                break;
                            default:
                                res = 0.;
                        }
                        flag = true;
                        value1.setEnabled(false);
                        value2.setEnabled(false);
                        radioGrp1.setVisibility(View.INVISIBLE);
                        btn.setBackgroundColor(Color.CYAN);
                        btn.setText("다시 시작");
                        result.setText("결과는 : " + res);
                    } else {
                        btn.setBackgroundColor(Color.YELLOW);
                        result.setVisibility(View.INVISIBLE);
                        value1.setEnabled(true);
                        value2.setEnabled(true);
                        radioGrp1.setVisibility(View.VISIBLE);
                        value1.setText("");
                        value2.setText("");
                        result.setText("결과는 : ");
                        flag = false;
                        img1.setImageResource(R.drawable.calc);
                        btn.setText("계산하기");
                    }
                }
            }
        });
    }
}