package com.example.bit_user.implicit_intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MapsActivity extends AppCompatActivity {
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        btn1 = findViewById(R.id.btnBit);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://goo.gl/maps/EmqqdPTtTvu");
                Intent intentMap = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intentMap);
            }
        });
    }
}
