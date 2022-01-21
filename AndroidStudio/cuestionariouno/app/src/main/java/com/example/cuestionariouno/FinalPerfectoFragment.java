package com.example.cuestionariouno;

import android.content.Intent;
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

import com.example.cuestionariouno.databinding.FragmentFinalPerfectoBinding;
import com.example.cuestionariouno.databinding.FragmentInicioBinding;

public class FinalPerfectoFragment extends Fragment {

    public FinalPerfectoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_final_perfecto, container, false);
        FragmentFinalPerfectoBinding binding = FragmentFinalPerfectoBinding.inflate(getLayoutInflater());
        binding.acertar3.setText(binding.acertar3.getText() + FinalErroresFragmentArgs.fromBundle(getArguments()).getNombre());
        binding.buttonInicio2.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_finalPerfectoFragment_to_inicioFragment));
        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.compartir, menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item){
      if(item.getItemId() == R.id.BtCompartir) {
          compartirPerfecto();
      }
        return super.onOptionsItemSelected(item);
    }

    private Intent compartirIntent(){
        String nombre = FinalPerfectoFragmentArgs.fromBundle(getArguments()).getNombre();
        Intent intentCompartido = new Intent(Intent.ACTION_SEND);
        intentCompartido.setType("text/plain").putExtra(Intent.EXTRA_TEXT,nombre + "\n" + "Respuesta Correcta!");
        return intentCompartido;
    }

    private void compartirPerfecto(){
        startActivity(compartirIntent());
    }
}