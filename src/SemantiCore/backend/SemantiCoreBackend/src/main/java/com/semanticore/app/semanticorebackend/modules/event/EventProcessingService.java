package com.semanticore.app.semanticorebackend.modules.event;

import com.semanticore.app.semanticorebackend.core.services.model.ServiceStatus;
import com.semanticore.app.semanticorebackend.core.services.model.ServiceTemplate;
import org.springframework.stereotype.Service;

@Service // Ensure it is a Spring bean
public class EventProcessingService implements ServiceTemplate {

    private ServiceStatus status = ServiceStatus.STOPPED;

    @Override
    public void start() {
        System.out.println("Starting Event Processing Service...");
        status = ServiceStatus.RUNNING;
    }

    @Override
    public void stop() {
        System.out.println("Stopping Event Processing Service...");
        status = ServiceStatus.STOPPED;
    }

    @Override
    public ServiceStatus getStatus() {
        return status;
    }
}

