package com.project;



public abstract class Electrodomestic implements Cloneable {
    protected String nom;
    protected String color;
    protected double preu;
    protected String marca;
    protected String eficiencia;

    public Electrodomestic(String nom, String color, double preu, String marca, String eficiencia) {
        this.nom = nom;
        this.color = color;
        this.preu = preu;
        this.marca = marca;
        this.eficiencia = eficiencia;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "Electrodomestic{" +
                "nom='" + nom + '\'' +
                ", color='" + color + '\'' +
                ", preu=" + preu +
                ", marca='" + marca + '\'' +
                ", eficiencia='" + eficiencia + '\'' +
                '}';
    }

    // Getters
    public String getNom() { return nom; }
    public String getColor() { return color; }
    public double getPreu() { return preu; }
    public String getMarca() { return marca; }
    public String getEficiencia() { return eficiencia; }
}

