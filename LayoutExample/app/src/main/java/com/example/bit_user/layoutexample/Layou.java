package com.example.bit_user.layoutexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Layou extends AppCompatActivity {

    LinearLayout base;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layou);
        Button btn1 = new Button(this);
        base = findViewById(R.id.baseLayout);
        btn1.setText("안녕하세요");
        btn1.setGravity(Gravity.TOP | Gravity.LEFT);
        btn1.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        base.addView(btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"안녕하세요",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
