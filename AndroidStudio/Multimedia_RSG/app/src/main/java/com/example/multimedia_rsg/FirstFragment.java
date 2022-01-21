package com.example.multimedia_rsg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.multimedia_rsg.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        binding.btsonido.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_FirstFragment_to_sonidoFragment));
        binding.btVideo.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_FirstFragment_to_videoFragment));
        binding.btSensores.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_FirstFragment_to_sensorFragment));

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}