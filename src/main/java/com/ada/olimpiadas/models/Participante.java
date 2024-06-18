package com.ada.olimpiadas.models;

public class Participante {
    private int id;
    private String ci;
    private int edad;
    private int peso;
    private int modalidadId;

    public Participante(int id, String ci, int edad, int peso, int modalidadId) {
        this.id = id;
        this.ci = ci;
        this.edad = edad;
        this.peso = peso;
        this.modalidadId = modalidadId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getModalidadId() {
        return modalidadId;
    }

    public void setModalidadId(int modalidadId) {
        this.modalidadId = modalidadId;
    }
}
