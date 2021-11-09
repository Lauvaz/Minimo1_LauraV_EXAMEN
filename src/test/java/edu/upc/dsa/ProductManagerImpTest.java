package edu.upc.dsa;

import edu.upc.dsa.models.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class ProductManagerImpTest {
    PuntoManager scenario;



    @Before
    public void setUp() {

        scenario = PuntoManagerImpl.getInstance();
        scenario.addPunto(new Punto("Puente", 2));
        scenario.addUser("Laura","111");

    }

    @After
    public void tearDown() {
        scenario.getPuntosList().clear();

    }




}
