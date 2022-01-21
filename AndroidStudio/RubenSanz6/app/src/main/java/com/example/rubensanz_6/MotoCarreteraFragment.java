package com.example.rubensanz_6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rubensanz_6.databinding.FragmentMotoCarreteraBinding;


public class MotoCarreteraFragment extends Fragment {
    public MotoCarreteraFragment() {
        // Required empty public constructor
    }
    FragmentMotoCarreteraBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMotoCarreteraBinding.inflate(inflater);
        binding.button.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_motoCarreteraFragment_to_yamahaFragment));
        binding.button2.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_motoCarreteraFragment_to_indianFragment));

        return binding.getRoot();
    }
}