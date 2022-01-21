package com.example.miniproyecto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.miniproyecto.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        binding.imagenRotada.setOnClickListener(v->{
            Navigation.findNavController(getView()).navigate(R.id.action_FirstFragment_to_SecondFragment);
        });
        binding.transicion.setOnClickListener(v->{
            Navigation.findNavController(getView()).navigate(R.id.action_FirstFragment_to_transicionFragment);
        });
        binding.TextoPath.setOnClickListener(v->{
            Navigation.findNavController(getView()).navigate(R.id.action_FirstFragment_to_pathFragment);
        });
        binding.Dibujar.setOnClickListener(v->{
            Navigation.findNavController(getView()).navigate(R.id.action_FirstFragment_to_dibujarFragment);
        });
        return binding.getRoot();

    }

}