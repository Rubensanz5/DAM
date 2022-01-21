package com.example.mirestaurante;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mirestaurante.databinding.FragmentComidasBinding;
import com.example.mirestaurante.databinding.FragmentQuienesSomosBinding;

public class QuienesSomosFragment extends Fragment {

    public QuienesSomosFragment() {
        // Required empty public constructor
    }
    FragmentQuienesSomosBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentQuienesSomosBinding.inflate(getLayoutInflater());
       return binding.getRoot();
    }
}