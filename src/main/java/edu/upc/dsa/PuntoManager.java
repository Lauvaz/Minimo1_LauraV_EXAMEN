package edu.upc.dsa;

import edu.upc.dsa.models.ListPuntos;
import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Punto;

import java.util.List;

public interface PuntoManager {
    void addUser(String user, String id);
    User getUser(User user);
    List<User> getUsersbyName();
    void addPunto(Punto punto);
    List<ListPuntos> getPuntosUser(User user);
    //List<User> getUsersbyPunto();
    List<ListPuntos> getPuntosList();
    User getUser(String user);

}

//editar para probar push
