package com.example.bit_user.a180116_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnIphone;
    Button btnNote;
    Button btnFeature;
    RadioGroup grpProvider;
    TextView result;
    CheckBox chkDisabled;
    CheckBox chkHonor;
    CheckBox chkStudent;
    CheckBox chkSpecial;
    ImageView img1;

    public void setProviderImage() {
        RadioButton rb = findViewById(grpProvider.getCheckedRadioButtonId());
        switch (rb.getId()) {
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
    void setResultText(double original, double price){
        String str;
        str = String.format("원가:%.0f\n할인율 : %.0f%%\n-------------\n구매 가격:%.0f\n",original,getDiscountRate()*100,price);
        result.setText(str);
    }
    double getDiscountRate() {
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
        setTitle("휴대폰 구매하기");
        setContentView(R.layout.activity_main);

        img1 = findViewById(R.id.imageView);
        btnNote = findViewById(R.id.btnNote);
        btnIphone = findViewById(R.id.btnIphone);
        btnFeature = findViewById(R.id.btnFeature);
        grpProvider = findViewById(R.id.grpProvider);
        chkHonor = findViewById(R.id.chk10);
        chkDisabled = findViewById(R.id.chk20);
        chkStudent = findViewById(R.id.chk30);
        chkSpecial = findViewById(R.id.chk40);
        result = findViewById(R.id.result);

        grpProvider.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                btnFeature.setVisibility(View.VISIBLE);
                btnIphone.setVisibility(View.VISIBLE);
                btnNote.setVisibility(View.VISIBLE);
            }
        });
        btnIphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setProviderImage();
                double price = 1500000 * (1 - getDiscountRate());
                setResultText(1500000.0,price);
                Toast.makeText(getApplicationContext(), "아이폰을 " + price + "원에 구매했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        btnNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setProviderImage();
                double price = 1200000 * (1 - getDiscountRate());
                setResultText(1200000.0,price);
                Toast.makeText(getApplicationContext(), "노트를 " + price + "원에 구매했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        btnFeature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setProviderImage();
                double price = 1000000 * (1 - getDiscountRate());
                setResultText(1000000.0,price);
                Toast.makeText(getApplicationContext(), "피쳐폰을 " + price + "원에 구매했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
