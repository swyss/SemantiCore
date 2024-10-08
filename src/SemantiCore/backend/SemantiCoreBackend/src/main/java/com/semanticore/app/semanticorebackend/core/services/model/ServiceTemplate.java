package com.semanticore.app.semanticorebackend.core.services.model;

public interface ServiceTemplate {

    void start();

    void stop();

    ServiceStatus getStatus();

    // New method to integrate the database
    DatabaseIntegration getDatabaseIntegration();
}
