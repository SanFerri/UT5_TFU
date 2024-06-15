package com.ada.olimpiadas.model;

import java.util.ArrayList;

public class Categoria {
    private String nombre;
    private ArrayList<Participante> participante;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Participante> getParticipante() {
        return participante;
    }

}
