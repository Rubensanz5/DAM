package com.example.rubensanz_6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rubensanz_6.databinding.FragmentKTMBinding;


public class KTMFragment extends Fragment {

    public KTMFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentKTMBinding binding = FragmentKTMBinding.inflate(inflater);
        binding.button6.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_KTMFragment_to_categoriasFragment));
        return binding.getRoot();
    }
}