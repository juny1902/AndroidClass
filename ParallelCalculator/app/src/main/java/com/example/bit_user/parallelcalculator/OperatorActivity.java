package com.example.bit_user.parallelcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class OperatorActivity extends AppCompatActivity {
    int number1, number2;
    TextView number1_view, number2_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operator);
        number1_view = findViewById(R.id.Number1_View);
        number2_view = findViewById(R.id.Number2_View);
        Intent intent = getIntent();
        number1 = intent.getIntExtra("Number1", 0);
        number2 = intent.getIntExtra("Number2", 0);
        number1_view.setText("첫번째 값 : " + number1);
        number2_view.setText("두번째 값 : " + number2);
    }

    public void onOperatorClick(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        int result = 0;
        switch (v.getId()) {
            case R.id.buttonPlus:
                result = number1 + number2;
                break;
            case R.id.buttonMinus:
                result = number1 - number2;
                break;
            case R.id.buttonMultiplication:
                result = number1 * number2;
                break;
            case R.id.buttonDivide:
                result = number1 / number2;
                break;
            case R.id.buttonModular:
                result = number1 % number2;
                break;
            case R.id.buttonPartial:
                int sum = 0;
                for(int i=number1; i<=number2; i++){
                    sum += i;
                }
                result = sum;
                break;
        }
        intent.putExtra("Result", result);
        setResult(RESULT_OK, intent);
        finish();
    }
}
