package com.semanticore.app.semanticorebackend.modules;


import com.semanticore.app.semanticorebackend.modules.analytics.AnalyticsService;
import com.semanticore.app.semanticorebackend.modules.data.DataIntegrationService;
import com.semanticore.app.semanticorebackend.modules.data.DataStorageService;
import com.semanticore.app.semanticorebackend.modules.edge.EdgeDeviceService;
import com.semanticore.app.semanticorebackend.modules.event.EventProcessingService;
import com.semanticore.app.semanticorebackend.modules.monitoring.MonitoringService;
import com.semanticore.app.semanticorebackend.modules.oee.OEECalculationService;
import com.semanticore.app.semanticorebackend.modules.scada.SCADAIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModuleStarter {

    private final AnalyticsService analyticsService;
    private final DataIntegrationService dataIntegrationService;
    private final DataStorageService dataStorageService;
    private final EdgeDeviceService edgeDeviceService;
    private final EventProcessingService eventProcessingService;
    private final MonitoringService monitoringService;
    private final OEECalculationService oeeCalculationService;
    private final SCADAIntegrationService scadaIntegrationService;

    @Autowired
    public ModuleStarter(AnalyticsService analyticsService,
                         DataIntegrationService dataIntegrationService,
                         DataStorageService dataStorageService,
                         EdgeDeviceService edgeDeviceService,
                         EventProcessingService eventProcessingService,
                         MonitoringService monitoringService,
                         OEECalculationService oeeCalculationService,
                         SCADAIntegrationService scadaIntegrationService) {
        this.analyticsService = analyticsService;
        this.dataIntegrationService = dataIntegrationService;
        this.dataStorageService = dataStorageService;
        this.edgeDeviceService = edgeDeviceService;
        this.eventProcessingService = eventProcessingService;
        this.monitoringService = monitoringService;
        this.oeeCalculationService = oeeCalculationService;
        this.scadaIntegrationService = scadaIntegrationService;
    }

    // Method to start all modules
    public void startAllModules() {
        analyticsService.start();
        dataIntegrationService.start();
        dataStorageService.start();
        edgeDeviceService.start();
        eventProcessingService.start();
        monitoringService.start();
        oeeCalculationService.start();
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
        oeeCalculationService.stop();
        scadaIntegrationService.stop();
    }
}
