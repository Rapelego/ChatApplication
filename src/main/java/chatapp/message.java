/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp;

/**
 *
 * @author User
 */
public class message {
     // Array to store messages
    private String[] messages = new String[5];

    // Counter to track number of messages
    private int messageCount = 0;

    /**
     * Adds a message to the array
     */
    public void addMessage(String message) {
        if (messageCount < messages.length) {
            messages[messageCount] = message;
            messageCount++;
        } else {
            System.out.println("Message storage is full.");
        }
    }

    /**
     * Displays all stored messages
     */
    public void displayMessages() {
        for (int i = 0; i < messageCount; i++) {
            System.out.println("Message " + (i + 1) + ": " + messages[i]);
        }
    }
}
