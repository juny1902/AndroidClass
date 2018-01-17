package com.example.bit_user.layoutduplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    EditText entry1;
    TextView view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setBackgroundColor(Color.argb(70, 255, 255, 0));
        setContentView(baseLayout, params);
        btn1 = new Button(this);
        btn1.setText("짧게눌러 출력\n\n길게눌러 종료");
        btn1.setTextSize(30);
        btn1.setTextColor(Color.argb(0xAA,0x66,0xFF,0xFF));
        btn1.setBackgroundColor(Color.argb(0xA3, 0xFF, 0, 0xFF));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = entry1.getText().toString();
                if (tmp.trim().isEmpty()) {
                    view1.setText("NULL");
                    Toast.makeText(getApplicationContext(), String.format("출력할 메시지가 없습니다."), Toast.LENGTH_SHORT).show();
                } else {
                    view1.setText(tmp);
                    Toast.makeText(getApplicationContext(), String.format("메시지 : %s", tmp), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getApplicationContext(),"종료합니다.",Toast.LENGTH_SHORT).show();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
                finish();
                return false;
            }
        });

        btn1.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                Toast.makeText(getApplicationContext(),"드래그 중 입니다.",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        entry1 = new EditText(this);
        entry1.setHint("힌트를 이렇게 줍니다");
        entry1.setTextSize(35);
        entry1.setHintTextColor(Color.CYAN);
        entry1.setTextColor(Color.argb(0xFF,0x33,0x66,0xFF));
        view1 = new TextView(this);
        view1.setText("아직 아무것도 없습니다.");
        view1.setTextSize(40);
        view1.setGravity(Gravity.CENTER);
        view1.setTextColor(Color.argb(255, 255, 0, 0));
        baseLayout.addView(entry1);
        baseLayout.addView(btn1);
        baseLayout.addView(view1);
    }
}
