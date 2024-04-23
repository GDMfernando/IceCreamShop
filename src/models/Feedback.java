/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author acer
 */
// Represents feedback provided by a customer for a specific order
public class Feedback {
    private int feedbackId;
    private Order order;
    private int rating;
    private String comments;

    // Constructor to initialize feedback details
    public Feedback(int feedbackId, Order order, int rating, String comments) {
        this.feedbackId = feedbackId;
        this.order = order;
        this.rating = rating;
        this.comments = comments;
    }

    public int getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }
}
