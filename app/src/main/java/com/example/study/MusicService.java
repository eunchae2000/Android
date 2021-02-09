package com.example.study;

import android.content.Intent;
import android.media.MediaPlayer;
import android.app.Service;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service{
    MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        android.util.Log.i("ServiceTest", "service-onStartCommand()");
        super.onCreate();

        mediaPlayer = MediaPlayer.create(this,R.raw.song2);
        mediaPlayer.setLooping(true);
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        android.util.Log.i("ServiceTest", "service - onStartCommand()");

        mediaPlayer = MediaPlayer.create(this, R.raw.song2);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy(){
        android.util.Log.i("ServiceTest", "service - onDestory()");
        mediaPlayer.stop();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}