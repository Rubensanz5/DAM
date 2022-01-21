package com.example.gestion_empleados;

import android.content.Context;
import android.os.Bundle;

import androidx.core.view.ScrollingView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Ver extends Fragment {

    Button bAtras, bTodos, bUnoAuno;
    ScrollingView scrollView;
    FragmentTransaction transaction;
    Fragment fragmentoMenu;
    Fragment fragmentoVerTodos;
    Fragment fragmentoVerUno;

    Context context;

    public Ver() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_ver, container, false);
        fragmentoMenu = new Menu();
        fragmentoVerTodos = new VerTodos();
        fragmentoVerUno = new VerUno();
        transaction = getParentFragmentManager().beginTransaction();
        context = container.getContext();

        bAtras = vista.findViewById(R.id.botonAtrasInVer);


        bUnoAuno = vista.findViewById(R.id.botonUnoAuno);

        bTodos = vista.findViewById(R.id.botonTodos);
        setListeners(vista);

        return vista;
    }

    public void setListeners(View v) {
        bAtras.setOnClickListener(view -> irMenu(view));
        bTodos.setOnClickListener(view -> irVerTodos(view));
        bUnoAuno.setOnClickListener(view -> irVerUno());
    }

    public void irMenu(View v) {
        transaction.replace(R.id.fragmentContainerView3, fragmentoMenu);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void irVerTodos(View v) {
        transaction.replace(R.id.fragmentContainerView3, fragmentoVerTodos);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void irVerUno() {
        transaction.replace(R.id.fragmentContainerView3, fragmentoVerUno);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}