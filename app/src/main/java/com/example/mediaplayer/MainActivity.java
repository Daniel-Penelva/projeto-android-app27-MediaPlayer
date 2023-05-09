package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private SeekBar seekBarVolume;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ceuazul);

       inicializarSeekBar();
    }

    private void inicializarSeekBar(){
        seekBarVolume = findViewById(R.id.seekVolume);

        /* Configura audio manager - consegue saber o volume atual que está executando para o usuário e
        qual é o volume máximo que consegue aumentar essa música no celular dele. */

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);  //recupera alguns serviços do sistema

        int volumeMaximo = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC); //recupera o valor do volume máximo

        int volumeAtual = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC); // recupera o valor do volume atual

        /* Configura os valores máximos para o SeekBar */
        seekBarVolume.setMax(volumeMaximo);

        /* Configura o progresso atual do SeekBar */
        seekBarVolume.setProgress(volumeAtual);

        /* configura o incremento do volume (aumentando ou diminuindo) quando arrasta o progresso do SeekBar */
        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // Vamos usar apenas esse método que correspondo qnd o usuário manipula a seekBar
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

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

    // Definir um ciclo de vida para que quando o usuário saia do app a música para de tocar
    @Override
    protected void onStop() {
        super.onStop();

        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }
}
