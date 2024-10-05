package com.semanticore.app.semanticorebackend.controller.core;


import com.semanticore.app.semanticorebackend.core.utilities.LoggingUtility;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Tag(name = "Home Controller", description = "API for accessing the home page.")
public class HomeController {

    private final LoggingUtility loggingUtility;

    public HomeController(LoggingUtility loggingUtility) {
        this.loggingUtility = loggingUtility;
    }

    @GetMapping("/home")
    @Operation(summary = "Access the home page", description = "Returns a welcome message after processing the request.")
    public String home() {
        loggingUtility.logInfo("Request received on /home endpoint");
        loggingUtility.logWithSpinner("Processing home request...");

        // Simulate processing time
        try {
            Thread.sleep(2000); // Simulates some work being done
        } catch (InterruptedException e) {
            loggingUtility.logError("Error during request processing: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore interrupted status
        }

        loggingUtility.stopSpinner(); // Stop the spinner once processing is done
        loggingUtility.logInfo("Home request processed successfully");
        return "Welcome to the home page!";
    }
}

