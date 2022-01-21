package com.example.rubensanz_6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rubensanz_6.databinding.FragmentIndianBinding;
import com.example.rubensanz_6.databinding.FragmentYamahaBinding;

public class indianFragment extends Fragment {

    public indianFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentIndianBinding binding = FragmentIndianBinding.inflate(inflater);
        binding.button3.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_indianFragment_to_categoriasFragment));
        return binding.getRoot();
    }
}