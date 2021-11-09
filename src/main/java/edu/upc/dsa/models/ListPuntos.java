package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class ListPuntos {
    public User user;
    public List<Punto> puntoList;


    public ListPuntos(User user) {
        this.user = user;
        this.puntoList = new ArrayList<Punto>();
    }

    public ListPuntos(){}

    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public List<Punto> getPuntoList() {
        return puntoList;
    }

    public void setProductList(List<Punto> puntoList) {
        this.puntoList = puntoList;
    }


    public void addPunto(Punto punto) {

        puntoList.add(punto);
    }

    @Override
    public String toString() {
        return "ListaPuntos{" +
                "user=" + user +
                ", puntoList=" + puntoList +
                '}';
    }
}
