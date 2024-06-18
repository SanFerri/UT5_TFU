package com.ada.olimpiadas.repositories;

import java.util.LinkedList;

import com.ada.olimpiadas.models.Juez;
import com.ada.olimpiadas.models.Participante;

public interface IJuezRepositorie {

    public LinkedList<Juez> getJueces();

    public Juez getJuez(int id);

    public boolean Puntuar();

    public LinkedList<Participante> getParticipantes();

    public Participante getParticipante(int id);

}
