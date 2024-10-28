package com.project;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DaoLlenguatge {
    private String path = Main.llenguatgesPath;
    private ArrayList<ObjLlenguatge> llenguatges;

    public DaoLlenguatge() {
        this.llenguatges = loadLlenguatges();
    }

    private ArrayList<ObjLlenguatge> loadLlenguatges() {
        try (Reader reader = new FileReader(path)) {
            Type listType = new TypeToken<ArrayList<ObjLlenguatge>>() {}.getType();
            return new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void add(ObjLlenguatge llenguatge) {
        llenguatges.add(llenguatge);
        save();
    }

    public void update(int id, ObjLlenguatge newLlenguatge) {
        for (int i = 0; i < llenguatges.size(); i++) {
            if (llenguatges.get(i).getId() == id) {
                llenguatges.set(i, newLlenguatge);
                break;
            }
        }
        save();
    }

    public void delete(int id) {
        llenguatges.removeIf(llenguatge -> llenguatge.getId() == id);
        save();
    }

    public void print() {
        for (ObjLlenguatge llenguatge : llenguatges) {
            System.out.println("Llenguatge: " + llenguatge.getId() + " " + llenguatge.getNom() + ", " + llenguatge.getAny() + " - " + llenguatge.getDificultat() + "/" + llenguatge.getPopularitat());
        }
    }

    public void setNom(int id, String nom) {
        for (ObjLlenguatge llenguatge : llenguatges) {
            if (llenguatge.getId() == id) {
                llenguatge.setNom(nom);
                break;
            }
        }
        save();
    }

    public void setAny(int id, int any) {
        for (ObjLlenguatge llenguatge : llenguatges) {
            if (llenguatge.getId() == id) {
                llenguatge.setAny(any);
                break;
            }
        }
        save();
    }

    public void setDificultat(int id, String dificultat) {
        for (ObjLlenguatge llenguatge : llenguatges) {
            if (llenguatge.getId() == id) {
                llenguatge.setDificultat(dificultat);
                break;
            }
        }
        save();
    }

    public void setPopularitat(int id, int popularitat) {
        for (ObjLlenguatge llenguatge : llenguatges) {
            if (llenguatge.getId() == id) {
                llenguatge.setPopularitat(popularitat);
                break;
            }
        }
        save();
    }

    private void save() {
        try (Writer writer = new FileWriter(path)) {
            new Gson().toJson(llenguatges, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
