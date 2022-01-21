package com.example.mirestaurante;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mirestaurante.databinding.FragmentFinalBinding;

public class FinalFragment extends Fragment {

    FragmentFinalBinding binding;

    public FinalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentFinalBinding.inflate(getLayoutInflater());
       binding.tvReserva2.setText(binding.tvReserva2.getText() + FinalFragmentArgs.fromBundle(getArguments()).getNombre());
       binding.tvReserva3.setText(binding.tvReserva3.getText() + FinalFragmentArgs.fromBundle(getArguments()).getPrecio());
       return binding.getRoot();
    }
}