package com.semanticore.app.semanticorebackend;

import com.semanticore.app.semanticorebackend.core.CoreApp;
import com.semanticore.app.semanticorebackend.core.services.utilities.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SemantiCoreBackendApplication implements CommandLineRunner {

    private final CoreApp coreApp;
    private final ConsoleService consoleService;

    @Autowired
    public SemantiCoreBackendApplication(CoreApp coreApp, ConsoleService consoleService) {
        this.coreApp = coreApp;
        this.consoleService = consoleService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SemantiCoreBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            // Display startup information using ConsoleService
            consoleService.displayWithSpinner("Starting CoreApp", "yellow");

            // Use CoreApp to initialize and start all services
            coreApp.start();

            // Log final success status
            // Stop the spinner after the work is done
            consoleService.stopSpinner();
            consoleService.displaySuccess("All services started successfully via CoreApp", "green");

        } catch (Exception e) {
            // Stop the spinner after the work is done
            consoleService.stopSpinner();
            consoleService.displayError("Error occurred during CoreApp startup: " + e.getMessage(), "red");
            throw e; // rethrow the exception if needed
        }
    }
}
