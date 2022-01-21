package com.example.multimedia_rsg;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.multimedia_rsg.databinding.FragmentSonidoBinding;

import java.io.IOException;

public class sonidoFragment extends Fragment {
    FragmentSonidoBinding binding;
    Button playpausa;
    Button playGrabacion;
    MediaPlayer mp;
    MediaRecorder grabacion;
    String archivoSalida = null;
    Button btnRecorder;
    String archivoEnemy;
    Uri archivo;

    public sonidoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSonidoBinding.inflate(inflater);
        super.onCreate(savedInstanceState);

        archivoEnemy = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC) + "/Enemy.mp3";
        archivo = Uri.parse(archivoEnemy);


        playpausa= binding.btPlay;
        playGrabacion = binding.btPlay2;
        //mp = MediaPlayer.create(getContext(), R.raw.sonido1);
        mp = MediaPlayer.create(getContext(), archivo);

        binding.btPlay.setOnClickListener(view -> {
            if(mp.isPlaying()){
                mp.pause();
                playpausa.setBackgroundResource(R.drawable.pause);
                Toast.makeText(getContext(), "Pausa",
                        Toast.LENGTH_SHORT).show();
            } else{
                mp.start();
                playpausa.setBackgroundResource(R.drawable.play);
                Toast.makeText(getContext(), "Play",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnRecorder = binding.btGrabar;



        binding.btGrabar.setOnClickListener(this::Recorder);
        binding.btPlay2.setOnClickListener(this::reproducir);

        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    public void Recorder(View view){
        if(grabacion == null){
            archivoSalida =
                    //Environment.getExternalStorageDirectory().getAbsolutePath() + "/Grabacion.mp3";
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC) + "/Grabacion.mp3";
            grabacion = new MediaRecorder();
            grabacion.setAudioSource(MediaRecorder.AudioSource.MIC);
            grabacion.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            grabacion.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            grabacion.setOutputFile(archivoSalida);
            try{
                grabacion.prepare();
                grabacion.start();
            } catch (IOException e){
            }
            btnRecorder.setBackgroundResource(R.drawable.record);
            Toast.makeText(getContext(), "Grabando...",
                    Toast.LENGTH_SHORT).show();
        } else if(grabacion != null){
            grabacion.stop();
            grabacion.release();
            grabacion = null;
            btnRecorder.setBackgroundResource(R.drawable.ic_baseline_crop_square_24);
            Toast.makeText(getContext(), "Grabación finalizada",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void reproducir(View view) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(archivoSalida);
            mediaPlayer.prepare();
        } catch (IOException e){
        }
        mediaPlayer.start();
        Toast.makeText(getContext(), "Reproduciendo audio",
                Toast.LENGTH_SHORT).show();
    }
}