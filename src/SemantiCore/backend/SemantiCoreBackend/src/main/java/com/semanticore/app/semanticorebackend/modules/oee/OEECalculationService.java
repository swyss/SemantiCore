package com.semanticore.app.semanticorebackend.modules.oee;

import com.semanticore.app.semanticorebackend.core.services.model.ServiceStatus;
import com.semanticore.app.semanticorebackend.core.services.model.ServiceTemplate;
import org.springframework.stereotype.Service;

@Service
public class OEECalculationService implements ServiceTemplate {

    private ServiceStatus status = ServiceStatus.STOPPED;

    @Override
    public void start() {
        System.out.println("Starting OEE Calculation Service...");
        // Logic to start the service
        status = ServiceStatus.RUNNING;
        System.out.println("OEE Calculation Service started.");
    }

    @Override
    public void stop() {
        System.out.println("Stopping OEE Calculation Service...");
        // Logic to stop the service
        status = ServiceStatus.STOPPED;
        System.out.println("OEE Calculation Service stopped.");
    }

    @Override
    public ServiceStatus getStatus() {
        return status;
    }
}

