/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import enums.OrderStatus;
import interfaces.OrderStatusObserver;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author acer
 */
public class FeedbackManager implements OrderStatusObserver {

    private List<Feedback> feedbackList;

    public FeedbackManager() {
        this.feedbackList = new ArrayList<>();
    }
    // Implementation of feedback management methods

    public void provideFeedback(Order order, Feedback feedback) {
        // Implementation of handling customer feedback
        if (order != null && feedback != null) {
            feedbackList.add(feedback);
            System.out.println("Thank you for your feedback!");
        } else {
            System.out.println("Invalid order or feedback provided.");
        }
    }

    @Override
    public void update(Order order) {
        // Notify users about order status changes and handle feedback
        if (order.getOrderStatus() == OrderStatus.DELIVERED) {
            Feedback feedback = collectFeedback(order);
            provideFeedback(order, feedback);
        }
    }

    private Feedback collectFeedback(Order order) {
        // Simulate collecting feedback from the user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please rate your experience (1-5): ");
        int rating = scanner.nextInt();

        System.out.print("Any additional comments? ");
        scanner.nextLine(); // Consume the newline
        String comments = scanner.nextLine();

        // Close the scanner
        scanner.close();

        return new Feedback(feedbackList.size() + 1, order, rating, comments);
    }
}
