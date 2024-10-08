package com.project;

public class Forn extends Electrodomestic {
    private int temperatura;
    private boolean autoneteja;

    public Forn(String nom, String color, double preu, String marca, String eficiencia, int temperatura, boolean autoneteja) {
        super(nom, color, preu, marca, eficiencia);
        this.temperatura = temperatura;
        this.autoneteja = autoneteja;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return super.toString() + ", Forn{" +
                "temperatura=" + temperatura +
                ", autoneteja=" + autoneteja +
                '}';
    }
}

