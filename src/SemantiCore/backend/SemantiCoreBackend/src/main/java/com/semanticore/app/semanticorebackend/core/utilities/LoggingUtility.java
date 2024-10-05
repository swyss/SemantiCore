package com.semanticore.app.semanticorebackend.core.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoggingUtility {

    private final ConsoleService consoleService;

    @Autowired
    public LoggingUtility(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    // Log an info message
    public void logInfo(String message) {
        consoleService.displaySuccess("[INFO]: " + message, "blue");
    }

    // Log an error message
    public void logError(String message) {
        consoleService.displayError("[ERROR]: " + message, "red");
    }

    // Log a debug message
    public void logSuccess(String message) {
        consoleService.displaySuccess("[DEBUG]: " + message, "yellow");
    }

    // Log with spinner for a dynamic, rotating spinner during long operations
    public void logWithSpinner(String message) {
        consoleService.displayWithSpinner(message, "blue");
    }

    // Stop the spinner after the process is done
    public void stopSpinner() {
        consoleService.stopSpinner();
    }

}
