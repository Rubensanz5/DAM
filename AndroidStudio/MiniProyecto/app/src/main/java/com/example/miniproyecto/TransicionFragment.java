package com.example.miniproyecto;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.miniproyecto.databinding.FragmentSecondBinding;
import com.example.miniproyecto.databinding.FragmentTransicionBinding;

public class TransicionFragment extends Fragment {
    ImageView imageView;
    Button button;
    Boolean turnedOn = false;
    private FragmentTransicionBinding binding;

    public TransicionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTransicionBinding.inflate(inflater, container, false);
        imageView = binding.imageView;
        button = binding.button;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!turnedOn) {
                    imageView.setImageResource(R.drawable.trans_on);
                    ((TransitionDrawable)
                            imageView.getDrawable()).startTransition(1000);
                    turnedOn = true;
                } else {
                    imageView.setImageResource(R.drawable.trans_off);
                    ((TransitionDrawable)
                            imageView.getDrawable()).startTransition(1000);
                    turnedOn = false;
                }
            }
        });
        return binding.getRoot();
    }
}




