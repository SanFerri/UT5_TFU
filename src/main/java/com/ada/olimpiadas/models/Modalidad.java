package com.ada.olimpiadas.models;

public class Modalidad {

    private int id;
    private String nombre;
    private int disciplina_id;
    private int puntaje_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDisciplina_id() {
        return disciplina_id;
    }

    public void setDisciplina_id(int disciplina_id) {
        this.disciplina_id = disciplina_id;
    }

    public int getPuntaje_id() {
        return puntaje_id;
    }

    public void setPuntaje_id(int puntaje_id) {
        this.puntaje_id = puntaje_id;
    }


}
