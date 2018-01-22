package com.example.bit_user.parallelcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText entry1, entry2;
    TextView textResult;
    Button btnOper;
    int Number1, Number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entry1 = findViewById(R.id.editText);
        entry2 = findViewById(R.id.editText2);
        btnOper = findViewById(R.id.button);
        textResult = findViewById(R.id.textView);

        btnOper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Number1 = Integer.parseInt(entry1.getText().toString());
                Number2 = Integer.parseInt(entry2.getText().toString());
                Intent intent = new Intent(getApplicationContext(), OperatorActivity.class);
                intent.putExtra("Number1",Number1);
                intent.putExtra("Number2",Number2);
                startActivityForResult(intent, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int result = data.getIntExtra("Result", 0);
            textResult.setText("Result : " + result);
        }
    }
}
