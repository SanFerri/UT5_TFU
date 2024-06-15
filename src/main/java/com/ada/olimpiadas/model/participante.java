package com.ada.olimpiadas.model;

import java.util.ArrayList;

public class Participante implements IPersona {
    private ArrayList<Puntaje> puntaje;

    public int getPuntajeTotal() {
        int total = 0;

        if (puntaje == null || puntaje.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < puntaje.size(); i++) {
            total += puntaje.get(i).getPuntos();
        }
        total = total / puntaje.size();
        return total;
    }

    public ArrayList<Puntaje> getPuntaje() {
        return puntaje;
    }
}