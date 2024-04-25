package com.babel;

public class Butaca {
    private int fila;
    private int numero;
    private boolean ocupado;

    public Butaca(int fila, int numero, boolean ocupado) {
        this.fila = fila;
        this.numero = numero;
        this.ocupado = ocupado;
    }

    public int getFila() {
        return fila;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
