package com.semanticore.app.semanticorebackend.modules.analytics;

import com.semanticore.app.semanticorebackend.core.services.model.ServiceStatus;
import com.semanticore.app.semanticorebackend.core.services.model.ServiceTemplate;
import org.springframework.stereotype.Service;

@Service // Marks this class as a Spring service
public class AnalyticsService implements ServiceTemplate {

    private ServiceStatus status = ServiceStatus.STOPPED;

    @Override
    public void start() {
        System.out.println("Starting Analytics Service...");
        status = ServiceStatus.RUNNING;
    }

    @Override
    public void stop() {
        System.out.println("Stopping Analytics Service...");
        status = ServiceStatus.STOPPED;
    }

    @Override
    public ServiceStatus getStatus() {
        return status;
    }
}

