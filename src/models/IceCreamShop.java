/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package models;

import enums.PaymentMethod;
import java.util.List;
import models.Customer;
import models.IceCream;
import models.Menu;
import models.Order;

/**
 *
 * @author acer
 */
public class IceCreamShop {

    private Menu menu;
    private OrderManager orderManager;
    private PaymentProcessor paymentProcessor;
    private PromotionManager promotionManager;
    private FeedbackManager feedbackManager;

    /**
     * @param args the command line arguments
     */
    //Constructs an IceCreamShop.
    public IceCreamShop(Menu menu, OrderManager orderManager, PaymentProcessor paymentProcessor,
            PromotionManager promotionManager, FeedbackManager feedbackManager) {
        this.menu = menu;
        this.orderManager = orderManager;
        this.paymentProcessor = paymentProcessor;
        this.promotionManager = promotionManager;
        this.feedbackManager = feedbackManager;
    }
//orderBuilder The builder used to customize the ice cream order.
    public void customizeIceCream(OrderBuilder orderBuilder) {
        IceCream iceCream = orderBuilder.build();

        Order order = new Order(1, new Customer(1, "John Doe"));
        order.addItem(iceCream);

        order.addDecorator(new GiftWrappingDecorator());
        order.addDecorator(new SpecialPackagingDecorator());

        List<SpecialPromotion> availablePromotions = menu.getSpecials();
        promotionManager.applyPromotion(order, availablePromotions);
        paymentProcessor.processPayment(order, PaymentMethod.CREDIT_CARD);

        // Place the decorated and processed order using the order manager
        orderManager.placeOrder(order);
    }
}
