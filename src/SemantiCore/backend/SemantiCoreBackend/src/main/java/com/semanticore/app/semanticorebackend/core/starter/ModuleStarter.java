package com.semanticore.app.semanticorebackend.core.starter;


import com.semanticore.app.semanticorebackend.core.utilities.ConsoleService;
import com.semanticore.app.semanticorebackend.modules.analytics.AnalyticsService;
import com.semanticore.app.semanticorebackend.modules.calculations.CalculationService;
import com.semanticore.app.semanticorebackend.modules.data.DataIntegrationService;
import com.semanticore.app.semanticorebackend.modules.data.DataStorageService;
import com.semanticore.app.semanticorebackend.modules.edge.EdgeDeviceService;
import com.semanticore.app.semanticorebackend.modules.event.EventProcessingService;
import com.semanticore.app.semanticorebackend.modules.monitoring.MonitoringService;
import com.semanticore.app.semanticorebackend.modules.scada.SCADAIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ModuleStarter {

    private final AnalyticsService analyticsService;
    private final DataIntegrationService dataIntegrationService;
    private final DataStorageService dataStorageService;
    private final EdgeDeviceService edgeDeviceService;
    private final EventProcessingService eventProcessingService;
    private final MonitoringService monitoringService;
    private final SCADAIntegrationService scadaIntegrationService;
    private final ConsoleService consoleService;

    @Autowired
    public ModuleStarter(AnalyticsService analyticsService,
                         DataIntegrationService dataIntegrationService,
                         DataStorageService dataStorageService,
                         EdgeDeviceService edgeDeviceService,
                         EventProcessingService eventProcessingService,
                         MonitoringService monitoringService,
                         CalculationService calculationService,
                         SCADAIntegrationService scadaIntegrationService, ConsoleService consoleService) {
        this.analyticsService = analyticsService;
        this.dataIntegrationService = dataIntegrationService;
        this.dataStorageService = dataStorageService;
        this.edgeDeviceService = edgeDeviceService;
        this.eventProcessingService = eventProcessingService;
        this.monitoringService = monitoringService;
        this.scadaIntegrationService = scadaIntegrationService;
        this.consoleService = consoleService;
    }

    // Method to start all modules
    public void startAllModules() {
        analyticsService.start();
        dataIntegrationService.start();
        dataStorageService.start();
        edgeDeviceService.start();
        eventProcessingService.start();
        monitoringService.start();
        scadaIntegrationService.start();
    }

    // Method to stop all modules
    public void stopAllModules() {
        analyticsService.stop();
        dataIntegrationService.stop();
        dataStorageService.stop();
        edgeDeviceService.stop();
        eventProcessingService.stop();
        monitoringService.stop();
        scadaIntegrationService.stop();
    }

    public Map<String, String> checkAllServicesStatus() {
        Map<String, String> serviceStatus = new HashMap<>();

        // Gather status of each service and log the information
        consoleService.displayWithColor("Checking Data Integration Service status...", "yellow");
        consoleService.displayWithColor("Data Integration Service status: " + dataIntegrationService.getStatus().toString(), "cyan");
        serviceStatus.put("DataIntegrationService", dataIntegrationService.getStatus().toString());
        consoleService.displayWithColor("Checking Monitoring Service status...", "yellow");
        consoleService.displayWithColor("Monitoring Service status: " + monitoringService.getStatus().toString(), "cyan");
        serviceStatus.put("MonitoringService", monitoringService.getStatus().toString());
        consoleService.displayWithColor("Checking Data Storage Service status...", "yellow");
        consoleService.displayWithColor("Data Storage Service status: " + dataStorageService.getStatus().toString(), "cyan");
        serviceStatus.put("DataStorageService", dataStorageService.getStatus().toString());
        consoleService.displayWithColor("Checking Edge Device Service status...", "yellow");
        consoleService.displayWithColor("Edge Device Service status: " + edgeDeviceService.getStatus().toString(), "cyan");
        serviceStatus.put("EdgeDeviceService", edgeDeviceService.getStatus().toString());
        consoleService.displayWithColor("Checking Event Processing Service status...", "yellow");
        consoleService.displayWithColor("Event Processing Service status: " + eventProcessingService.getStatus().toString(), "cyan");
        serviceStatus.put("EventProcessingService", eventProcessingService.getStatus().toString());
        consoleService.displayWithColor("Checking SCADA Integration Service status...", "yellow");
        consoleService.displayWithColor("SCADA Integration Service status: " + scadaIntegrationService.getStatus().toString(), "cyan");
        serviceStatus.put("SCADAIntegrationService", scadaIntegrationService.getStatus().toString());
        consoleService.displayWithColor("Checking Analytics Service status...", "yellow");
        consoleService.displayWithColor("Analytics Service status: " + analyticsService.getStatus().toString(), "cyan");
        serviceStatus.put("AnalyticsService", analyticsService.getStatus().toString());

        return serviceStatus;
    }
}
