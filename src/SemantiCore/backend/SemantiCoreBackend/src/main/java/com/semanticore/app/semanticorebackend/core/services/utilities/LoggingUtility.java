package com.semanticore.app.semanticorebackend.core.services.utilities;

import org.springframework.stereotype.Component;

@Component // Mark it as a Spring-managed bean
public class LoggingUtility {

    public void logInfo(String message) {
        System.out.println("[INFO]: " + message);
    }

    public void logError(String message) {
        System.err.println("[ERROR]: " + message);
    }

    public void logDebug(String message) {
        System.out.println("[DEBUG]: " + message);
    }
}
