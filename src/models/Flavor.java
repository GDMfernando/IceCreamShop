/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author acer
 */
//ice cream flavors class
public class Flavor {
//veriables for flavor id, name and price
    private int flavorId;
    private String name;
    private double price;

    public Flavor(int flavorId, String name, double price) {
        this.flavorId = flavorId;
        this.name = name;
        this.price = price;
    }

    //getter methods
    public int getFlavorId() {
        return flavorId;
    }

    public void setFlavorId(int flavorId) {
        this.flavorId = flavorId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
