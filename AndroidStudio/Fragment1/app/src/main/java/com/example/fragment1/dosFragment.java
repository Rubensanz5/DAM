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

import com.example.fragment1.databinding.FragmentDosBinding;

/*
 * A simple {@link Fragment} subclass.
 * Use the {@link dosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class dosFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_dos, container, false);
        FragmentDosBinding binding = FragmentDosBinding.inflate(getLayoutInflater());
        binding.textView3.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_dosFragment_to_unoFragment));
        binding.button2.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_dosFragment_to_finalFragment));
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
        if(item.getItemId() == R.id.fragmentuno){
            Navigation.findNavController(getView()).navigate(R.id.action_dosFragment_to_unoFragment);
        } else if (item.getItemId() == R.id.fragmentFinal) {
            Navigation.findNavController(getView()).navigate(R.id.action_dosFragment_to_finalFragment);        }
        return super.onOptionsItemSelected(item);
    }
}