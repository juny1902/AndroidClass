package com.example.bit_user.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    Button btnMove;
    RadioGroup rbGroup1;
    EditText entry3rd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMove = findViewById(R.id.btnMove);
        rbGroup1 = findViewById(R.id.rbGroup1);
        entry3rd = findViewById(R.id.entry3rd);
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rbGroup1.getCheckedRadioButtonId()) {
                    case R.id.rb2nd:
                        Intent intent_2nd = new Intent(getApplicationContext(), SecondActivity.class);
                        startActivity(intent_2nd);
                        break;
                    case R.id.rb3rd:
                        Intent intent_3rd = new Intent(getApplicationContext(), ThirdActivity.class);
                        String text3rd = entry3rd.getText().toString();
                        intent_3rd.putExtra("text3rd", text3rd);
                        startActivity(intent_3rd);
                        break;
                }
            }
        });
    }


}
