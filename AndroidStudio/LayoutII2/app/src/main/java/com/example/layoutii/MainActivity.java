package com.example.layoutii;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.layoutii.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ponerListeners();
    }

    public void cambioColor (View vista){
        binding.cajaCuadrada.setBackgroundColor(Color.parseColor("#7C04D8"));
    }

    public void ponerListeners(){
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Cambiare colores",Toast.LENGTH_LONG).show();
                binding.cajaCuadrada.setBackgroundColor(getResources().getColor(R.color.purple_200));
            }
        });

        binding.button3.setOnClickListener(v -> cambiarColorForndo(v));

    }

    public void cambiarColorForndo(View vista){
        binding.cajaCuadrada.setBackgroundColor(getResources().getColor(R.color.teal_700));
    }
}