package com.example.rubensanz_6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rubensanz_6.databinding.FragmentYamahaBinding;

public class YamahaFragment extends Fragment {

    public YamahaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentYamahaBinding binding = FragmentYamahaBinding.inflate(inflater);
        binding.button3.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_yamahaFragment_to_categoriasFragment));
        return binding.getRoot();
    }
}