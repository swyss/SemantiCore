package com.semanticore.app.semanticorebackend.core.services.model;

import com.semanticore.app.semanticorebackend.core.services.utilities.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService implements ServiceTemplate {

    @Autowired
    protected ConsoleService consoleService;

    protected ServiceStatus status = ServiceStatus.STOPPED;

    @Override
    public void start() {
        consoleService.displayWithColor("Starting " + getClass().getSimpleName() + "...", "yellow");
        status = ServiceStatus.RUNNING;
        consoleService.displaySuccess(getClass().getSimpleName() + " started successfully!", "green");
    }

    @Override
    public void stop() {
        consoleService.displayWithColor("Stopping " + getClass().getSimpleName() + "...", "yellow");
        status = ServiceStatus.STOPPED;
        consoleService.displaySuccess(getClass().getSimpleName() + " stopped successfully!", "green");
    }

    @Override
    public ServiceStatus getStatus() {
        return status;
    }
}
