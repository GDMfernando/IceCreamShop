/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.List;
import models.IceCream.*;

/**
 *
 * @author acer
 */
public class Menu {
// Lists to store menu items and promotions

    private List<Flavor> flavors;
    private List<Topping> toppings;
    private List<Syrup> syrups;
    private List<SpecialPromotion> specials;

    public Menu(List<Flavor> flavors, List<Topping> toppings, List<Syrup> syrups, List<SpecialPromotion> specials) {
        this.flavors = flavors;
        this.toppings = toppings;
        this.syrups = syrups;
        this.specials = specials;
    }

    public List<Flavor> getFlavors() {
        return flavors;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public List<Syrup> getSyrups() {
        return syrups;
    }

    public List<SpecialPromotion> getSpecials() {
        return specials;
    }

    // Method to get a flavor by its ID
    public Flavor getFlavorById(int flavorId) {
        for (Flavor flavor : flavors) {
            if (flavor.getFlavorId() == flavorId) {
                return flavor;
            }
        }
        return null;
    }

    // Method to get a topping by its ID
    public Topping getToppingById(int toppingId) {
        for (Topping topping : toppings) {
            if (topping.getToppingId() == toppingId) {
                return topping;
            }
        }
        return null;
    }

    // Method to get a syrup by its ID
    public Syrup getSyrupById(int syrupId) {
        for (Syrup syrup : syrups) {
            if (syrup.getSyrupId() == syrupId) {
                return syrup;
            }
        }
        return null;
    }
}
