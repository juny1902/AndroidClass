package com.example.bit_user.googlemaps2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by bit-user on 2018-01-24.
 */

public class MusicService extends Service {
    MediaPlayer mp;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        android.util.Log.i("서비스 테스트", "onCreate()");
        Toast.makeText(getApplicationContext(),"플레이어를 생성합니다.",Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        android.util.Log.i("서비스 테스트", "onDestroy()");
        Toast.makeText(getApplicationContext(),"음악을 정지합니다.",Toast.LENGTH_SHORT).show();
        mp.stop();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        android.util.Log.i("서비스 테스트", "onStartCommand()");
        Toast.makeText(getApplicationContext(),"음악을 재생합니다.",Toast.LENGTH_SHORT).show();

        mp = MediaPlayer.create(this, R.raw.song2);
        mp.setLooping(true);
        mp.start();
        return super.onStartCommand(intent, flags, startId);
    }
}
