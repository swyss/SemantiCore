package com.semanticore.app.semanticorebackend.core.starter;


import com.semanticore.app.semanticorebackend.core.services.ConfigurationLoaderService;
import com.semanticore.app.semanticorebackend.core.utilities.LoggingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoreServiceStarter {

    private final ConfigurationLoaderService configurationLoaderService;
    private final LoggingUtility loggingUtility;

    @Autowired
    public CoreServiceStarter(ConfigurationLoaderService configurationLoaderService,
                              LoggingUtility loggingUtility) {
        this.configurationLoaderService = configurationLoaderService;
        this.loggingUtility = loggingUtility;
    }

    // Method to start all core services
    public void startCoreServices() {
        loggingUtility.logInfo("Starting Core...");
        configurationLoaderService.validateConfiguration();
    }

    // Method to stop all core services
    public void stopCoreServices() {
        loggingUtility.logInfo("Stopping Core...");
    }
}