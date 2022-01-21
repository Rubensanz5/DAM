package com.example.miniproyecto;

import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miniproyecto.databinding.FragmentDibujarBinding;
import com.example.miniproyecto.databinding.FragmentPathBinding;


public class DibujarFragment extends Fragment {
    private FragmentDibujarBinding binding;
    CanvasDibujo fondo;
    //LienzoDibujar fondo;

    public DibujarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDibujarBinding.inflate(inflater, container, false);
        ConstraintLayout layout1 =binding.frameLayout3;
        fondo = new CanvasDibujo(getContext());
        layout1.addView(fondo);

        binding.azul.setOnClickListener(view -> fondo.paint.setColor(Color.BLUE));
        binding.rojo.setOnClickListener(view -> fondo.paint.setColor(Color.RED));
        binding.verde.setOnClickListener(view -> fondo.paint.setColor(Color.GREEN));

        /*fondo = new LienzoDibujar(getContext());
        layout1.addView(fondo);

        binding.azul.setOnClickListener(view -> fondo.mPaint.setColor(Color.BLUE));
        binding.rojo.setOnClickListener(view -> fondo.mPaint.setColor(Color.RED));
        binding.verde.setOnClickListener(view -> fondo.mPaint.setColor(Color.GREEN));*/


        return binding.getRoot();
    }



}