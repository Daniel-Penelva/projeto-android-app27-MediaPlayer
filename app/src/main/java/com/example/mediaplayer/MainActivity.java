package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ceuazul);
    }

    // Método para executar o play
    public void executarSom(View view){

        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }
}
