package com.babel;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Teatro cineTeatro = new Teatro(9, 10);

        boolean salir = false;

        while (!salir) {
            System.out.println("Estado actual de las butacas:");
            cineTeatro.mostrarEstadoButacas();

            System.out.println("1. Buscar asientos");
            System.out.println("2. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la cantidad de entradas que desea:");
                    int cantidadEntradas = scanner.nextInt();
                    List<Butaca[]> mejoresButacas = cineTeatro.encontrarMejoresButacasLibres(cantidadEntradas);

                    System.out.println("\nMejores butacas libres para " + cantidadEntradas + " entradas:");

                    for (Butaca[] butacas : mejoresButacas) {
                        for (Butaca butaca : butacas) {
                            System.out.println("Fila: " + butaca.getFila() + ", Asiento: " + butaca.getNumero());
                        }
                    }

                    if (!mejoresButacas.isEmpty()) {
                        Butaca[] mejoresAsientos = mejoresButacas.get(0);
                        cineTeatro.pintarButacas(mejoresAsientos);
                    } else {
                        System.out.println("No se encontraron butacas disponibles para " + cantidadEntradas + " entradas.");
                    }
                    break;
                case 2:
                    salir = true;
                    System.out.println("Saliedo...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese 1 o 2.");
                    break;
            }
        }
        scanner.close();
    }
}