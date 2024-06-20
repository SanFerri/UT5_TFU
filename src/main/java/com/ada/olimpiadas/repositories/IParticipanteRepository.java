package com.ada.olimpiadas.repositories;

import java.util.LinkedList;
import com.ada.olimpiadas.models.Participante;

public interface IParticipanteRepository {

    public LinkedList<Participante> getParticipantes();

    public Participante getParticipante(int id);

    public LinkedList<Participante> getParticipantesPorModalidad(int modalidadId);

    public LinkedList<Participante> getParticipantesPorCategoria(int categoriaId);

    public LinkedList<Participante> getParticipantesPorEquipo(int equipoId);


}
