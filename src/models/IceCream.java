/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.List;
/**
 *
 * @author acer
 */
// Represents a customizable ice cream item
public class IceCream {
    private Flavor flavor;
    private List<Topping> toppings;
    private List<Syrup> syrups;
    private String name;

    public IceCream(Flavor flavor, List<Topping> toppings, List<Syrup> syrups, String name) {
        this.flavor = flavor;
        this.toppings = toppings;
        this.syrups = syrups;
        this.name = name;
    }

    // Getters for flavor, toppings, syrups, and name
    public Flavor getFlavor() {
        return flavor;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public List<Syrup> getSyrups() {
        return syrups;
    }

    public String getName() {
        return name;
    }   
    
    public double getFlavorCost() {
        return flavor.getPrice();
    }
}
