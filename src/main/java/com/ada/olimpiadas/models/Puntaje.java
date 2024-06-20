package com.ada.olimpiadas.models;

public class Puntaje {
    private int id;
    private int juezId;
    private int participanteId;
    private int categoriaId;
    private String valorTiempo;
    private Float valorDistancia;
    private Float valorEstilo;
    private Float valorTecnica;
    private int faltas;
    private int round;

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

    public String getValorTiempo() {
        return valorTiempo;
    }

    public void setValorTiempo(String valorTiempo) {
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

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

}
