package com.ada.olimpiadas.repositories;

import java.util.LinkedList;

import com.ada.olimpiadas.models.Puntaje;

public interface IPuntajeRepository {

    void guardarPuntaje(Puntaje puntaje);

    LinkedList<Puntaje> getCalificados();

}
