package com.ada.olimpiadas.models;

public class Persona {
    private int ci;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;

    public int getId() {
        return ci;
    }

    public void setId(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCampeon() {
        return campeon;
    }

    public void setCampeon(String campeon) {
        this.campeon = campeon;
    }

    public String getSubcampeon() {
        return subcampeon;
    }

    public void setSubcampeon(String subcampeon) {
        this.subcampeon = subcampeon;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    private String campeon;
    private String subcampeon;
    private String carrera;
}
