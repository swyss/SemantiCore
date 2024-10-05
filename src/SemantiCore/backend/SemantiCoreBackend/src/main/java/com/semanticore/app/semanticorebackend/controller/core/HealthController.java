package com.semanticore.app.semanticorebackend.controller.core;

import com.semanticore.app.semanticorebackend.core.starter.CoreServiceStarter;
import com.semanticore.app.semanticorebackend.core.starter.ModuleStarter;
import com.semanticore.app.semanticorebackend.core.utilities.LoggingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    private final ModuleStarter moduleStarter;
    private final CoreServiceStarter coreServiceStarter;
    private final LoggingUtility loggingUtility;

    @Autowired
    public HealthController(ModuleStarter moduleStarter, CoreServiceStarter coreServiceStarter, LoggingUtility loggingUtility) {
        this.moduleStarter = moduleStarter;
        this.coreServiceStarter = coreServiceStarter;
        this.loggingUtility = loggingUtility;
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> checkHealth() {
        loggingUtility.logInfo("Health check initiated.");

        // Use ServiceHelper to gather the status of all services
        Map<String, String> healthStatus = moduleStarter.checkAllServicesStatus();

        loggingUtility.logSuccess("Health check completed. Module-Services status retrieved.");

        return new ResponseEntity<>(healthStatus, HttpStatus.OK);
    }
}
