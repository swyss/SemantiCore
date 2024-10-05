package com.semanticore.app.semanticorebackend.core.db;


import com.semanticore.app.semanticorebackend.core.services.model.DatabaseIntegration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class PostgresIntegration implements DatabaseIntegration {

    private final DataSource dataSource;

    public PostgresIntegration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void connect() {
        try {
            dataSource.getConnection();
            System.out.println("Connected to Postgres database.");
        } catch (Exception e) {
            System.err.println("Failed to connect to Postgres: " + e.getMessage());
        }
    }

    @Override
    public void disconnect() {
        // Implement disconnect logic
        System.out.println("Disconnected from Postgres database.");
    }

    @Override
    public boolean isConnected() {
        // Implement logic to check if connected
        return true;
    }
}
