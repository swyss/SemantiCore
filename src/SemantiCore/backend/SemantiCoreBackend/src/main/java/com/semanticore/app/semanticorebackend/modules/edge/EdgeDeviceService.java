package com.semanticore.app.semanticorebackend.modules.edge;

import com.semanticore.app.semanticorebackend.core.services.model.ServiceStatus;
import com.semanticore.app.semanticorebackend.core.services.model.ServiceTemplate;
import org.springframework.stereotype.Service;

@Service
public class EdgeDeviceService implements ServiceTemplate {

    private ServiceStatus status = ServiceStatus.STOPPED;

    @Override
    public void start() {
        System.out.println("Starting Edge Device Service...");
        status = ServiceStatus.RUNNING;
    }

    @Override
    public void stop() {
        System.out.println("Stopping Edge Device Service...");
        status = ServiceStatus.STOPPED;
    }

    @Override
    public ServiceStatus getStatus() {
        return status;
    }
}

