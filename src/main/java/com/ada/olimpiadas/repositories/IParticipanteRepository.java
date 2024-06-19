package com.ada.olimpiadas.repositories;

import java.util.LinkedList;

import com.ada.olimpiadas.models.Juez;
import com.ada.olimpiadas.models.Participante;

public interface IParticipanteRepository {

    public LinkedList<Participante> getParticipantes();

    public Participante getParticipante(int id);

}
