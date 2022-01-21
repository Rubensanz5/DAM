package com.example.cuenta_atras;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int contador;
    public boolean pasar = true;
    Handler timer = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void restar (View vista){
         if (pasar) {
             EditText editTx = (EditText) findViewById(R.id.editTextTextPersonName);
             String texto = editTx.getText().toString();
             contador = Integer.parseInt(texto);
             pasar = false;
         }

        Button btn = findViewById(R.id.button);
         btn.setClickable(false);
         timer.postDelayed(new Runnable() {
             @Override
             public void run() {
                 if (contador > 0) {
                     contador--;
                     mostrar();
                     timer.postDelayed(this, 500);
                 } else {
                     try {
                         finalize();
                         btn.setClickable(true);
                     } catch (Throwable throwable) {
                         throwable.printStackTrace();
                     }
                 }

             }
         },500);

    }

    @SuppressLint("SetTextI18n")
    public void mostrar(){
        TextView resultado= (TextView) findViewById(R.id.Text);
        resultado.setText("Cuenta atrás: "+ contador);
    }

}