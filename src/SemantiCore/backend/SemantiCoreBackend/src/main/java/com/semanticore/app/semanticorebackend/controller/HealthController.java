package com.semanticore.app.semanticorebackend.controller;

import com.semanticore.app.semanticorebackend.core.services.helper.ServiceHelper;
import com.semanticore.app.semanticorebackend.core.services.utilities.LoggingUtility;
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

    private final ServiceHelper serviceHelper;
    private final LoggingUtility loggingUtility;

    @Autowired
    public HealthController(ServiceHelper serviceHelper, LoggingUtility loggingUtility) {
        this.serviceHelper = serviceHelper;
        this.loggingUtility = loggingUtility;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> checkHealth() {
        Map<String, Object> healthStatus = new HashMap<>();  // Map for holding service health data
        loggingUtility.logInfo("Health check initiated.");

        try {
            // Use ServiceHelper to check all service statuses
            loggingUtility.logInfo("Using ServiceHelper to check the status of all services.");
            healthStatus.putAll(serviceHelper.checkAllServicesStatus());

            loggingUtility.logInfo("All services status successfully retrieved.");
        } catch (Exception e) {
            loggingUtility.logError("Error during health check: " + e.getMessage());
            healthStatus.put("error", e.getMessage());
        }

        loggingUtility.logInfo("Health check completed.");
        return new ResponseEntity<>(healthStatus, HttpStatus.OK);
    }
}
