package com.project;

public class Exercici1 {
    public static void main(String[] args) {
        try {
            // Instanciar primer objecte 
            System.out.println("Iniciant 0");
            Objecte1 objecte1 = Objecte1.getNewDestroyedInstance("Joan", "Pérez", 25);


            // Esperar 3 segons
            Thread.sleep(3000);

            // Instanciar segon objecte 
            System.out.println("Iniciant 1");
            Objecte1 objecte2 = Objecte1.getNewDestroyedInstance("Maria", "Gómez", 30);


            // Esperar 3 segons
            Thread.sleep(3000);

            // Instanciar tercer objecte 
            System.out.println("Iniciant 2");
            Objecte1 objecte3 = Objecte1.getNewDestroyedInstance("Pau", "Martí", 40);

            // Esperar 3 segons
            Thread.sleep(3000);
            
            // Imprimir Objectes
            System.out.println("Objecte 1: " + objecte1);
            System.out.println("Objecte 2: " + objecte2);
            System.out.println("Objecte 3: " + objecte3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





