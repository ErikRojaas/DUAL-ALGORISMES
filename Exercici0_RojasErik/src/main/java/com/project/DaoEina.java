package com.project;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DaoEina {
    private String path = Main.einesPath;
    private ArrayList<ObjEina> eines;

    public DaoEina() {
        this.eines = loadEines();
    }

    private ArrayList<ObjEina> loadEines() {
        try (Reader reader = new FileReader(path)) {
            Type listType = new TypeToken<ArrayList<ObjEina>>() {}.getType();
            return new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void add(ObjEina eina) {
        eines.add(eina);
        save();
    }

    public void update(int id, ObjEina newEina) {
        for (int i = 0; i < eines.size(); i++) {
            if (eines.get(i).getId() == id) {
                eines.set(i, newEina);
                break;
            }
        }
        save();
    }

    public void delete(int id) {
        eines.removeIf(eina -> eina.getId() == id);
        save();
    }

    public void print() {
        for (ObjEina eina : eines) {
            System.out.println("Eina: " + eina.getId() + " " + eina.getNom() + ", " + eina.getAny() + " - " + eina.getLlenguatges());
        }
    }

    public void setLlenguatgesAdd(int id, int idLlenguatge) {
        for (ObjEina eina : eines) {
            if (eina.getId() == id) {
                eina.getLlenguatges().add(idLlenguatge);
                break;
            }
        }
        save();
    }

    public void setLlenguatgesDelete(int id, int idLlenguatge) {
        for (ObjEina eina : eines) {
            if (eina.getId() == id) {
                eina.getLlenguatges().remove(Integer.valueOf(idLlenguatge));
                break;
            }
        }
        save();
    }

    private void save() {
        try (Writer writer = new FileWriter(path)) {
            new Gson().toJson(eines, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
