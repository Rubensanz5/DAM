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

//import com.example.fragment1.databinding.FragmentDosBinding;
import com.example.fragment1.databinding.FragmentFinalBinding;

/*
 * A simple {@link Fragment} subclass.
 * Use the {@link finalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class finalFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_final, container, false);

        FragmentFinalBinding binding = FragmentFinalBinding.inflate(getLayoutInflater());
        binding.button3.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_finalFragment_to_unoFragment));
        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menufinal, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.vueltaDos){
            Navigation.findNavController(getView()).navigate(R.id.action_finalFragment_to_dosFragment);
        }
        return super.onOptionsItemSelected(item);
    }
}