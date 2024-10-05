package com.semanticore.app.semanticorebackend.core.services;

import com.semanticore.app.semanticorebackend.core.db.H2Integration;
import com.semanticore.app.semanticorebackend.core.services.model.DatabaseIntegration;
import com.semanticore.app.semanticorebackend.core.services.model.ServiceStatus;
import com.semanticore.app.semanticorebackend.core.services.model.ServiceTemplate;
import com.semanticore.app.semanticorebackend.core.utilities.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService implements ServiceTemplate {

    @Autowired
    protected H2Integration h2Integration;
    @Autowired
    protected ConsoleService consoleService;

    protected ServiceStatus status = ServiceStatus.STOPPED;

    @Override
    public void start() {
        h2Integration.connect();
        try {
            consoleService.displayWithColor("Starting " + getClass().getSimpleName() + "...", "yellow");
            status = ServiceStatus.RUNNING;
            consoleService.displaySuccess(getClass().getSimpleName() + " started successfully!", "green");
        } catch (Exception e) {
            status = ServiceStatus.ERROR;
            consoleService.displayError(getClass().getSimpleName() + " failed to start: " + e.getMessage(), "red");
        }
    }

    @Override
    public void stop() {
        h2Integration.disconnect();
        consoleService.displayWithColor("Stopping " + getClass().getSimpleName() + "...", "yellow");
        status = ServiceStatus.STOPPED;
        consoleService.displaySuccess(getClass().getSimpleName() + " stopped successfully!", "green");
    }

    @Override
    public ServiceStatus getStatus() {
        return status;
    }

    @Override
    public DatabaseIntegration getDatabaseIntegration() {
        return h2Integration;
    }
}
