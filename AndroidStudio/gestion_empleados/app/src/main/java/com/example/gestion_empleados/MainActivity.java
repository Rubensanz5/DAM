package com.example.gestion_empleados;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gestion_empleados.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MainActivity extends AppCompatActivity {
    
    public static final String RUTA_EMPLEADOS = "/empleados/empleados.dat";

    public static final int LONGITUD_REGISTRO = 72;

    public RandomAccessFile fileRandom;

    ActivityMainBinding binding;
    FragmentTransaction transaction;
    Fragment fragmentoMenu, fragmentoBuscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

    }

    public void setOnClickListener() {

    }
    
    public RandomAccessFile setRandomAcessFile() {

        File fichero = new File(getFilesDir(), RUTA_EMPLEADOS);
        RandomAccessFile fileR = null;
        if (!fichero.exists() || fichero.length() == 0) {
            new File(fichero.getParent()).mkdir();
            try {
                fichero.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileR = new RandomAccessFile(fichero, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, fichero.getAbsolutePath(), Toast.LENGTH_LONG);

        return fileR;
    }


}