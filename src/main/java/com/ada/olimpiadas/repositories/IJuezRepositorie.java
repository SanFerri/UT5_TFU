package com.ada.olimpiadas.repositories;

import java.util.LinkedList;

import com.ada.olimpiadas.models.Juez;

public interface IJuezRepositorie {

    public LinkedList<Juez> getJueces();

    public Juez getJuez(int id);

    public boolean Puntuar();

}
