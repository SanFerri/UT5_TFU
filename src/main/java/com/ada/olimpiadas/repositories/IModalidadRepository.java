package com.ada.olimpiadas.repositories;

import java.util.LinkedList;

import com.ada.olimpiadas.models.Modalidad;

public interface IModalidadRepository {

    public LinkedList<Modalidad> getModalidades();

    public Modalidad getModalidad(int id);

}
