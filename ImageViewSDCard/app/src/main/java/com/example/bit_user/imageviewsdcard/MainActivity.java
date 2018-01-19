package com.example.bit_user.imageviewsdcard;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    myPictureView myPicture;
    int curNum;
    File[] imageFiles;
    String imageFrame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        myPicture = findViewById(R.id.PictureView1);

        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures/").listFiles();
        imageFrame = imageFiles[0].toString();
        myPicture.imagePath = imageFrame;

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curNum <= 0){
                    Toast.makeText(MainActivity.this, "첫번째 그림입니다.", Toast.LENGTH_SHORT).show();
                } else{
                    curNum--;
                    imageFrame = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFrame;
                    myPicture.invalidate();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curNum >= imageFiles.length){
                    Toast.makeText(MainActivity.this, "마지막 그림입니다.", Toast.LENGTH_SHORT).show();
                } else{
                    curNum++;
                    imageFrame = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFrame;
                    myPicture.invalidate();
                }
            }
        });
    }
}
