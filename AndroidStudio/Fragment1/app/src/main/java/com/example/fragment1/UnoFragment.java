package com.example.fragment1;

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

import com.example.fragment1.databinding.FragmentUnoBinding;

/*
 * A simple {@link Fragment} subclass.
 * Use the {@link UnoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UnoFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_uno, container, false);
        FragmentUnoBinding binding = FragmentUnoBinding.inflate(getLayoutInflater());
        binding.button.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_unoFragment_to_dosFragment));
        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.primer_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.fragmentFinal){
            Toast.makeText(getContext(), "Quieres ir al final, pero...", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.fragmentuno) {
            Toast.makeText(getContext(),"Ya estas en el inicio", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}