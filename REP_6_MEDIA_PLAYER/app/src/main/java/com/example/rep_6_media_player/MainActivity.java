package com.example.rep_6_media_player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this,R.raw.share);
    }

    public void iniciar(View v){
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    public void detener(View v){
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }
    }

}