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

    // Método para executar o play
    public void pausarSom(View view){

        // Para saber se a música está sendo executada - utiliza-se o método isPlaying que retorna um boolean
        if(mediaPlayer.isPlaying()){

            mediaPlayer.pause();
        }
    }

    public void paraSom(View view){
        if(mediaPlayer.isPlaying()){

            mediaPlayer.stop();

            // Para reiniciar a música de novo
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ceuazul);
        }
    }
}
