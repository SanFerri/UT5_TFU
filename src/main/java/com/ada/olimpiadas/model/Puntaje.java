package com.ada.olimpiadas.model;

public class Puntaje {
    private Participante participante;
    private Juez juez;
    private TipoPuntaje tipoPuntaje;
    private int valor;

    public Participante getParticipante(){
        return participante;
    }

    public void setParticipante(Participante participante){
        this.participante = participante;
    }

    public Juez getJuez(){
        return juez;
    }

    public void setJuez(Juez juez){
        this.juez = juez;
    }

    public TipoPuntaje getTipoPuntaje(){
        return tipoPuntaje;
    }

    public void setTipoPuntaje(TipoPuntaje tipoPuntaje){
        this.tipoPuntaje = tipoPuntaje;
    }

    public int getValor(){
        return valor;
    }

    public void setValor(int valor){
        this.valor = valor;
    }
}
