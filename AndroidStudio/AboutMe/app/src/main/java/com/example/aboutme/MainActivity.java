package com.example.aboutme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aboutme.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void conNombre (View vista){

        Log.i("conNombre","prueba");
        EditText nombre = binding.editTextTextPersonName2;
        TextView total = binding.textView2;
        Button button= binding.button;


        total.setText(nombre.getText().toString()+ "\n" + total.getText().toString());


        nombre.setVisibility(View.GONE);
        button.setVisibility(View.GONE);

        Log.i("conNombre", total.getText().toString());
//        scrollView.bringToFront();
        esconderTeclado(vista);

    }
    //Nuestro primer método con referencias al sistema operativo Android
    public void esconderTeclado(View vista){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(vista.getWindowToken(), 0);
    }
}