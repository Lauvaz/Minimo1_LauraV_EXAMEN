package edu.upc.dsa.models;

public class Punto {
    public String name;
    int amount;

    public Punto(String name, int amount){
        this.name = name;
        this.amount = amount;

    }
    public Punto(){}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Punto{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
