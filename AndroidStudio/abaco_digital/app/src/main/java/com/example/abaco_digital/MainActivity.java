package com.example.abaco_digital;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.abaco_digital.databinding.ActivityMainBinding;



public class MainActivity extends Activity {

    public int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador=0;
    }
    public void sumar(View vista){
        contador++;
        mostrar();

    }
    public void mostrar(){
        TextView resultado=(TextView)  findViewById(R.id.Contador);
        resultado.setText("Contador: "+ contador);
    }


}