package com.ada.olimpiadas.repositories;

import java.util.LinkedList;

import com.ada.olimpiadas.models.Categoria;

public interface ICategoriaRepository {

    public LinkedList<Categoria> getCategorias();

    public Categoria getCategoria(int id);

}
