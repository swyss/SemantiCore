package com.semanticore.app.semanticorebackend.controller;


import com.semanticore.app.semanticorebackend.core.services.utilities.LoggingUtility;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final LoggingUtility loggingUtility;

    public HomeController(LoggingUtility loggingUtility) {
        this.loggingUtility = loggingUtility;
    }

    @GetMapping("/home")
    public String home() {
        loggingUtility.logInfo("Request received on /home endpoint");
        loggingUtility.logWithSpinner("Processing home request");

        // Simulate processing time
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            loggingUtility.logError("Error during request processing");
        }

        loggingUtility.stopSpinner();
        loggingUtility.logInfo("Home request processed successfully");
        return "Welcome to the home page!";
    }
}

