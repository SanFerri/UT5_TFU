package com.ada.olimpiadas.model;


public class Equipo {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;
    private String cedula;
    private String contacto;
    private Participante[] participantes;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}
