package com.example.layouti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void anadir(View vista){
        EditText nombre = (EditText) findViewById(R.id.editTextTextPersonName);
        String nombre1 = nombre.getText().toString();

        Button btn = findViewById(R.id.button);
        btn.setVisibility(View.GONE);

        EditText eText = findViewById(R.id.editTextTextPersonName);
        eText.setVisibility(View.GONE);

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(eText.getWindowToken(), 0);
        //imm.hideSoftInputFromWindow(vista.getWindowToken(), 0);

        TextView resultado= (TextView) findViewById(R.id.textView2);
        resultado.setText(nombre1 + "\n" + resultado.getText().toString());
    }

}