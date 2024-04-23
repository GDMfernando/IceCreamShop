/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author acer
 */
public class Syrup {
//veriables for syrup class
    private int syrupId;
    private String name;
    private double price;

    public Syrup(int syrupId, String name, double price) {
        this.syrupId = syrupId;
        this.name = name;
        this.price = price;
    }
    
//getter and setter methods
    public int getSyrupId() {
        return syrupId;
    }

    public void setSyrupId(int syrupId) {
        this.syrupId = syrupId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
