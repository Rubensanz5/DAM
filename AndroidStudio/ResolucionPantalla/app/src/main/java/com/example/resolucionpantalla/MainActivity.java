package com.example.resolucionpantalla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.resolucionpantalla.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        resolucion();
    }

    public void resolucion(){
        DisplayMetrics metrica = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrica);
        int ancho = metrica.widthPixels;
        int alto= metrica.heightPixels;
        binding.info.setText("Your resolution is: " + alto + "x" + ancho);
    }
}