package com.semanticore.app.semanticorebackend.core.starter;

import com.semanticore.app.semanticorebackend.modules.data.DataIntegrationService;
import com.semanticore.app.semanticorebackend.modules.monitoring.MonitoringService;
import com.semanticore.app.semanticorebackend.modules.oee.OEECalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarterService {

    private final MonitoringService monitoringService;
    private final DataIntegrationService dataIntegrationService;
    private final OEECalculationService oeeCalculationService;

    // Constructor-based dependency injection
    @Autowired
    public StarterService(MonitoringService monitoringService,
                          DataIntegrationService dataIntegrationService,
                          OEECalculationService oeeCalculationService) {

        this.monitoringService = monitoringService;
        this.dataIntegrationService = dataIntegrationService;
        this.oeeCalculationService = oeeCalculationService;
    }

    // Method to start all services
    public void startAllServices() {
        System.out.println("Starting Data Integration Service...");
        dataIntegrationService.start();

        System.out.println("Starting Monitoring Service...");
        monitoringService.start();

        System.out.println("Starting OEE Calculation Service...");
        oeeCalculationService.start();

        System.out.println("All services have been started successfully.");
    }

    // Method to stop all services (optional)
    public void stopAllServices() {
        // Add stop logic if needed
        System.out.println("All services have been stopped.");
    }

    // Method to check the status of all services
    public void checkAllServicesStatus() {
        System.out.println("Checking Data Integration Service status...");
        System.out.println("Checking Data Integration Service: "+ dataIntegrationService.getStatus().toString());

        System.out.println("Checking Monitoring Service status...");
        System.out.println("Checking Monitoring Service: "+monitoringService.getStatus().toString());

        System.out.println("Checking OEE Calculation Service status...");
        System.out.println("Checking OEE Calculation Service: "+oeeCalculationService.getStatus().toString());

        System.out.println("All services status checked.");
    }
}
