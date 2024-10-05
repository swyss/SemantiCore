package com.semanticore.app.semanticorebackend.core;

import com.semanticore.app.semanticorebackend.core.services.ConfigurationLoaderService;
import com.semanticore.app.semanticorebackend.core.services.ServiceHealthChecker;
import com.semanticore.app.semanticorebackend.core.services.utilities.CommonUtilities;
import com.semanticore.app.semanticorebackend.core.services.utilities.ConsoleService;
import com.semanticore.app.semanticorebackend.core.services.utilities.LoggingUtility;
import com.semanticore.app.semanticorebackend.core.starter.StarterService;
import com.semanticore.app.semanticorebackend.modules.analytics.AnalyticsService;
import com.semanticore.app.semanticorebackend.modules.data.DataStorageService;
import com.semanticore.app.semanticorebackend.modules.edge.EdgeDeviceService;
import com.semanticore.app.semanticorebackend.modules.event.EventProcessingService;
import com.semanticore.app.semanticorebackend.modules.scada.SCADAIntegrationService;
import com.semanticore.app.semanticorebackend.semanticdata.DataEnrichmentService;
import com.semanticore.app.semanticorebackend.semanticdata.OntologyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoreApp {

    private final StarterService starterService;
    private final ConfigurationLoaderService configurationLoaderService;
    private final ServiceHealthChecker serviceHealthChecker;
    private final ConsoleService consoleService;
    private final AnalyticsService analyticsService;
    private final DataStorageService dataStorageService;
    private final EdgeDeviceService edgeDeviceService;
    private final EventProcessingService eventProcessingService;
    private final SCADAIntegrationService scadaIntegrationService;
    private final DataEnrichmentService dataEnrichmentService;
    private final OntologyManager ontologyManager;
    private final LoggingUtility loggingUtility;

    @Autowired
    public CoreApp(StarterService starterService, ConfigurationLoaderService configurationLoaderService,
                   ServiceHealthChecker serviceHealthChecker, ConsoleService consoleService,
                   AnalyticsService analyticsService, DataStorageService dataStorageService,
                   EdgeDeviceService edgeDeviceService, EventProcessingService eventProcessingService,
                   SCADAIntegrationService scadaIntegrationService,
                   DataEnrichmentService dataEnrichmentService, OntologyManager ontologyManager,
                   LoggingUtility loggingUtility) {
        this.starterService = starterService;
        this.configurationLoaderService = configurationLoaderService;
        this.serviceHealthChecker = serviceHealthChecker;
        this.consoleService = consoleService;
        this.analyticsService = analyticsService;
        this.dataStorageService = dataStorageService;
        this.edgeDeviceService = edgeDeviceService;
        this.eventProcessingService = eventProcessingService;
        this.scadaIntegrationService = scadaIntegrationService;
        this.dataEnrichmentService = dataEnrichmentService;
        this.ontologyManager = ontologyManager;
        this.loggingUtility = loggingUtility; // Assign LoggingUtility
    }

    // Main method to start all services
    public void start() {
        try {
            // Log startup info using LoggingUtility
            loggingUtility.logInfo("Starting CoreApp...");

            // Display startup information with timestamp and UUID using CommonUtilities
            String timestamp = CommonUtilities.getCurrentDate("yyyy-MM-dd HH:mm:ss");
            String uuid = CommonUtilities.generateUUID();
            System.out.println("Starting CoreApp at: " + timestamp + " with UUID: " + uuid);

            consoleService.displayWithSpinner("Initializing CoreApp...", "yellow");

            // Validate configuration
            configurationLoaderService.validateConfiguration();

            // Start all core services
            starterService.startAllServices();

            // Start individual services
            analyticsService.start();
            dataStorageService.start();
            edgeDeviceService.start();
            eventProcessingService.start();
            scadaIntegrationService.start();
            dataEnrichmentService.start();
            ontologyManager.start();

            // Check the health of the services
            serviceHealthChecker.checkServiceHealth("http://localhost:8088");

            // Log final status
            loggingUtility.logInfo("CoreApp: All services started and healthy.");
            consoleService.displaySuccess("CoreApp: All services started and healthy.", "green");

        } catch (Exception e) {
            loggingUtility.logError("Error during CoreApp startup: " + e.getMessage());
            consoleService.displaySuccess("Error during CoreApp startup: " + e.getMessage(), "red");
            throw e;
        }
    }

    // Method to stop all services
    public void stop() {
        // Log the timestamp when stopping services
        String timestamp = CommonUtilities.getCurrentDate("yyyy-MM-dd HH:mm:ss");
        loggingUtility.logInfo("Stopping CoreApp at: " + timestamp);

        consoleService.displayWithSpinner("Stopping CoreApp services...", "yellow");

        // Stop all services
        starterService.stopAllServices();
        analyticsService.stop();
        dataStorageService.stop();
        edgeDeviceService.stop();
        eventProcessingService.stop();
        scadaIntegrationService.stop();
        dataEnrichmentService.stop();
        ontologyManager.stop();

        loggingUtility.logInfo("CoreApp: All services stopped.");
        consoleService.displaySuccess("CoreApp: All services stopped.", "green");
    }
}