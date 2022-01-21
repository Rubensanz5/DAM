package com.example.gestion_empleados;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Menu extends Fragment {


    FragmentTransaction transaction;
    Fragment fragmentoBuscar, fragmentoVer, fragmentoAdd, fragmentoModificar, fragmentoEliminar;
    Button botonBusacar, botonVer, botonAdd, botonModificar, botonEliminar;

    public Menu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View vista = inflater.inflate(R.layout.fragment_menu, container, false);
        fragmentoBuscar = new Buscar();
        fragmentoVer = new Ver();
        fragmentoAdd = new Add();
        fragmentoModificar = new Modificar();
        fragmentoEliminar = new Eliminar();

        transaction = getParentFragmentManager().beginTransaction();

        botonBusacar = vista.findViewById(R.id.botonBuscar);
        botonBusacar.setOnClickListener(view -> irMenuBuscar(view));

        botonVer = vista.findViewById(R.id.botonVer);
        botonVer.setOnClickListener(view -> irMenuVer(view));

        botonAdd = vista.findViewById(R.id.botonAdd);
        botonAdd.setOnClickListener(view -> irMenuAdd(view));

        botonModificar = vista.findViewById(R.id.botonModificar);
        botonModificar.setOnClickListener(view -> irMenuModificar(view));

        botonEliminar = vista.findViewById(R.id.botonEliminar);
        botonEliminar.setOnClickListener(view -> irMenuEliminar());

        return vista;
    }

    public void irMenuBuscar(View v) {
        desactivarBotones();
        transaction.replace(R.id.fragmentContainerView3, fragmentoBuscar);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void irMenuVer(View v) {
        desactivarBotones();
        transaction.replace(R.id.fragmentContainerView3, fragmentoVer);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void irMenuAdd(View v) {
        desactivarBotones();
        transaction.replace(R.id.fragmentContainerView3, fragmentoAdd);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void irMenuModificar(View v) {
        desactivarBotones();
        transaction.replace(R.id.fragmentContainerView3, fragmentoModificar);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void irMenuEliminar() {
        desactivarBotones();
        transaction.replace(R.id.fragmentContainerView3, fragmentoEliminar);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void desactivarBotones() {

        botonAdd.setEnabled(false);
        botonBusacar.setEnabled(false);
        botonModificar.setEnabled(false);
        botonVer.setEnabled(false);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}