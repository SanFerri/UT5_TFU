package com.ada.olimpiadas.model;

import java.util.ArrayList;

public class Disciplina {
        private String nombre;
    private ArrayList<Modalidad> modalidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Modalidad> getModalidad() {
        return modalidad;
    }
}
