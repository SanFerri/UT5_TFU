package com.ada.olimpiadas.model;
import java.util.ArrayList;

public class Equipo {
    private int id;
    private ArrayList<Participante> participantes;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void addParticipante(Participante participante) {
        this.participantes.add(participante);
    }

    public void removeParticipante(Participante participante) {
        this.participantes.remove(participante);
    }
}
