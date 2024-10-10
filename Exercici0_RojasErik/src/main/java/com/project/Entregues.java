package com.project;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Entregues {
    private ArrayList<Producte> productes;
    private PropertyChangeSupport support;

    public Entregues() {
        this.productes = new ArrayList<>();
        this.support = new PropertyChangeSupport(this);
    }

    // Getters
    public ArrayList<Producte> getProductes() {
        return productes;
    }

    // Métodos para añadir y remover productos
    public void addProducte(Producte p) {
        productes.add(p);
        support.firePropertyChange("entreguesAdd", null, p.getId());
        System.out.println("S'ha afegit el producte amb id " + p.getId() + " a la llista d'entregues");
    }

    public void removeProducte(int id) {
        Producte producte = null;
        for (Producte p : productes) {
            if (p.getId() == id) {
                producte = p;
                break;
            }
        }
        if (producte != null) {
            productes.remove(producte);
            support.firePropertyChange("entreguesRemove", id, null);
            System.out.println("S'ha entregat el producte amb id " + id);
        }
    }

    // Métodos para los listeners
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    @Override
    public String toString() {
        return "Entregues{productes=" + productes + "}";
    }
}

