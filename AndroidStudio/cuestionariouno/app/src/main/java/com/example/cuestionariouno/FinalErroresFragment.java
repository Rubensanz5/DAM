package com.example.cuestionariouno;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cuestionariouno.databinding.FragmentFinalErroresBinding;

public class FinalErroresFragment extends Fragment {
    public FinalErroresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_final_errores, container, false);
        FragmentFinalErroresBinding binding = FragmentFinalErroresBinding.inflate(getLayoutInflater());
        binding.fallar3.setText(binding.fallar3.getText() + FinalErroresFragmentArgs.fromBundle(getArguments()).getNombre());
        binding.buttonInicio.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_finalErroresFragment_to_cuestionarioFragment));

        return binding.getRoot();
    }
}