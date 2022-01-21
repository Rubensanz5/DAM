package com.example.gestion_empleados;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class Add extends Fragment {

	Button bAtras, bAdd;
	EditText apellidoInput, salarioInput;
	Spinner departamentoInput;
	FragmentTransaction transaction;
	Fragment fragmentoMenu;

	Context context;

	public Add() {
		// Required empty public constructor
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_add, container, false);
		transaction = getParentFragmentManager().beginTransaction();
		fragmentoMenu = new Menu();
		context = container.getContext();

		bAdd = view.findViewById(R.id.botonAddInAdd);
		bAtras = view.findViewById(R.id.botonVolverInAdd);
		apellidoInput = view.findViewById(R.id.editTextApellidoInModificar);
		departamentoInput = view.findViewById(R.id.spinner);



		ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.itemspinner, DataBaseEmpleados.LISTA_DEPARTAMENTOS);
		departamentoInput.setAdapter(adapter);
		salarioInput = view.findViewById(R.id.editTextSalarioInModificar);

		setListeners(view);
		return view;
	}

	public void setListeners(View v) {
		bAdd.setOnClickListener(view -> addEmpleado(view));
		bAtras.setOnClickListener(view -> irMenu(view));
		departamentoInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View view, boolean b) {
				bajarTeclado(view);
			}
		});

	}

	public void irMenu(View v) {
		transaction.replace(R.id.fragmentContainerView3, fragmentoMenu);
		transaction.addToBackStack(null);
		transaction.commit();
	}

	public void departamentoListener(View view) {
		bajarTeclado(view);
	}

	public void bajarTeclado(View view) {
		InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
	}

	private void addEmpleado(View v) {
		bajarTeclado(v);
		boolean success = false;
		DataBaseEmpleados db = new DataBaseEmpleados(context);
		try {
			if(!apellidoInput.getText().toString().isEmpty() && Double.parseDouble(salarioInput.getText().toString()) >= 0) {
				success = db.addEmpleado(apellidoInput.getText().toString().trim(),
						departamentoInput.getSelectedItem().toString().trim(),
						Double.parseDouble(salarioInput.getText().toString().trim()));
			} else {
				throw new Exception();
			}

			if(success) {
				Toast.makeText(context, "Empleado añadido", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(context, "Se ha producido un error", Toast.LENGTH_SHORT).show();
			}
		} catch (Exception e) {
			Toast.makeText(context, "Introduce los datos correctamente", Toast.LENGTH_SHORT).show();
		}

	}
}