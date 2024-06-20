package com.ada.olimpiadas.repositories;

import com.ada.olimpiadas.models.TipoPuntaje;

public interface ITipoPuntajeRepository {

    public TipoPuntaje TipoPuntajePorModalidad(int modalidadId);

}
