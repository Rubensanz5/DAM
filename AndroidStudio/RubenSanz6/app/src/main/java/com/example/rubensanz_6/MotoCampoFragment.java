package com.example.rubensanz_6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rubensanz_6.databinding.FragmentMotoCampoBinding;

public class MotoCampoFragment extends Fragment {


    public MotoCampoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMotoCampoBinding binding= FragmentMotoCampoBinding.inflate(getLayoutInflater());
        binding.button4.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_motoCampoFragment_to_KTMFragment));
        binding.button5.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_motoCampoFragment_to_TRRSFragment));
        return binding.getRoot();
    }
}