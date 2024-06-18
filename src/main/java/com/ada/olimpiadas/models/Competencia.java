package com.ada.olimpiadas.models;

import java.sql.*;

public class Competencia {
    private int id;
    private String nombre;
    private int idModalidad;
    private int idCategoria;
    private Date fecha;
    private Time hora;
    private String lugar;

    public Competencia(int id, String nombre, int idModalidad, int idCategoria, Date fecha, Time hora, String lugar) {
        this.id = id;
        this.nombre = nombre;
        this.idModalidad = idModalidad;
        this.idCategoria = idCategoria;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
    }

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

    public int getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(int idModalidad) {
        this.idModalidad = idModalidad;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
