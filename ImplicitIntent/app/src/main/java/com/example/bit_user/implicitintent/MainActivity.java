package com.example.bit_user.implicitintent;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        android.util.Log.i("액티비티","복귀함.");
    }

    public void onButtonClick(View v) {
        Intent intent;
        Uri uri;
        switch (v.getId()) {
            case R.id.button1:
                uri = Uri.parse("tel:0234863456");
                intent = new Intent(Intent.ACTION_DIAL, uri);
                android.util.Log.i("액티비티","call()");
                break;
            case R.id.button2:
                uri = Uri.parse("http://www.bitacademy.com/");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                android.util.Log.i("액티비티","홈페이지 열기");
                break;
            case R.id.button3:
                uri = Uri.parse("http://maps.google.com/maps?q="+ 45.9 + "," + 45.9 );
                intent = new Intent(Intent.ACTION_VIEW, uri);
                android.util.Log.i("액티비티","지도 열기");
                break;
            case R.id.button4: // SMS 전송
                uri = Uri.parse("tel:0234863456");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.putExtra("sms_body", "문의할 내용을 적어주세요");
                intent.setType("vnd.android-dir/mms-sms");
                android.util.Log.i("액티비티","문자 보내기");
                break;
            case R.id.button5:
                intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "비트 컴퓨터");
                android.util.Log.i("액티비티:","검색");
                intent = getIntent();
            default:
                intent = getIntent();
        }
        startActivity(intent);
    }
}
