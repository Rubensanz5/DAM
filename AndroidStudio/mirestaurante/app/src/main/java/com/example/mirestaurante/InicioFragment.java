package com.example.mirestaurante;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mirestaurante.databinding.FragmentInicioBinding;

public class InicioFragment extends Fragment {
    private FragmentInicioBinding fragmentInicioBinding;
    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentInicioBinding=FragmentInicioBinding.inflate(getLayoutInflater());
        fragmentInicioBinding.botonInicio.setOnClickListener(v->{
            int seleccion = fragmentInicioBinding.radioGroup.getCheckedRadioButtonId();
            if(seleccion == R.id.radioCena){
                fragmentInicioBinding.botonInicio.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_inicioFragment_to_cenasFragment));
            } else if(seleccion == R.id.radioComida) {
                fragmentInicioBinding.botonInicio.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_inicioFragment_to_comidasFragment));
            }
        });
        return fragmentInicioBinding.getRoot();

    }
}