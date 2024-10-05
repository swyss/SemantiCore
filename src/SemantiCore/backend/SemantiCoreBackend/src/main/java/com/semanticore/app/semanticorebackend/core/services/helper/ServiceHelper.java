package com.semanticore.app.semanticorebackend.core.services.helper;


import com.semanticore.app.semanticorebackend.core.services.utilities.ConsoleService;
import com.semanticore.app.semanticorebackend.modules.analytics.AnalyticsService;
import com.semanticore.app.semanticorebackend.modules.data.DataIntegrationService;
import com.semanticore.app.semanticorebackend.modules.data.DataStorageService;
import com.semanticore.app.semanticorebackend.modules.edge.EdgeDeviceService;
import com.semanticore.app.semanticorebackend.modules.event.EventProcessingService;
import com.semanticore.app.semanticorebackend.modules.monitoring.MonitoringService;
import com.semanticore.app.semanticorebackend.modules.oee.OEECalculationService;
import com.semanticore.app.semanticorebackend.modules.scada.SCADAIntegrationService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ServiceHelper {

    private final MonitoringService monitoringService;
    private final DataIntegrationService dataIntegrationService;
    private final OEECalculationService oeeCalculationService;
    private final DataStorageService dataStorageService;
    private final EdgeDeviceService edgeDeviceService;
    private final EventProcessingService eventProcessingService;
    private final SCADAIntegrationService scadaIntegrationService;
    private final AnalyticsService analyticsService;
    private final ConsoleService consoleService;

    public ServiceHelper(MonitoringService monitoringService,
                         DataIntegrationService dataIntegrationService,
                         OEECalculationService oeeCalculationService,
                         DataStorageService dataStorageService,
                         EdgeDeviceService edgeDeviceService,
                         EventProcessingService eventProcessingService,
                         SCADAIntegrationService scadaIntegrationService,
                         AnalyticsService analyticsService,
                         ConsoleService consoleService) {
        this.monitoringService = monitoringService;
        this.dataIntegrationService = dataIntegrationService;
        this.oeeCalculationService = oeeCalculationService;
        this.dataStorageService = dataStorageService;
        this.edgeDeviceService = edgeDeviceService;
        this.eventProcessingService = eventProcessingService;
        this.scadaIntegrationService = scadaIntegrationService;
        this.analyticsService = analyticsService;
        this.consoleService = consoleService;
    }

    public void startAllServices() {
        dataIntegrationService.start();
        monitoringService.start();
        oeeCalculationService.start();
        dataStorageService.start();
        edgeDeviceService.start();
        eventProcessingService.start();
        scadaIntegrationService.start();
        analyticsService.start();

        // Final success message
        consoleService.displaySuccess("CoreApp and all services started successfully!", "green");
    }

    public Map<String, String> checkAllServicesStatus() {
        Map<String, String> serviceStatus = new HashMap<>();

        // Service statuses are already logged in their respective classes (via AbstractService)
        serviceStatus.put("DataIntegrationService", dataIntegrationService.getStatus().toString());
        serviceStatus.put("MonitoringService", monitoringService.getStatus().toString());
        serviceStatus.put("OEECalculationService", oeeCalculationService.getStatus().toString());
        serviceStatus.put("DataStorageService", dataStorageService.getStatus().toString());
        serviceStatus.put("EdgeDeviceService", edgeDeviceService.getStatus().toString());
        serviceStatus.put("EventProcessingService", eventProcessingService.getStatus().toString());
        serviceStatus.put("SCADAIntegrationService", scadaIntegrationService.getStatus().toString());
        serviceStatus.put("AnalyticsService", analyticsService.getStatus().toString());

        return serviceStatus;
    }
}