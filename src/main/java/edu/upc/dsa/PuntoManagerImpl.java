package edu.upc.dsa;

import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Punto;
import edu.upc.dsa.models.ListPuntos;


import java.util.*;
import java.util.logging.Logger;

public class PuntoManagerImpl implements PuntoManager {
    public List<Punto> puntoList = new ArrayList<>();
    public List<ListPuntos> puntosList = new LinkedList<>();
    public List<User> usersList = new LinkedList<>();
    public HashMap<String, User> users = new HashMap<String, User>();

    final static Logger logger = Logger.getLogger(String.valueOf(PuntoManagerImpl.class));

    private static PuntoManagerImpl instance;

    public static PuntoManagerImpl getInstance() {
        if (instance == null)
            instance = new PuntoManagerImpl();

        return instance;
    }

    public void addUser(String user, String id) {
        this.users.put(user, new User(user, id));
    }

    @Override
    public List<User> getUsersbyName() {
        logger.info("Query: getUsersByName. Before ordering:" + usersList);
        Collections.sort(this.usersList, new Comparator<User>() {
            @Override
            public int compare(User p1, User p2) {
                if (p1.getName().compareTo(p2.getName()) < 0) return -1;
                else if (p1.getName().compareTo(p2.getName()) > 0) return 1;
                else return 0;
            }

        });

        logger.info("After ordering:" + usersList);
        return usersList;
    }

    @Override
    public User getUser(User user) {
        return users.get(user);
    }

    public void addPunto(Punto punto) {
        this.puntoList.add(punto);
    }

    @Override
    public List<ListPuntos> getPuntosUser(User user) {
        return users.get(user).getPuntosList();
    }

    public List<ListPuntos> getPuntosList() {
        return this.puntosList;
    }
/*
    @Override
    public List<User> getUsersbyPunto() {
        List<User> list = this.usersList;
        Collections.sort(list, new Comparator<Punto>() {
            @Override
            public int compare(Punto o1, Punto o2) {
                logger.info(String.valueOf(o1.getAmount() - o2.getAmount()));
                return o1.getAmount() - o2.getAmount();
            }
        });
        return list;
    }
*/
@Override
public User getUser(String user) {
    return users.get(user);
}
}





