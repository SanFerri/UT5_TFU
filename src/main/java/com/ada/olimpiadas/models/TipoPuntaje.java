package com.ada.olimpiadas.models;

public class TipoPuntaje {
    private int id;
    private boolean mideTiempo;
    private boolean mideDistancia;
    private boolean mideAltura;
    private boolean mideEstilo;
    private boolean mideTecnica;
    private boolean cuentaFaltas;
    private int cantidadRounds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMideTiempo() {
        return mideTiempo;
    }

    public void setMideTiempo(boolean mideTiempo) {
        this.mideTiempo = mideTiempo;
    }

    public boolean isMideDistancia() {
        return mideDistancia;
    }

    public void setMideDistancia(boolean mideDistancia) {
        this.mideDistancia = mideDistancia;
    }

    public boolean isMideAltura() {
        return mideAltura;
    }

    public void setMideAltura(boolean mideAltura) {
        this.mideAltura = mideAltura;
    }

    public boolean isMideEstilo() {
        return mideEstilo;
    }

    public void setMideEstilo(boolean mideEstilo) {
        this.mideEstilo = mideEstilo;
    }

    public boolean isMideTecnica() {
        return mideTecnica;
    }

    public void setMideTecnica(boolean mideTecnica) {
        this.mideTecnica = mideTecnica;
    }

    public boolean isCuentaFaltas() {
        return cuentaFaltas;
    }

    public void setCuentaFaltas(boolean cuentaFaltas) {
        this.cuentaFaltas = cuentaFaltas;
    }

    public int getCantidadRounds() {
        return cantidadRounds;
    }

    public void setCantidadRounds(int cantidadRounds) {
        this.cantidadRounds = cantidadRounds;
    }

}
