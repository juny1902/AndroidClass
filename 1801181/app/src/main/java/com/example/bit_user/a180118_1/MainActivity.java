package com.example.bit_user.a180118_1;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup1;
    DatePicker datePicker;
    TimePicker timePicker;
    Chronometer chronometer;
    RatingBar rate1;
    TextView reserv, rateText;
    LinearLayout ratingLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup1 = findViewById(R.id.radioGroup1);
        datePicker = findViewById(R.id.DatePicker1);
        timePicker = findViewById(R.id.TimePicker1);
        chronometer = findViewById(R.id.chronometer1);
        reserv = findViewById(R.id.reservation1);
        rate1 = findViewById(R.id.rate1);
        rateText = findViewById(R.id.rateText);
        ratingLayout = findViewById(R.id.rateLayout);

        chronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup1.setVisibility(View.VISIBLE);
                chronometer.setBase(SystemClock.elapsedRealtime());

                chronometer.start();
                chronometer.setTextColor(
                        Color.argb(0xFF, 0xFF, 0x00, 0x00));
            }
        });

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioDate:
                        ratingLayout.setVisibility(View.VISIBLE);
                        timePicker.setVisibility(View.INVISIBLE);
                        datePicker.setVisibility(View.VISIBLE);
                        break;
                    case R.id.radioTime:
                        ratingLayout.setVisibility(View.VISIBLE);
                        timePicker.setVisibility(View.VISIBLE);
                        datePicker.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        });

        rate1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                rateText.setText("평점 : " + rate1.getRating());
            }
        });
        
        reserv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                float rate = rate1.getRating();
                String tmp = String.format("%d년 %d월 %d일 %d시 %d분 예약됨\n만족도 : %.1f 점",
                        datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth(),
                        timePicker.getHour(), timePicker.getMinute(), rate);
                reserv.setText(tmp);
                chronometer.stop();
                ratingLayout.setVisibility(View.INVISIBLE);
                radioGroup1.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
                chronometer.setTextColor(
                        Color.argb(0xFF, 0x00, 0x00, 0x00));
                return false;
            }
        });
    }
}
