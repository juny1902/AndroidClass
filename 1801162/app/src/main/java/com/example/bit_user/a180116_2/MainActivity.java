package com.example.bit_user.a180116_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnIphone;
    Button btnNote;
    Button btnFeature;
    RadioGroup grpProvider;

    CheckBox chkDisabled;
    CheckBox chkHonor;
    CheckBox chkStudent;
    CheckBox chkSpecial;
    ImageView img1;
    public void setProviderImage(){
        switch(grpProvider.getCheckedRadioButtonId()){
            case R.id.rb_SKT:
                img1.setImageResource(R.drawable.skt);
                break;
            case R.id.rb_LGU:
                img1.setImageResource(R.drawable.lgu);
                break;
            case R.id.rb_MVNO:
                img1.setImageResource(R.drawable.mvno);
                break;
            case R.id.rb_KTF:
                img1.setImageResource(R.drawable.olleh);
                break;
        }
    }
    double getDiscountRate(){
        double discount_rate = 0;
        if (chkDisabled.isChecked())
            discount_rate += 0.2; // 20% 할인
        if (chkHonor.isChecked())
            discount_rate += 0.3; // 30% 할인
        if (chkSpecial.isChecked())
            discount_rate += 0.1; // 10% 할인
        if (chkStudent.isChecked())
            discount_rate += 0.05; // 10% 할인
        return discount_rate;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("");
        setContentView(R.layout.activity_main);

        btnNote = findViewById(R.id.btnNote);
        btnIphone = findViewById(R.id.btnIphone);
        btnFeature = findViewById(R.id.btnFeature);
        grpProvider = findViewById(R.id.grpProvider);
        chkHonor = findViewById(R.id.chk10);
        chkDisabled = findViewById(R.id.chk20);
        chkStudent = findViewById(R.id.chk30);
        chkSpecial = findViewById(R.id.chk40);

        btnIphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setProviderImage();
                double price = 1500000 * (1 - getDiscountRate());
                Toast.makeText(getApplicationContext(), "아이폰을 " + price + "원에 구매했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        btnNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setProviderImage();
                double price = 1200000 * (1 - getDiscountRate());
                Toast.makeText(getApplicationContext(), "노트를 " + price + "원에 구매했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        btnFeature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setProviderImage();
                double price = 1000000 * (1 - getDiscountRate());
                Toast.makeText(getApplicationContext(), "피쳐폰을 " + price + "원에 구매했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
