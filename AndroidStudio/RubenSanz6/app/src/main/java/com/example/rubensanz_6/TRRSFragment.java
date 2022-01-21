package com.example.rubensanz_6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rubensanz_6.databinding.FragmentTRRSBinding;


public class TRRSFragment extends Fragment {

    public TRRSFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTRRSBinding binding = FragmentTRRSBinding.inflate(inflater);
        binding.button7.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_TRRSFragment_to_categoriasFragment));
        return binding.getRoot();
    }
}