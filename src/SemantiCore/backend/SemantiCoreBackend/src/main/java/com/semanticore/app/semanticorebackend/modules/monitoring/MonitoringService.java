package com.semanticore.app.semanticorebackend.modules.monitoring;

import com.semanticore.app.semanticorebackend.core.services.model.ServiceStatus;
import com.semanticore.app.semanticorebackend.core.services.model.ServiceTemplate;
import org.springframework.stereotype.Service;

@Service
public class MonitoringService implements ServiceTemplate {

    private ServiceStatus status = ServiceStatus.STOPPED;

    @Override
    public void start() {
        System.out.println("Starting Monitoring Service...");
        // Logic to start the service
        status = ServiceStatus.RUNNING;
        System.out.println("Monitoring Service started.");
    }

    @Override
    public void stop() {
        System.out.println("Stopping Monitoring Service...");
        // Logic to stop the service
        status = ServiceStatus.STOPPED;
        System.out.println("Monitoring Service stopped.");
    }

    @Override
    public ServiceStatus getStatus() {
        return status;
    }
}

