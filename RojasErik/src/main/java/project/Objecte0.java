package com.project;

public class Objecte0 {
    private static Objecte0 instance = null;
    
    private String nom;
    private String cognom;
    private int edat;

    // Constructor
    private Objecte0(String nom, String cognom, int edat) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

    // Mètode per obtenir instància
    public static synchronized Objecte0 getInstance(String nom, String cognom, int edat) {
        if (instance == null) {
            instance = new Objecte0(nom, cognom, edat);
        }
        return instance;
    }

    public String toString() {
        return "Nom: " + nom + ", Cognom: " + cognom + ", Edat: " + edat;
    }
}

