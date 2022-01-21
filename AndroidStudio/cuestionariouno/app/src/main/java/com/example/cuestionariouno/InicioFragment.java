package com.example.cuestionariouno;

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

import com.example.cuestionariouno.databinding.FragmentInicioBinding;

public class InicioFragment extends Fragment {

    private FragmentInicioBinding binding;
    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstan0ceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_inicio, container, false);
        binding = FragmentInicioBinding.inflate(getLayoutInflater());
        binding.button.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_inicioFragment_to_cuestionarioFragment));
        setHasOptionsMenu(true);
        return binding.getRoot();
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu1, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(item.getItemId() == R.id.ACercaDe){
                Toast.makeText(getContext(), "A Cerca De...", Toast.LENGTH_SHORT).show();
                //Navigation.findNavController(getView()).navigate(R.id.action_inicioFragment_to_acercadeFragment);
                Navigation.findNavController(getView()).navigate(R.id.acercadeFragment);
            } else if(item.getItemId() == R.id.contactoFragment){
                Toast.makeText(getContext(), "Contacto...", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(getView()).navigate(R.id.contactoFragment);
            }
        return super.onOptionsItemSelected(item);
    }
}