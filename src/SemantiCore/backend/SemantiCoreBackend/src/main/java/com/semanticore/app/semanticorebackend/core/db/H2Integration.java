package com.semanticore.app.semanticorebackend.core.db;

import com.semanticore.app.semanticorebackend.core.services.model.DatabaseIntegration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class H2Integration implements DatabaseIntegration {

    private final DataSource dataSource;

    public H2Integration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void connect() {
        try {
            dataSource.getConnection();
            System.out.println("Connected to H2 database.");
        } catch (Exception e) {
            System.err.println("Failed to connect to H2: " + e.getMessage());
        }
    }

    @Override
    public void disconnect() {
        // Implement disconnect logic
        System.out.println("Disconnected from H2 database.");
    }

    @Override
    public boolean isConnected() {
        // Implement logic to check if connected
        return true;
    }
}
