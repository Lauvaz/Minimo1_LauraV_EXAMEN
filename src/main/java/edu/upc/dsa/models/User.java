package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String name;
    public String id;
    public List<ListPuntos> puntosList;


    public User(String name, List<ListPuntos> puntosList, String id) {
        this.name = name;
        this.id = id;
        this.puntosList = puntosList;
    }
    public User(String name, String id) {
        this.name = name;
        this.id = id;
        this.puntosList = new ArrayList<>();
    }

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() { return id;}

    public void setId(String id) { this.id = id; }

    public List<ListPuntos> getPuntosList() { return puntosList; }

    public void setPuntosList(List<ListPuntos> puntoList) { this.puntosList = puntoList; }


}
