package com.ada.olimpiadas.model;
import java.util.ArrayList;

public class Modalidad {
    private String nombre;
    private Juez juez;
    private ArrayList<Categoria> categorias;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Juez getJuez() {
        return juez;
    }

    public void setJuez(Juez juez) {
        this.juez = juez;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void addCategoria(Categoria categoria) {
        this.categorias.add(categoria);
    }

    public void removeCategoria(Categoria categoria) {
        this.categorias.remove(categoria);
    }
}
