package com.project;

public class Exercici0 {
    public static void main(String[] args) throws InterruptedException {
        // Instanciar primer objecte
        System.out.println("Iniciant 0");
        Objecte0 objecte1 = Objecte0.getInstance("Joan", "Pérez", 25);
        
        
        // Esperar 3 segons
        Thread.sleep(3000);
        
        // Instanciar segon objecte
        System.out.println("Iniciant 1");
        Objecte0 objecte2 = Objecte0.getInstance("Maria", "Gómez", 30);

        
        // Esperar 3 segons
        Thread.sleep(3000);
        
        // Instanciar tercer objecte
        System.out.println("Iniciant 2");
        Objecte0 objecte3 = Objecte0.getInstance("Pau", "Martí", 40);
        
        // Esperar 3 segons
        Thread.sleep(3000);
        
        // Imprimir Objectes
        System.out.println("Objecte 1: " + objecte1);
        System.out.println("Objecte 2: " + objecte2);
        System.out.println("Objecte 3: " + objecte3);
    }
}
