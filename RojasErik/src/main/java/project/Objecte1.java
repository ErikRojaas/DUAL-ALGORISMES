package com.project;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Objecte1 {
    private static Objecte1 instance = null;

    private String nom;
    private String cognom;
    private int edat;

    // Constructor 
    private Objecte1(String nom, String cognom, int edat) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

    // Mètode per obtenir instància
    public static synchronized Objecte1 getInstance(String nom, String cognom, int edat) {
        if (instance == null) {
            instance = new Objecte1(nom, cognom, edat);
        }
        return instance;
    }

    // Mètode per obtenir una nova instància hackejada
    public static Objecte1 getNewDestroyedInstance(String nom, String cognom, int edat) throws Exception {
        // Utilitzem reflexió per accedir al constructor privat
        Constructor<Objecte1> constructor = Objecte1.class.getDeclaredConstructor(String.class, String.class, int.class);
        constructor.setAccessible(true);

        // Creem una nova instància
        Objecte1 objecte = constructor.newInstance(nom, cognom, edat);

        // Reinicialitzem l'instància estàtica
        Field instanceField = Objecte1.class.getDeclaredField("instance");
        instanceField.setAccessible(true);
        instanceField.set(null, null);

        return objecte;
    }

    public String toString() {
        return "Nom: " + nom + ", Cognom: " + cognom + ", Edat: " + edat;
    }

}

