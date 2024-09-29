package com.semanticore.app.semanticorebackend.startup;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class StartupConfig {

    // Inject the server port from application properties
    @Value("${server.port}")
    private String serverPort;

    @Bean
    public ApplicationRunner displayStartupSequence() {
        return args -> {
            // Display ASCII art first
            printAsciiArt();

            // Display Swagger and Backend service details with their ports
            System.out.println("Swagger running on port " + serverPort + "/swagger-ui.html");
            System.out.println("Backend Application listening on port " + serverPort);

            // Indicate that the application is waiting for requests
            System.out.println("Application is waiting for requests...");

            // Simulate other services with a spinner
            startServiceWithSpinner("Service1");
            startServiceWithSpinner("Service2");
            startServiceWithSpinner("Service3");

            System.out.println("All services are up and running!");
            // Keep application running until a stop command is issued
            runUntilStopped();
        };
    }

    // Function to simulate service startup with a spinner
    private void startServiceWithSpinner(String serviceName) throws InterruptedException {
        System.out.println(serviceName + " starting...");
        Thread spinner = new Thread(new Spinner());
        spinner.start(); // Start the spinner animation

        Thread.sleep(2000); // Simulate service startup delay

        spinner.interrupt(); // Stop the spinner after delay
        System.out.println(serviceName + " running...!");
    }

    // Spinner class to display a rotating spinner
    private class Spinner implements Runnable {
        private final String[] spinnerChars = {"|", "/", "-", "\\"};

        @Override
        public void run() {
            int i = 0;
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.print("\r" + spinnerChars[i++ % spinnerChars.length] + " ");
                    Thread.sleep(200); // Adjust speed of the spinner
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Safely exit the spinner
            }
        }
    }

    // Function to print ASCII art
    private void printAsciiArt() {
        System.out.println("  _____                                 _  _____              ");
        System.out.println(" / ____|                               (_)/ ____|             ");
        System.out.println("| (___   ___  ___ _   _ _ __ ___   __ _ _| |     ___  _ __ ___ ");
        System.out.println(" \\___ \\ / _ \\/ __| | | | '_ ` _ \\ / _` | | |    / _ \\| '__/ _ \\");
        System.out.println(" ____) |  __/ (__| |_| | | | | | | (_| | | |___| (_) | | |  __/");
        System.out.println("|_____/ \\___|\\___|\\__,_|_| |_| |_|\\__,_|_|\\_____\\___/|_|  \\___|");
    }

    // Function to keep the application running until a stop command is issued
    private void runUntilStopped() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Application is running. Type 'stop' to stop the application.");

        while (true) {
            String command = scanner.nextLine();
            if ("stop".equalsIgnoreCase(command)) {
                System.out.println("Stopping application...");
                System.exit(0);
            } else {
                System.out.println("Invalid command. Type 'stop' to stop the application.");
            }
        }
    }
}
