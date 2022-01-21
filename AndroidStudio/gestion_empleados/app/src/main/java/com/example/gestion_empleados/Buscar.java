package com.example.gestion_empleados;

import android.content.Context;
import android.database.Cursor;
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

import java.util.ArrayList;


public class Buscar extends Fragment {

    Button bAtras, bBuscar;
    TextView infoEmpleado, textIntroducirId;
    EditText editTextId;
    FragmentTransaction transaction;
    Fragment fragmentoMenu;
    Context context;
    ArrayList<Empleado> empleados = new ArrayList<>();
    public Buscar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buscar, container, false);
        bAtras = view.findViewById(R.id.botonAtrasInBuscar);
        bBuscar = view.findViewById(R.id.botonBuscarId);
        infoEmpleado = view.findViewById(R.id.textEmpleadoBuscar);
        textIntroducirId = view.findViewById(R.id.textIntroducirId);
        editTextId = view.findViewById(R.id.editTextIdEmpleado);
        context = container.getContext();
        fragmentoMenu = new Menu();
        transaction = getParentFragmentManager().beginTransaction();
        setListeners(view);
        setEmpleados();
        return view;
    }

    public void setListeners(View v) {
        bAtras.setOnClickListener(view -> irMenu(view));
        bBuscar.setOnClickListener(view -> mostrarInfo(view));
    }

    public void mostrarInfo(View view) {
        String idText = editTextId.getText().toString();
        if (idText.isEmpty()) {
            infoEmpleado.setVisibility(View.VISIBLE);
            infoEmpleado.setText("No has introducido ningún ID");
            infoEmpleado.setTextColor(getResources().getColor(R.color.redSelec));
        } else {
            bajarTeclado(view);
            Empleado empleado = buscarEmpleado(Integer.parseInt(idText));
            infoEmpleado.setVisibility(View.VISIBLE);
            if(empleado == null) {
                infoEmpleado.setText("El empleado no existe");
                infoEmpleado.setTextColor(getResources().getColor(R.color.redSelec));
            } else {
                infoEmpleado.setTextColor(getResources().getColor(R.color.white));
                infoEmpleado.setText(empleado.toString());
            }
        }
    }

    public Empleado buscarEmpleado(int id) {
        DataBaseEmpleados db = new DataBaseEmpleados(context);
        Empleado empleado = db.getEmpleado(id);
        return empleado;
    }

    public void setEmpleados() {
        DataBaseEmpleados db = new DataBaseEmpleados(context);
        Cursor cursor = db.getAllEmpleados();
        if(cursor.getCount() == 0) {
            textIntroducirId.setVisibility(View.INVISIBLE);
            editTextId.setVisibility(View.INVISIBLE);
            bBuscar.setVisibility(View.INVISIBLE);
            infoEmpleado.setVisibility(View.VISIBLE);
            infoEmpleado.setText("No hay empleados");
        } else {
            while(cursor.moveToNext()) {
                empleados.add(new Empleado(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getDouble(3)));
            }
        }
    }

    public void bajarTeclado(View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void irMenu(View v) {
        transaction.replace(R.id.fragmentContainerView3, fragmentoMenu);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}