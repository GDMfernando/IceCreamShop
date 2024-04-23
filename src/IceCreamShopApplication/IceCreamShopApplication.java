/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IceCreamShopApplication;

import enums.PaymentMethod;
import interfaces.OrderCommand;
import java.util.List;
import models.*;
import java.util.ArrayList;
import java.util.Scanner;
import models.FeedbackManager;
import models.Customer;

/**
 *
 * @author acer
 */
//main method class
public class IceCreamShopApplication {

    public static void main(String[] args) {
        // Initialize and set up the Ice Cream Shop
        List<Flavor> flavors = new ArrayList<>();
        flavors.add(new Flavor(1, "Vanilla", 100));
        flavors.add(new Flavor(2, "Chocolate", 110));

        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Topping(1, "Sprinkles", 10));
        toppings.add(new Topping(2, "Chocolate Chips", 30));

        List<Syrup> syrups = new ArrayList<>();
        syrups.add(new Syrup(1, "Chocolate Syrup", 30));
        syrups.add(new Syrup(2, "Caramel Syrup", 30));

        List<SpecialPromotion> specials = new ArrayList<>();
        specials.add(new SpecialPromotion("Special Promo 1", 0.2, flavors));

        Menu menu = new Menu(flavors, toppings, syrups, specials);
        OrderManager orderManager = new OrderManager();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.addPaymentStrategy(PaymentMethod.CREDIT_CARD, new CreditCardPaymentStrategy());
        paymentProcessor.addPaymentStrategy(PaymentMethod.DIGITAL_WALLET, new DigitalWalletPaymentStrategy());
        PromotionManager promotionManager = new PromotionManager();
        FeedbackManager feedbackManager = new FeedbackManager();

        // Create the Ice Cream Shop instance
        IceCreamShop iceCreamShop = new IceCreamShop(menu, orderManager, paymentProcessor, promotionManager, feedbackManager);

        Scanner scanner = new Scanner(System.in);

        // Display menu to the user
        displayMenu(menu);

        int flavorChoice = getUserChoice(scanner, "Select a flavor: ");
        int toppingChoice = getUserChoice(scanner, "Select a topping: ");
        int syrupChoice = getUserChoice(scanner, "Select a syrup: ");
        int quantity = getUserQuantity(scanner, "Enter quantity: ");
        String customizationName = getUserInput(scanner, "Enter customization name: ");

        OrderBuilder orderBuilder = new OrderBuilder(menu);
        orderBuilder.addFlavor(menu.getFlavorById(flavorChoice));
        orderBuilder.addTopping(menu.getToppingById(toppingChoice));
        orderBuilder.addSyrup(menu.getSyrupById(syrupChoice));
        orderBuilder.setQuantity(quantity);
        orderBuilder.setCustomizationName(customizationName);
 
        iceCreamShop.customizeIceCream(orderBuilder);

        // Display the list of orders placed
        displayOrders(orderManager);

        OrderCommand placeOrderCommand = new PlaceOrderCommand(orderManager, new Order(1, new Customer(1, "John Doe")));
        OrderCommand provideFeedbackCommand = new ProvideFeedbackCommand(feedbackManager,
                new Order(1, new Customer(1, "John Doe")), new Feedback(1, null, 5, "Great service!"));

        UserActionInvoker invoker = new UserActionInvoker();
        invoker.addToQueue(placeOrderCommand);
        invoker.addToQueue(provideFeedbackCommand);

        invoker.processCommands();
        scanner.close();
    }

    private static void displayMenu(Menu menu) {
        // Display menu options
        System.out.println("Flavors:");
        for (Flavor flavor : menu.getFlavors()) {
            System.out.println(flavor.getFlavorId() + ". " + flavor.getName());
        }

        System.out.println("Toppings:");
        for (Topping topping : menu.getToppings()) {
            System.out.println(topping.getToppingId() + ". " + topping.getName());
        }

        System.out.println("Syrups:");
        for (Syrup syrup : menu.getSyrups()) {
            System.out.println(syrup.getSyrupId() + ". " + syrup.getName());
        }

        System.out.println("Special Promotions:");
        for (SpecialPromotion promotion : menu.getSpecials()) {
            System.out.println(promotion.getName() + " - Discount: " + promotion.getDiscount());
            promotion.displayApplicableFlavors();
        }

    }

    // Get user choice for menu items
    private static int getUserChoice(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    private static int getUserQuantity(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    private static String getUserInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        scanner.nextLine();
        return scanner.nextLine();
    }

    // Display orders and their statuses
    private static void displayOrders(OrderManager orderManager) {
        System.out.println("Orders placed:");
        for (Order order : orderManager.getOrders()) {
            System.out.println("Order ID: " + order.getOrderId() + ", Status: " + order.getOrderStatus());
        }
    }
}
