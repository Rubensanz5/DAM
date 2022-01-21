package com.example.gestion_empleados;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class VerUno extends Fragment {

	FragmentTransaction transaction;
	Fragment fragmentVer;
	Context context;
	Button bAnterior, bSiguiente, bVolver;
	TextView textEmpleado;
	Cursor cursorEmpleados;

	public VerUno() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View vista = inflater.inflate(R.layout.fragment_ver_uno, container, false);
		transaction = getParentFragmentManager().beginTransaction();
		fragmentVer = new Ver();
		context = container.getContext();
		bAnterior = vista.findViewById(R.id.botonAnterior);
		bSiguiente = vista.findViewById(R.id.botonSiguiente);
		bVolver = vista.findViewById(R.id.botonVolverInVerUno);
		textEmpleado = vista.findViewById(R.id.textViewEmpleado);
		setListeners(vista);
		getCursor();
		return vista;
	}

	public void setListeners(View v) {
		bAnterior.setOnClickListener(view -> anteriorEmpleado());
		bSiguiente.setOnClickListener(view -> siguienteEmpleado());
		bVolver.setOnClickListener(view -> irMenuVer());
	}

	public void anteriorEmpleado() {
		if(cursorEmpleados.isFirst()) {
			cursorEmpleados.moveToLast();
		} else {
			cursorEmpleados.moveToPrevious();
		}
		setEmpleado(new Empleado(cursorEmpleados.getInt(0),
				cursorEmpleados.getString(1),
				cursorEmpleados.getString(2),
				cursorEmpleados.getDouble(3)));
	}

	public void siguienteEmpleado() {
		if(cursorEmpleados.isLast()) {
			cursorEmpleados.moveToFirst();
		} else {
			cursorEmpleados.moveToNext();
		}
		setEmpleado(new Empleado(cursorEmpleados.getInt(0),
				cursorEmpleados.getString(1),
				cursorEmpleados.getString(2),
				cursorEmpleados.getDouble(3)));
	}

	public void setEmpleado(Empleado empleado) {
		textEmpleado.setText(empleado.toString());
	}

	public void getCursor() {
		DataBaseEmpleados db = new DataBaseEmpleados(context);
		cursorEmpleados = db.getAllEmpleados();
		cursorEmpleados.moveToNext();
		if(cursorEmpleados.getCount() == 0) {
			textEmpleado.setText("No se han encontrado empleados");
			bAnterior.setVisibility(View.INVISIBLE);
			bSiguiente.setVisibility(View.INVISIBLE);
		} else {
			setEmpleado(new Empleado(cursorEmpleados.getInt(0),
					cursorEmpleados.getString(1),
					cursorEmpleados.getString(2),
					cursorEmpleados.getDouble(3)));
		}
	}

	public void irMenuVer() {
		transaction.replace(R.id.fragmentContainerView3, fragmentVer);
		transaction.addToBackStack(null);
		transaction.commit();

	}
}