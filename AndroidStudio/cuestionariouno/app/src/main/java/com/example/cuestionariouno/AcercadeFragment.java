package com.example.cuestionariouno;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cuestionariouno.databinding.FragmentAcercadeBinding;

public class AcercadeFragment extends Fragment {

    private FragmentAcercadeBinding binding;

    public AcercadeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    //    return inflater.inflate(R.layout.fragment_acercade, container, false);
        binding= FragmentAcercadeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}