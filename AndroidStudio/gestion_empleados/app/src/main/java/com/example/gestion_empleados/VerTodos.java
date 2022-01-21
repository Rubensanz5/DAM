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

import java.util.ArrayList;


public class VerTodos extends Fragment {

	FragmentTransaction transaction;
	Fragment fragmentoVer;
	Context context;
	Button bVolver;
	TextView textViewTodos;
	public VerTodos() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View vista = inflater.inflate(R.layout.fragment_ver_todos, container, false);

		transaction = getParentFragmentManager().beginTransaction();
		fragmentoVer = new Ver();
		context = container.getContext();
		bVolver = vista.findViewById(R.id.botonVolverInVerTodos);
		textViewTodos = vista.findViewById(R.id.textViewVerTodos);
		setListEmpleados();
		setListeners(vista);
		return vista;
	}

	public void setListeners(View v) {
		bVolver.setOnClickListener(view -> irVer(view));
	}

	public void setListEmpleados() {
		DataBaseEmpleados db = new DataBaseEmpleados(context);
		Cursor cursor = db.getAllEmpleados();
		ArrayList<Empleado> empleados = new ArrayList<>();
		while(cursor.moveToNext()) {
			empleados.add(new Empleado(cursor.getInt(0),
					cursor.getString(1),
					cursor.getString(2),
					cursor.getDouble(3)));
		}
		String emps = "";
		for (Empleado em : empleados) {
			emps += em.toString() + "\n\n";
		}
		if(emps.isEmpty()) {
			textViewTodos.setText("No se han encontrado empleados");
		} else {
			textViewTodos.setText(emps);
		}

	}

	public void irVer(View view) {
		transaction.replace(R.id.fragmentContainerView3, fragmentoVer);
		transaction.addToBackStack(null);
		transaction.commit();
	}
}