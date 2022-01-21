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

import com.example.rubensanz_6.databinding.FragmentBienvenidaBinding;

public class BienvenidaFragment extends Fragment {

    public BienvenidaFragment() {
        // Required empty public constructor
    }
    FragmentBienvenidaBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBienvenidaBinding.inflate(inflater);

        binding.buttonIni.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_bienvenidaFragment_to_categoriasFragment));

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