package com.semanticore.app.semanticorebackend.startup;



import org.fusesource.jansi.AnsiConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;

@Configuration
public class StartupConfig {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private JdbcTemplate jdbcTemplate; // Used to test H2 database connection

    @Bean
    public ApplicationRunner displayStartupSequence() {
        return args -> {
            AnsiConsole.systemInstall(); // Enable color support for the console

            // Start services first
            startServiceWithColor("H2 Database Connection", this::testH2DatabaseConnection);
            startServiceWithColor("Service1", null);
            startServiceWithColor("Service2", null);
            startServiceWithColor("Service3", null);

            // Once all services are running, start the backend and listen for requests
            System.out.println(ansi().fgGreen().a("All services are up and running!").reset());
            System.out.println(ansi().fgYellow().a("Backend Application starting...").reset());
            System.out.println(ansi().fgGreen().a("Backend Application listening on port " + serverPort).reset());
            System.out.println(ansi().fgGreen().a("Swagger running on port " + serverPort + "/swagger-ui.html").reset());
            System.out.println(ansi().fgGreen().a("Application is waiting for requests...").reset());

            // Keep application running until stopped
            runUntilStopped();
        };
    }

    // Function to simulate service startup with colored output
    private void startServiceWithColor(String serviceName, Runnable testTask) throws InterruptedException {
        System.out.println(ansi().fgYellow().a(serviceName + " starting...").reset());

        if (testTask != null) {
            testTask.run(); // Run the task (e.g., H2 database connection test)
        } else {
            Thread.sleep(2000); // Simulate service startup delay
        }

        System.out.println(ansi().fgGreen().a(serviceName + " running...!").reset());
    }

    // Function to test the H2 database connection
    private void testH2DatabaseConnection() {
        try {
            jdbcTemplate.execute("SELECT 1");
            System.out.println(ansi().fgGreen().a("H2 Database connection successful.").reset());
        } catch (Exception e) {
            System.out.println(ansi().fgRed().a("H2 Database connection failed: " + e.getMessage()).reset());
        }
    }

    // Function to keep the application running until a stop command is issued
    private void runUntilStopped() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 'stop' to stop the application.");
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

    // Function to print request logs when a request is received
    public void logRequest(String method, String path) {
        System.out.println(ansi().fgCyan().a("Received request: " + method + " " + path).reset());
    }
}
