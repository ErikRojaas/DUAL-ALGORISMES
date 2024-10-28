package com.project;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DaoSoftware {
    private String path = Main.softwarePath;
    private ArrayList<ObjSoftware> software;

    public DaoSoftware() {
        this.software = loadSoftware();
    }

    private ArrayList<ObjSoftware> loadSoftware() {
        try (Reader reader = new FileReader(path)) {
            Type listType = new TypeToken<ArrayList<ObjSoftware>>() {}.getType();
            return new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void add(ObjSoftware software) {
        this.software.add(software);
        save();
    }

    public void update(int id, ObjSoftware newSoftware) {
        for (int i = 0; i < this.software.size(); i++) {
            if (this.software.get(i).getId() == id) {
                this.software.set(i, newSoftware);
                break;
            }
        }
        save();
    }

    public void delete(int id) {
        software.removeIf(software -> software.getId() == id);
        save();
    }

    public void print() {
        for (ObjSoftware software : software) {
            System.out.println("Software: " + software.getId() + " " + software.getNom() + ", " + software.getAny() + " - " + software.getLlenguatges());
        }
    }

    private void save() {
        try (Writer writer = new FileWriter(path)) {
            new Gson().toJson(software, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
