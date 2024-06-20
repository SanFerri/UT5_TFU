package com.ada.olimpiadas.repositories;

import java.util.LinkedList;

import com.ada.olimpiadas.models.Equipo;

public interface IEquipoRepository {

    public LinkedList<Equipo> getEquipos();

    public LinkedList<Equipo> getEquiposPorCategoria();

    public LinkedList<Equipo> getEquiposPorModalidad();

}
