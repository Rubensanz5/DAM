package com.example.cuestionariouno;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cuestionariouno.databinding.FragmentCuestionarioBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CuestionarioFragment extends Fragment {
    private FragmentCuestionarioBinding binding;
    private ArrayList<Preguntas> preguntas;
    private Preguntas preguntaActual;

    private List<String> respuestasActuales;
    private int questionIndex = 0;
    private int numQuestions;
    private int opcionIndex=0;
    public CuestionarioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCuestionarioBinding.inflate(getLayoutInflater());
        setHasOptionsMenu(true);

        preguntas= new ArrayList<Preguntas>();
        preguntas.add(new Preguntas("¿Qué es un binding?", Arrays.asList("un enlace a diseño", "una clase", "un método", "a saber...")));
        preguntas.add(new Preguntas("¿Descansarás este finde semana?", Arrays.asList("Sí", "No", "Probablemente", "No sé")));
        preguntas.add(new Preguntas("¿Programarás este finde?", Arrays.asList("No", "Sí", "Probablemente", "No sé")));

        numQuestions = preguntas.size();
        preguntaActual= preguntas.get(0);

        questionIndex=0;
        binding.botonAceptar.setOnClickListener(v->{

            int radio_seleccion = binding.radioGroupRespuestas.getCheckedRadioButtonId();
            // Si no tiene nada seleccionado no hacemos nada (id == -1)
            if (-1 != radio_seleccion) {
                //no tenemos en cuanta el caso 0 porque está inicializada a cero optionIndex.
                switch (radio_seleccion) {
                    case R.id.radio_2:
                        opcionIndex = 1;
                    case R.id.radio_3:
                        opcionIndex = 2;
                    case R.id.radio_4:
                        opcionIndex = 3;
                }
                // Para facilitar la lógica, la respuesta correcta siempre será la primera de las opciones
                // y a la primera que se falle se acaba el test y nos vamos a la pantalla de error
                if (preguntas.get(questionIndex).getOpciones().get(opcionIndex) == preguntaActual.getOpciones().get(0)) {
                    // Avanzamos a la siguiente pregunta
                    questionIndex++;
                    if (questionIndex < numQuestions) {
                        preguntaActual = preguntas.get(questionIndex);
                        actualizaPregunta();

                    } else {
                        // Por aquí sólo pasamos si se acierta todas las preguntas
                        Navigation.findNavController(getView()).navigate(CuestionarioFragmentDirections.
                                actionCuestionarioFragmentToFinalPerfectoFragment(binding.nombre.getText().toString()));
                    }
                } else {
                    opcionIndex=0;
                    questionIndex=0;
                    Navigation.findNavController(getView()).navigate(CuestionarioFragmentDirections.
                            actionCuestionarioFragmentToFinalErroresFragment(binding.nombre.getText().toString()));
                }
            }
        });

        return binding.getRoot();
    }

        // Actualizamos las preguntas sólo cambiamos la parte visual de la pantalla.
        private void actualizaPregunta() {
            preguntaActual = preguntas.get(questionIndex);
            binding.textPregunta.setText(preguntaActual.getEnunciado_pregunta());

            binding.radio1.setText(preguntaActual.getOpciones().get(0));
            binding.radio2.setText(preguntaActual.getOpciones().get(1));
            binding.radio3.setText(preguntaActual.getOpciones().get(2));
            binding.radio4.setText(preguntaActual.getOpciones().get(3));
            //Para acceder al ActionBar tenemos que irnos a la activity y hacer que sea AppCompatActivity para acceder
            // al actionBar.
            FragmentActivity esteFragment= this.getActivity();
            ActionBar actionbar= ((AppCompatActivity)esteFragment).getSupportActionBar();
            if (actionbar!= null) {
                actionbar.setTitle("Preguntas " + questionIndex + "/" + numQuestions);
            }
        }

        @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu1, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.ACercaDe){
            Toast.makeText(getContext(), "A Cerca De...", Toast.LENGTH_SHORT).show();
           //  Navigation.findNavController(getView()).navigate(R.id.action_cuestionarioFragment_to_acercadeFragment);
            Navigation.findNavController(getView()).navigate(R.id.acercadeFragment);
        } else if(item.getItemId() == R.id.contactoFragment){
            Toast.makeText(getContext(), "Contacto...", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(getView()).navigate(R.id.contactoFragment);
        }
        return super.onOptionsItemSelected(item);
    }
}