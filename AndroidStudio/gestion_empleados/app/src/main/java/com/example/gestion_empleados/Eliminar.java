package com.example.gestion_empleados;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Eliminar extends Fragment {

    FragmentTransaction transaction;
    Fragment fragmentMenu;
    EditText editTextId;
    TextView infoEmpleado;
    Button bEliminar, bVolver, bBuscar;
    Context context;

    public Eliminar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentMenu = new Menu();
        transaction = getParentFragmentManager().beginTransaction();
        context = container.getContext();
        View vista = inflater.inflate(R.layout.fragment_eliminar, container, false);;
        editTextId = vista.findViewById(R.id.editTextTextIdInEliminar);
        infoEmpleado = vista.findViewById(R.id.infoEmpleadoEliminar);
        bEliminar = vista.findViewById(R.id.botonEliminarInEliminar);
        bVolver = vista.findViewById(R.id.botonVolverInEliminar);
        bBuscar = vista.findViewById(R.id.botonBuscarInEliminar);
        setListeners(vista);
        return vista;
    }

    public void setListeners(View view) {
        bBuscar.setOnClickListener(v -> mostrarInfoEmpleado(v));
        bVolver.setOnClickListener(v -> volverMenu());
        bEliminar.setOnClickListener(v -> eliminarEmpleado(v));
    }


    public Empleado mostrarInfoEmpleado(View v) {
        bajarTeclado(v);
        Empleado empleado = null;
        DataBaseEmpleados db = new DataBaseEmpleados(context);
        infoEmpleado.setVisibility(View.VISIBLE);
        if (!editTextId.getText().toString().isEmpty()) {
            empleado = db.getEmpleado(Integer.parseInt(editTextId.getText().toString()));
            if(empleado != null) {
                infoEmpleado.setText(empleado.toString());
            } else {
                infoEmpleado.setText("No existe el empleado");
            }

        } else {
            infoEmpleado.setText("No has ingresado ningún ID");
        }
        return empleado;
    }

    public void eliminarEmpleado(View v) {
        DataBaseEmpleados db = new DataBaseEmpleados(context);
        Empleado empleado = mostrarInfoEmpleado(v);
        boolean eliminado = false;
        if (empleado != null) {
            eliminado = db.eliminarEmpleado(empleado.getId());
        }
        if(eliminado) {
            Toast.makeText(context, "Se ha eliminado al empleado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "El empleado no ha sido eliminado", Toast.LENGTH_SHORT).show();
        }
        editTextId.setText("");
        infoEmpleado.setVisibility(View.INVISIBLE);
    }

    public void volverMenu() {
        transaction.replace(R.id.fragmentContainerView3, fragmentMenu);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void bajarTeclado(View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}