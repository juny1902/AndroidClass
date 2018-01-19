package com.example.bit_user.dialogs_1;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    TextView[] views = new TextView[5];
    TextView fileText;
    EditText dlgID, dlgEmail;
    Integer[] view_id = {R.id.textAlret, R.id.textNorm, R.id.textCheck, R.id.textRadio, R.id.textInfo};
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < view_id.length; i++)
            views[i] = findViewById(view_id[i]);

        fileText = findViewById(R.id.fileText);

    }

    public void btnOnClick(View v) {
        switch (v.getId()) {
            case R.id.btnAlret:
                AlertDialog.Builder dlg1 = new AlertDialog.Builder(MainActivity.this);
                dlg1.setTitle("경고 대화상자");
                dlg1.setIcon(R.mipmap.ic_launcher_round);
                dlg1.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        views[0].setText("확인 선택함.");
                    }
                });
                dlg1.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        views[0].setText("취소 선택함.");
                    }
                });
                dlg1.show();
                break;
            case R.id.btnNorm:
                final String[] contentArray = {"마쎄라티", "포르쉐", "페라리", "램볼귀니"};
                AlertDialog.Builder dlg2 = new AlertDialog.Builder(MainActivity.this);
                dlg2.setTitle("좋아하는 자동차는 ?");
                dlg2.setItems(contentArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        views[1].setText(contentArray[i] + " 선택함");
                    }
                });
                dlg2.setPositiveButton("닫기", null);
                dlg2.show();
                break;
            case R.id.btnCheck:
                final String[] contentArray2 = {"ECS", "ABS", "LSD", "7인치네비"};
                final boolean[] checkArray = {false, false, false, true};
                AlertDialog.Builder dlg3 = new AlertDialog.Builder(MainActivity.this);
                dlg3.setTitle("옵션을 선택하세요");
                dlg3.setMultiChoiceItems(contentArray2, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        String tmp = "";
                        for (int j = 0; j < checkArray.length; j++) {
                            if (checkArray[j] == true)
                                tmp += (contentArray2[j] + "  ");

                        }
                        views[2].setText(tmp);
                    }
                });
                dlg3.setPositiveButton("닫기", null);
                dlg3.show();
                break;
            case R.id.btnRadio:
                final String[] contentArray3 = {"SUV", "세단", "쿠페", "수퍼카"};
                AlertDialog.Builder dlg4 = new AlertDialog.Builder(MainActivity.this);
                dlg4.setTitle("차종을 선택하세요");
                dlg4.setSingleChoiceItems(contentArray3, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        views[3].setText(contentArray3[i]);
                    }
                });
                dlg4.setPositiveButton("닫기", null);
                dlg4.show();
                break;
            case R.id.btnInfo:
                dialogView = View.inflate(MainActivity.this, R.layout.dialog1, null);
                final AlertDialog.Builder dlgUser = new AlertDialog.Builder(MainActivity.this);
                dlgUser.setTitle("유저 정보 입력");
                dlgUser.setIcon(R.mipmap.ic_launcher_round);
                dlgUser.setView(dialogView);
                dlgUser.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dlgID = dialogView.findViewById(R.id.editID);
                        dlgEmail = dialogView.findViewById(R.id.editMail);
                        views[4].setText(String.format("사용자 이름 : %s\n이메일 : %s\n", dlgID.getText().toString(), dlgEmail.getText().toString()));
                    }
                });
                dlgUser.setNegativeButton("취소", null);
                dlgUser.show();
                break;
        }
    }

    public void btnFile(View v) {
        switch (v.getId()) {
            case R.id.btnWrite:
                try {
                    FileOutputStream outFs = openFileOutput("file1.txt", Context.MODE_PRIVATE);
                    String str = "";
                    for (int i = 0; i < views.length; i++)
                        str += (views[i].getText().toString() + "\n");
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), "file.txt 를 생성하였습니다.", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "파일을 찾을 수 없습니다.", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "파일을 읽고 쓸 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnRead:
                try{
                    FileInputStream inFs = openFileInput("file1.txt");
                    byte[] txt = new byte[3000];
                    inFs.read(txt);
                    String str = new String(txt);
                    fileText.setText(str);

                }catch (IOException e){
                    Toast.makeText(getApplicationContext(), "파일 없음.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
