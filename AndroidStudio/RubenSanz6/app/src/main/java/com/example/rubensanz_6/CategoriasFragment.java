package com.example.rubensanz_6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rubensanz_6.databinding.FragmentCategoriasBinding;

public class CategoriasFragment extends Fragment {
    public CategoriasFragment() {
        // Required empty public constructor
    }
    FragmentCategoriasBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoriasBinding.inflate(inflater);
        binding.btnSeleccionar.setOnClickListener(v->{
            int seleccion = binding.radioGroup.getCheckedRadioButtonId();
            if(seleccion == R.id.radioBtnCarretera){
                binding.btnSeleccionar.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_categoriasFragment_to_motoCarreteraFragment));
            } else if(seleccion == R.id.radioBtnCross) {
                binding.btnSeleccionar.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_categoriasFragment_to_motoCampoFragment));
            }
        });

        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.AcercaDe){
            Toast.makeText(getContext(), "A Cerca De...", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(getView()).navigate(R.id.acercadeFragment);
        }
        return super.onOptionsItemSelected(item);
    }
}