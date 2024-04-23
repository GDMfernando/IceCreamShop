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
public class PromotionManager {
    // Implementation of promotion management methods

    public void applyPromotion(Order order, List<SpecialPromotion> availablePromotions) {
        System.out.println("Applying promotions to order " + order.getOrderId());

        for (SpecialPromotion promotion : availablePromotions) {
            if (isPromotionApplicable(order, promotion)) {
                applyDiscount(order, promotion);
                System.out.println("Promotion applied: " + promotion.getName());
            }
        }
    }

    private boolean isPromotionApplicable(Order order, SpecialPromotion promotion) {
        // Check if the order items match the applicable flavors of the promotion
        for (IceCream item : order.getItems()) {
            if (!promotion.getApplicableFlavors().contains(item.getFlavor())) {
                return false;
            }
        }
        return true;
    }

    private void applyDiscount(Order order, SpecialPromotion promotion) {
        double discountAmount = order.calculateTotal() * promotion.getDiscount();
        double discountedTotal = order.calculateTotal() - discountAmount;

        // Set the discounted total to the order
        order.setTotal(discountedTotal);
    }
}
