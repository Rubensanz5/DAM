package com.example.mirestaurante;

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

import com.example.mirestaurante.databinding.FragmentComidasBinding;


public class ComidasFragment extends Fragment {

    public ComidasFragment() {
        // Required empty public constructor
    }

    FragmentComidasBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentComidasBinding.inflate(getLayoutInflater());
        binding.botonConfirmarComida.setOnClickListener(v -> {
            ComidasFragmentDirections.ActionComidasFragmentToFinalFragment accion = ComidasFragmentDirections.actionComidasFragmentToFinalFragment("","60€");
            accion.setNombre(binding.editTextNombre.getText().toString());
            Navigation.findNavController(getView()).navigate(accion);
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
        if (item.getItemId() == R.id.quienesSomos) {
            Toast.makeText(getContext(), "Has accedido a Quienes somos...", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(getView()).navigate(R.id.quienesSomosFragment);
        } else if (item.getItemId() == R.id.valoracion) {
            Toast.makeText(getContext(), "Has accedido a valoración...", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(getView()).navigate(R.id.valoracionFragment);
        }
        return super.onOptionsItemSelected(item);
    }
}