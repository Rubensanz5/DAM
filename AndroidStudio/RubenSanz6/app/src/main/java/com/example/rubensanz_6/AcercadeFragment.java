package com.example.rubensanz_6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rubensanz_6.databinding.FragmentAcercadeBinding;

public class AcercadeFragment extends Fragment {
    FragmentAcercadeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAcercadeBinding.inflate(getLayoutInflater());
        binding.buttonVolver.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.bienvenidaFragment));
        return binding.getRoot();
    }
}