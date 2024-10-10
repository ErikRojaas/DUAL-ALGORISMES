package com.project;

public class Main {
    public static void main(String[] args) {

        Producte p0 = new Producte(0, "Llibre");
        Producte p1 = new Producte(1, "Boli");
        Producte p2 = new Producte(2, "Rotulador");
        Producte p3 = new Producte(3, "Carpeta");
        Producte p4 = new Producte(4, "Motxilla");

        Magatzem magatzem = new Magatzem();
        Entregues entregues = new Entregues();

        // Aquí afegir els property listeners adequats (si es necesario)

        p0.setId(5);
        p0.setNom("Llibreta");
        p1.setNom("Bolígraf");

        magatzem.addProducte(p0);
        magatzem.addProducte(p1);
        magatzem.addProducte(p2);
        magatzem.addProducte(p3);
        magatzem.addProducte(p4);

        magatzem.removeProducte(2, entregues);  // Mueve el producto 2 a entregues
        magatzem.removeProducte(3, entregues);  // Mueve el producto 3 a entregues
        magatzem.removeProducte(4, entregues);  // Mueve el producto 4 a entregues

        entregues.removeProducte(2);  // Entrega el producto 2
        entregues.removeProducte(3);  // Entrega el producto 3

        System.out.println(magatzem);
        System.out.println(entregues);
    }
}
