package com.project;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear lista de instancias de electrodomésticos
        List<Electrodomestic> electrodomestics = new ArrayList<>();

        // Añadir instancias de Nevera
        electrodomestics.add(new Nevera("Nevera A", "Blanca", 800.0, "Marca1", "A++", 300, 40));
        electrodomestics.add(new Nevera("Nevera B", "Negra", 950.0, "Marca2", "A+", 350, 45));

        // Añadir instancias de Rentadora
        electrodomestics.add(new Rentadora("Rentadora A", "Blanca", 500.0, "Marca3", "A++", 1200, 70));
        electrodomestics.add(new Rentadora("Rentadora B", "Gris", 650.0, "Marca4", "A+", 1400, 75));

        // Añadir instancias de Forn
        electrodomestics.add(new Forn("Forn A", "Negro", 600.0, "Marca5", "A++", 250, true));
        electrodomestics.add(new Forn("Forn B", "Blanco", 700.0, "Marca6", "A+", 300, false));

        // Clonar electrodomésticos
        List<Electrodomestic> clonedElectrodomestics = new ArrayList<>();
        for (Electrodomestic electro : electrodomestics) {
            try {
                clonedElectrodomestics.add((Electrodomestic) electro.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        // Comparar la lista original con ella misma
        System.out.println("Comparaciones con la misma lista:");
        for (int i = 0; i < electrodomestics.size(); i++) {
            Electrodomestic original = electrodomestics.get(i);
            Electrodomestic same = electrodomestics.get(i);

            boolean sameReference = original == same;
            boolean sameClass = original.getClass() == same.getClass();
            boolean sameData = original.toString().equals(same.toString());

            System.out.printf("Comparando %d: Mismo objeto: %b, Misma clase: %b, Mismos datos: %b%n", 
                              i + 1, sameReference, sameClass, sameData);
        }

        // Comparar la lista original con los clones
        System.out.println("\nComparaciones con los clones:");
        for (int i = 0; i < electrodomestics.size(); i++) {
            Electrodomestic original = electrodomestics.get(i);
            Electrodomestic clone = clonedElectrodomestics.get(i);

            boolean sameReference = original == clone;
            boolean sameClass = original.getClass() == clone.getClass();
            boolean sameData = original.toString().equals(clone.toString());

            System.out.printf("Comparando %d: Mismo objeto: %b, Misma clase: %b, Mismos datos: %b%n", 
                              i + 1, sameReference, sameClass, sameData);
        }
    }
}
