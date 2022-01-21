package com.example.miniproyecto;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miniproyecto.databinding.FragmentPathBinding;
import com.example.miniproyecto.databinding.FragmentSecondBinding;


public class PathFragment extends Fragment {
    private FragmentPathBinding binding;

    public PathFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPathBinding.inflate(inflater, container, false);
        ConstraintLayout layout1 = binding.frameLayout2;
        LienzoPath fondo = new LienzoPath(getContext());
        layout1.addView(fondo);
        return binding.getRoot();
    }
}