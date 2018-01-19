package com.example.bit_user.sdirectory;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button mkDir, rmDir, chkDir;
    EditText toPrint, entryDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mkDir = findViewById(R.id.mkDir);
        rmDir = findViewById(R.id.rmDir);
        chkDir = findViewById(R.id.fileList);
        entryDir = findViewById(R.id.editDirectory);
        toPrint = findViewById(R.id.entryList);

        final String strSDpath =
                Environment.getRootDirectory().getAbsolutePath();


        mkDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (entryDir.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "경로를 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    File myDir = new File(strSDpath + "/" + entryDir.getText().toString());
                    myDir.mkdir();
                    Toast.makeText(getApplicationContext(),
                            String.format("%s 폴더를 생성하였습니다.",myDir),Toast.LENGTH_SHORT).show();
                }
            }
        });
        rmDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (entryDir.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "경로를 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    final File myDir = new File(strSDpath + "/" +entryDir.getText().toString());
                    if (myDir.exists())
                        myDir.delete();
                    else {
                        Toast.makeText(MainActivity.this, "폴더가 없습니다.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        chkDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File[] sysFiles = (new File(strSDpath).listFiles());
                String strFname = "";
                if (sysFiles != null)
                    for (int i = 0; i < sysFiles.length; i++) {
                        if (sysFiles[i].isDirectory() == true) {
                            strFname += "<폴더>" + sysFiles[i].toString();
                        } else {
                            strFname += "<파일>" + sysFiles[i].toString();
                        }

                        toPrint.setText(toPrint.getText() + "\n" + strFname);
                    }
                else
                    Toast.makeText(getApplicationContext(), "폴더가 비어있습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
