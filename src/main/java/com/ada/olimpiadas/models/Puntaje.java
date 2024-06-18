package com.ada.olimpiadas.models;

import java.sql.Time;

public class Puntaje {
    private int id;
    private int juezId;
    private int participanteId;
    private int categoriaId;
    private Time valorTiempo;
    private Float valorDistancia;
    private Float valorEstilo;
    private Float valorTecnica;
    private Short faltas;
    private Short round;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJuezId() {
        return juezId;
    }

    public void setJuezId(int juezId) {
        this.juezId = juezId;
    }

    public int getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(int participanteId) {
        this.participanteId = participanteId;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Time getValorTiempo() {
        return valorTiempo;
    }

    public void setValorTiempo(Time valorTiempo) {
        this.valorTiempo = valorTiempo;
    }

    public Float getValorDistancia() {
        return valorDistancia;
    }

    public void setValorDistancia(Float valorDistancia) {
        this.valorDistancia = valorDistancia;
    }

    public Float getValorEstilo() {
        return valorEstilo;
    }

    public void setValorEstilo(Float valorEstilo) {
        this.valorEstilo = valorEstilo;
    }

    public Float getValorTecnica() {
        return valorTecnica;
    }

    public void setValorTecnica(Float valorTecnica) {
        this.valorTecnica = valorTecnica;
    }

    public Short getFaltas() {
        return faltas;
    }

    public void setFaltas(Short faltas) {
        this.faltas = faltas;
    }

    public Short getRound() {
        return round;
    }

    public void setRound(Short round) {
        this.round = round;
    }

}
