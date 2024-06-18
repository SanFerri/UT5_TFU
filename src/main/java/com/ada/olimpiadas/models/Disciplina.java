package com.ada.olimpiadas.models;

public class Disciplina {

    private String nombre;
    private int id;

    public String getNombre() {
        return nombre;
    }

    public Disciplina(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
