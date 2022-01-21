package com.example.cuestionariouno;

import java.util.List;

public class Preguntas {
    private  String enunciado_pregunta;
    private List<String> opciones;

    public Preguntas(String texto_pregunta, List respuestas){
        enunciado_pregunta =texto_pregunta;
        opciones=respuestas;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public String getEnunciado_pregunta() {
        return enunciado_pregunta;
    }
}
