package com.example.mirestaurante;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mirestaurante.databinding.FragmentCenasBinding;
import com.example.mirestaurante.databinding.FragmentValoracionBinding;

public class ValoracionFragment extends Fragment {

    public ValoracionFragment() {
        // Required empty public constructor
    }
    private FragmentValoracionBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentValoracionBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}