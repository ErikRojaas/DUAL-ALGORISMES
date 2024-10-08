package com.project;


public class Rentadora extends Electrodomestic {
    private int revolucions;
    private int soroll;

    public Rentadora(String nom, String color, double preu, String marca, String eficiencia, int revolucions, int soroll) {
        super(nom, color, preu, marca, eficiencia);
        this.revolucions = revolucions;
        this.soroll = soroll;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return super.toString() + ", Rentadora{" +
                "revolucions=" + revolucions +
                ", soroll=" + soroll +
                '}';
    }
}

