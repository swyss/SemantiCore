package com.semanticore.app.semanticorebackend.modules.data;

import com.semanticore.app.semanticorebackend.core.services.model.ServiceStatus;
import com.semanticore.app.semanticorebackend.core.services.model.ServiceTemplate;
import org.springframework.stereotype.Service;

@Service
public class DataIntegrationService implements ServiceTemplate {

    private ServiceStatus status = ServiceStatus.STOPPED;

    @Override
    public void start() {
        System.out.println("Starting Data Integration Service...");
        // Logic to start the service
        status = ServiceStatus.RUNNING;
        System.out.println("Data Integration Service started.");
    }

    @Override
    public void stop() {
        System.out.println("Stopping Data Integration Service...");
        // Logic to stop the service
        status = ServiceStatus.STOPPED;
        System.out.println("Data Integration Service stopped.");
    }

    @Override
    public ServiceStatus getStatus() {
        return status;
    }
}