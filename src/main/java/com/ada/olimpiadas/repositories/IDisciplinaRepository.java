package com.ada.olimpiadas.repositories;

import java.util.LinkedList;

import com.ada.olimpiadas.models.Disciplina;

public interface IDisciplinaRepository {

    public LinkedList<Disciplina> getDisciplinas();

    public Disciplina getDisciplina(int id);

}
