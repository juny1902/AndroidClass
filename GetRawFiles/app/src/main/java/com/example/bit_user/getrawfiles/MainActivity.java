package com.example.bit_user.getrawfiles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    Button btnRead, btnReadSD;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnReadSD = findViewById(R.id.btnReadSD);
        btnRead = findViewById(R.id.btnRead);
        editText = findViewById(R.id.editFile);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputS = getResources().openRawResource(R.raw.file);
                    byte[] txt = new byte[inputS.available()];
                    inputS.read(txt);
                    editText.setText(new String(txt));
                    inputS.close();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "파일 열기 실패", Toast.LENGTH_SHORT);
                }
            }
        });
        btnReadSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream inputS = new FileInputStream("/storage/emulated/0/information.txt");
                    byte[] txt = new byte[inputS.available()];
                    inputS.read(txt);
                    editText.setText(new String(txt));
                    inputS.close();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "파일 열기 실패", Toast.LENGTH_SHORT);
                }
            }
        });
    }
}
