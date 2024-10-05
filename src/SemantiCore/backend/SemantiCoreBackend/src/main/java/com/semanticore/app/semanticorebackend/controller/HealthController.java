package com.semanticore.app.semanticorebackend.controller;

import com.semanticore.app.semanticorebackend.core.services.ConfigurationLoaderService;
import com.semanticore.app.semanticorebackend.core.services.ServiceHealthChecker;
import com.semanticore.app.semanticorebackend.core.starter.StarterService;
import com.semanticore.app.semanticorebackend.modules.data.DataIntegrationService;
import com.semanticore.app.semanticorebackend.modules.monitoring.MonitoringService;
import com.semanticore.app.semanticorebackend.modules.oee.OEECalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    private final ConfigurationLoaderService configurationLoaderService;
    private final DataIntegrationService dataIntegrationService;
    private final MonitoringService monitoringService;
    private final OEECalculationService oeeCalculationService;
    private final StarterService starterService;

    @Autowired
    public HealthController(ServiceHealthChecker serviceHealthChecker,
                            ConfigurationLoaderService configurationLoaderService,
                            DataIntegrationService dataIntegrationService,
                            MonitoringService monitoringService,
                            OEECalculationService oeeCalculationService,
                            StarterService starterService) {
        this.configurationLoaderService = configurationLoaderService;
        this.dataIntegrationService = dataIntegrationService;
        this.monitoringService = monitoringService;
        this.oeeCalculationService = oeeCalculationService;
        this.starterService = starterService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> checkHealth() {
        Map<String, Object> healthStatus = new HashMap<>();

        // Example: Checking service health using ServiceHealthChecker
        try {
            starterService.checkAllServicesStatus();  // Check the status of all services

            // Simulate status based on the fact that configuration is validated
            configurationLoaderService.validateConfiguration();
            healthStatus.put("ConfigurationLoaderService", "Valid");

            healthStatus.put("DataIntegrationService", dataIntegrationService.getStatus());
            healthStatus.put("MonitoringService", monitoringService.getStatus());
            healthStatus.put("OEECalculationService", oeeCalculationService.getStatus());
        } catch (Exception e) {
            healthStatus.put("error", e.getMessage());
        }

        return new ResponseEntity<>(healthStatus, HttpStatus.OK);
    }
}
