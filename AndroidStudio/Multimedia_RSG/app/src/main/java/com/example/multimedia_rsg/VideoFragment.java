package com.example.multimedia_rsg;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.multimedia_rsg.databinding.FragmentSonidoBinding;
import com.example.multimedia_rsg.databinding.FragmentVideoBinding;

public class VideoFragment extends Fragment {
    FragmentVideoBinding binding;

    public VideoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentVideoBinding.inflate(inflater);
        super.onCreate(savedInstanceState);


        binding.videoView.setOnClickListener(view -> {
            VideoView reproductor = binding.videoView;

           String archivo = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC) + "/ruben.mp4";
            //reproductor.setVideoURI(Uri.parse("https://youtu.be/hOXrGqq07_U"));
            reproductor.setVideoPath(archivo);

            MediaController controller = new MediaController(getContext());
            controller.setAnchorView(reproductor);
            reproductor.setMediaController(controller);
            controller.show();
            reproductor.start();
        });

        //reproductor.setVideoURI(Uri.parse("https://youtu.be/F5tSoaJ93ac"));




        setHasOptionsMenu(true);
        return binding.getRoot();
    }
}