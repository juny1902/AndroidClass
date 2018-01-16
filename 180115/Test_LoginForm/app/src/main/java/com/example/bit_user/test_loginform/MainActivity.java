package com.example.bit_user.test_loginform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_login;
    EditText ID, PW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.buttonLogin);
        ID = findViewById(R.id.editText_id);
        PW = findViewById(R.id.editText_pw);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, String.format("아이디 : %s\n비밀번호 : %s",
                        ID.getText(),PW.getText()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
