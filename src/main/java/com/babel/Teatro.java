package com.babel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teatro {
    private Butaca[][] butacas;

    public Butaca[][] getButacas() {
        return butacas;
    }

    public Teatro(int filas, int asientosPorFila) {
        butacas = new Butaca[filas][asientosPorFila];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < asientosPorFila; j++) {
                butacas[i][j] = new Butaca(i + 1, j + 1, false);
            }
        }
    }

    public void mostrarEstadoButacas() {
        for (Butaca[] filaButacas : butacas) {
            for (Butaca butaca : filaButacas) {
                if (butaca.isOcupado()) {
                    System.out.print("[X]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    public List<Butaca[]> encontrarMejoresButacasLibres(int cantidadEntradas) {
        List<Butaca[]> mejoresButacas = new ArrayList<>();
        int medio = butacas[0].length / 2;

        for (int i = butacas.length - 1; i >= 0; i--) {
            int inicio = Math.max(0, medio - cantidadEntradas / 2);
            int fin = Math.min(butacas[i].length - cantidadEntradas, medio);

            for (int j = inicio; j <= fin; j++) {
                boolean disponibles = true;

                for (int k = j; k < j + cantidadEntradas; k++) {
                    if (butacas[i][k].isOcupado()) {
                        disponibles = false;
                        break;
                    }
                }

                if (disponibles) {
                    mejoresButacas.add(Arrays.copyOfRange(butacas[i], j, j + cantidadEntradas));
                }
            }
        }

        return mejoresButacas;
    }

    public void pintarButacas(Butaca[] butacas) {
        for (Butaca butaca : butacas) {
            if (butaca.isOcupado()) {
                System.out.println("¡Error! La butaca ya está ocupada.");
            } else {
                butaca.setOcupado(true);
            }
        }
    }
}
