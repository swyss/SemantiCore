package com.semanticore.app.semanticorebackend.semanticdata;

import com.semanticore.app.semanticorebackend.core.services.model.ServiceStatus;
import com.semanticore.app.semanticorebackend.core.services.model.ServiceTemplate;
import org.springframework.stereotype.Service;

@Service // Marks this class as a Spring bean
public class DataEnrichmentService implements ServiceTemplate {

    private ServiceStatus status = ServiceStatus.STOPPED;

    @Override
    public void start() {
        System.out.println("Starting Data Enrichment Service...");
        status = ServiceStatus.RUNNING;
    }

    @Override
    public void stop() {
        System.out.println("Stopping Data Enrichment Service...");
        status = ServiceStatus.STOPPED;
    }

    @Override
    public ServiceStatus getStatus() {
        return status;
    }
}
