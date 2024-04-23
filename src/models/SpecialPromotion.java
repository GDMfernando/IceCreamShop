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
public class SpecialPromotion {

    private String name;
    private double discount;
    private List<Flavor> applicableFlavors;

    public SpecialPromotion(String name, double discount, List<Flavor> applicableFlavors) {
        this.name = name;
        this.discount = discount;
        this.applicableFlavors = applicableFlavors;
    }

    public String getName() {
        return name;
    }

    public double getDiscount() {
        return discount;
    }

    public List<Flavor> getApplicableFlavors() {
        return applicableFlavors;
    }

    public void displayApplicableFlavors() {
        System.out.println("Applicable Flavors for " + name + ":");
        for (Flavor flavor : applicableFlavors) {
            System.out.println(flavor.getFlavorId() + ". " + flavor.getName());
        }
    }

}
