/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.List;
import java.util.ArrayList;
import models.IceCream.*;

/**
 *
 * @author acer
 */
//Builder Pattern
public class OrderBuilder {

    private IceCream iceCream;
    private List<Topping> toppings;
    private List<Syrup> syrups;
    private int quantity;
    private String customizationName;
    private Menu menu;

    public OrderBuilder(Menu menu) {
        this.menu = menu;
        this.toppings = new ArrayList<>();
        this.syrups = new ArrayList<>();
    }

    public void addFlavor(Flavor flavor) {
        this.iceCream = new IceCream(flavor, toppings, syrups, customizationName);
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void addSyrup(Syrup syrup) {
        syrups.add(syrup);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCustomizationName(String name) {
        this.customizationName = name;
    }

    public IceCream build() {
        if (iceCream == null) {
            throw new IllegalStateException("Flavor must be set for the ice cream");
        }

        if (quantity <= 0) {
            throw new IllegalStateException("Quantity must be greater than zero");
        }

        if (customizationName == null || customizationName.trim().isEmpty()) {
            throw new IllegalStateException("Customization name cannot be empty or null");
        }

        // Build the ice cream customization
        IceCream builtIceCream = new IceCream(iceCream.getFlavor(), toppings, syrups, customizationName);

        reset();

        return builtIceCream;
    }

    private void reset() {
        iceCream = null;
        toppings.clear();
        syrups.clear();
        quantity = 0;
        customizationName = null;
    }
}
