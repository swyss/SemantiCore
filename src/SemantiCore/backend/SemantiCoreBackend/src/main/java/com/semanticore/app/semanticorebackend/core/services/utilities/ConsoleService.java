package com.semanticore.app.semanticorebackend.core.services.utilities;

import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Service
public class ConsoleService {

    private static final String SPINNER = "|/-\\"; // Spinner symbols
    private static final int SPINNER_DELAY = 100; // Delay in milliseconds for spinner
    private ScheduledExecutorService scheduler;

    // Method to display a message with a rotating spinner in the console
    public void displayWithSpinner(String message, String color) {
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new Runnable() {
            private int index = 0;

            @Override
            public void run() {
                System.out.print("\r" + applyColor(SPINNER.charAt(index % SPINNER.length()) + " " + message, color));
                index++;
            }
        }, 0, SPINNER_DELAY, TimeUnit.MILLISECONDS);
    }

    // Method to stop the spinner
    public void stopSpinner() {
        if (scheduler != null) {
            scheduler.shutdownNow();  // Stop the spinner thread
            System.out.println();  // Move to the next line after spinner is stopped
        }
    }

    // Method to display a success message with a checkmark
    public void displaySuccess(String message, String color) {
        System.out.println(applyColor("[✔] " + message, color));
    }

    // Method to display an error message with a cross symbol
    public void displayError(String message, String color) {
        System.out.println(applyColor("[✘] " + message, color));
    }

    // Apply color to the message
    private String applyColor(String message, String color) {
        return switch (color.toLowerCase()) {
            case "yellow" -> "\033[0;33m" + message + "\033[0m"; // Yellow color
            case "green" -> "\033[0;32m" + message + "\033[0m"; // Green color
            case "red" -> "\033[0;31m" + message + "\033[0m"; // Red color
            case "blue" -> "\033[0;34m" + message + "\033[0m"; // Blue color
            default -> message; // Default: No color
        };
    }
}
