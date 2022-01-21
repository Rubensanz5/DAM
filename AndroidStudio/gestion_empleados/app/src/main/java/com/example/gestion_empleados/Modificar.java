package com.example.gestion_empleados;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.InputType;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Modificar extends Fragment {

	Button bAtras;
	Button bModificar;
	Button bBuscar;
	EditText editTextId, editTextApellido, editTextSalario;
	Spinner departamentoInput;
	FragmentTransaction transaction;
	Fragment fragmentoMenu;
	Context context;

	public Modificar() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_modificar, container, false);
		fragmentoMenu = new Menu();
		transaction = getParentFragmentManager().beginTransaction();
		context = container.getContext();

		editTextId = view.findViewById(R.id.editTextIdInModificar);
		editTextApellido = view.findViewById(R.id.editTextApellidoInModificar);
		editTextSalario = view.findViewById(R.id.editTextSalarioInModificar);
		departamentoInput = view.findViewById(R.id.spinner2);
		bBuscar = view.findViewById(R.id.botonBuscarInModificar);
		bAtras = view.findViewById(R.id.botonVolverInModificar);
		bModificar = view.findViewById(R.id.botonModificarInModificar);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.itemspinner, DataBaseEmpleados.LISTA_DEPARTAMENTOS);
		departamentoInput.setAdapter(adapter);
		departamentoInput.setEnabled(false);
		setListeners();

		return view;
	}

	public void setListeners() {
		bAtras.setOnClickListener(view -> irMenu(view));
		bBuscar.setOnClickListener(view -> rellenarCampos(view));
		bModificar.setOnClickListener(view -> modificarEmpleado());
	}

	public void rellenarCampos(View v) {
		bajarTeclado(v);
		DataBaseEmpleados db = new DataBaseEmpleados(context);
		if (!editTextId.getText().toString().isEmpty()) {
			Empleado empleado = db.getEmpleado(Integer.parseInt(editTextId.getText().toString()));
			if (empleado != null) {
				editTextApellido.setEnabled(true);
				editTextApellido.setText(empleado.getApellido());
				departamentoInput.setEnabled(true);
				departamentoInput.setSelection(departamentoEmpleado(empleado.getDepartamento()));
				editTextSalario.setEnabled(true);
				editTextSalario.setText(Double.toString(empleado.getSalario()));
			} else {
				editTextApellido.setText("");
				departamentoInput.setEnabled(false);
				editTextSalario.setText("");
			}

		}

	}

	public void modificarEmpleado() {
		boolean modificado = false;
		if (!editTextId.getText().toString().isEmpty() &&
				!editTextApellido.getText().toString().isEmpty()
				&& !editTextSalario.getText().toString().isEmpty()) {
			DataBaseEmpleados db = new DataBaseEmpleados(context);
			modificado = db.modificarEmpleado(new Empleado(Integer.parseInt(editTextId.getText().toString()),
					editTextApellido.getText().toString(),
					DataBaseEmpleados.LISTA_DEPARTAMENTOS[departamentoInput.getSelectedItemPosition()],
					Double.parseDouble(editTextSalario.getText().toString())));
		}
		if (modificado) {
			Toast.makeText(context, "Se ha modificado el empleado", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(context, "Ingresa los campos correctamente", Toast.LENGTH_SHORT).show();
		}
	}

	public int departamentoEmpleado(String departamento) {
		int nDepartamento = 6;
		for (int i = 0; i < DataBaseEmpleados.LISTA_DEPARTAMENTOS.length; i++) {
			if (departamento.equals(DataBaseEmpleados.LISTA_DEPARTAMENTOS[i])) {
				nDepartamento = i;
			}
		}
		return nDepartamento;
	}

	public void irMenu(View v) {
		transaction.replace(R.id.fragmentContainerView3, fragmentoMenu);
		transaction.addToBackStack(null);
		transaction.commit();
	}

	public void bajarTeclado(View view) {
		InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
	}
}