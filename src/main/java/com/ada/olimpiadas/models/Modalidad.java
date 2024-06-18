package com.ada.olimpiadas.models;

public class Modalidad {

    private int id;
    private boolean mideTiempo;
    private boolean mideAltura;
    private boolean mideEstilo;
    private boolean mideTecnica;
    private boolean cuentaFaltas;
    private short cantidadRounds;

    public Modalidad(int id, boolean mideTiempo, boolean mideDistancia, boolean mideAltura, boolean mideEstilo,
            boolean mideTecnica, boolean cuentaFaltas, short cantidadRounds) {
        this.id = id;
        this.mideTiempo = mideTiempo;
        this.mideDistancia = mideDistancia;
        this.mideAltura = mideAltura;
        this.mideEstilo = mideEstilo;
        this.mideTecnica = mideTecnica;
        this.cuentaFaltas = cuentaFaltas;
        this.cantidadRounds = cantidadRounds;
    }

    private boolean mideDistancia;

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

    public short getCantidadRounds() {
        return cantidadRounds;
    }

    public void setCantidadRounds(short cantidadRounds) {
        this.cantidadRounds = cantidadRounds;
    }

}
