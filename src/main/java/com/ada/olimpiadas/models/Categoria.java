package com.ada.olimpiadas.models;

public class Categoria {
    private int id;
    private int idModalidad;
    private String sexo;
    private int tamanoGrupo;
    private int edadInicio;
    private int pesoInicio;
    private int pesoFin;

    public Categoria(int id, int idModalidad, String sexo, int tamanoGrupo, int edadInicio, int edadFin,
            int pesoInicio, int pesoFin) {
        this.id = id;
        this.idModalidad = idModalidad;
        this.sexo = sexo;
        this.tamanoGrupo = tamanoGrupo;
        this.edadInicio = edadInicio;
        this.edadFin = edadFin;
        this.pesoInicio = pesoInicio;
        this.pesoFin = pesoFin;
    }

    private int edadFin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(int idModalidad) {
        this.idModalidad = idModalidad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getTamanoGrupo() {
        return tamanoGrupo;
    }

    public void setTamanoGrupo(int tamanoGrupo) {
        this.tamanoGrupo = tamanoGrupo;
    }

    public int getEdadInicio() {
        return edadInicio;
    }

    public void setEdadInicio(int edadInicio) {
        this.edadInicio = edadInicio;
    }

    public int getEdadFin() {
        return edadFin;
    }

    public void setEdadFin(int edadFin) {
        this.edadFin = edadFin;
    }

    public double getPesoInicio() {
        return pesoInicio;
    }

    public void setPesoInicio(int pesoInicio) {
        this.pesoInicio = pesoInicio;
    }

    public double getPesoFin() {
        return pesoFin;
    }

    public void setPesoFin(int pesoFin) {
        this.pesoFin = pesoFin;
    }

}
