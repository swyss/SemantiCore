package com.semanticore.app.semanticorebackend.core.utilities;

import org.springframework.stereotype.Service;


@Service
public class ConsoleService {

    private static final String SPINNER = "|/-\\"; // Spinner symbols
    private volatile boolean running = false; // Used to stop the spinner

    // Method to display a message with a color
    public void displayWithColor(String message, String color) {
        System.out.println(applyColor(message, color));
    }

    public void displayWithSpinner(String message, String color) {
        running = true; // Start the spinner
        System.out.print(applyColor(message, color));

        new Thread(() -> {
            int i = 0;
            while (running) {
                System.out.print("\r" + applyColor(SPINNER.charAt(i % SPINNER.length()) + " " + message, color));
                i++;
                try {
                    Thread.sleep(100); // Spinner speed
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }

    public void stopSpinner() {
        running = false; // Stop the spinner
        System.out.print("\r"); // Clear spinner line
    }

    public void displaySuccess(String message, String color) {
        stopSpinner(); // Stop the spinner when successful
        System.out.println(applyColor("[✔] " + message, color));
    }

    public void displayError(String message, String color) {
        stopSpinner(); // Stop the spinner if there's an error
        System.out.println(applyColor("[✘] " + message, color));
    }

    private String applyColor(String message, String color) {
        return switch (color.toLowerCase()) {
            case "yellow" -> "\033[0;33m" + message + "\033[0m";
            case "green" -> "\033[0;32m" + message + "\033[0m";
            case "red" -> "\033[0;31m" + message + "\033[0m";
            case "blue" -> "\033[0;34m" + message + "\033[0m";
            case "cyan" -> "\033[0;36m" + message + "\033[0m";
            case "magenta" -> "\033[0;35m" + message + "\033[0m";
            case "white" -> "\033[0;37m" + message + "\033[0m";
            default -> message; // No color
        };
    }
}
