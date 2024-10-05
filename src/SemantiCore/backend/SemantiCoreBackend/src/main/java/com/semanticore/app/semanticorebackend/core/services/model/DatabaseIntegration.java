package com.semanticore.app.semanticorebackend.core.services.model;

public interface DatabaseIntegration {

    void connect();

    void disconnect();

    boolean isConnected();
}
