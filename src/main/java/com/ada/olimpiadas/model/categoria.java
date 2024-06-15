package com.ada.olimpiadas.model;

public class Categoria {
    private String nombre;
    private Modalidad[] modalidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Modalidad[] getModalidad() {
        return modalidad;
    }

}
