package com.semanticore.app.semanticorebackend.core.db;

import com.semanticore.app.semanticorebackend.core.services.model.DatabaseIntegration;
import org.neo4j.driver.Driver;
import org.springframework.stereotype.Component;

@Component
public class Neo4jIntegration implements DatabaseIntegration {

    private final Driver driver;

    public Neo4jIntegration(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void connect() {
        try {
            driver.session();
            System.out.println("Connected to Neo4j database.");
        } catch (Exception e) {
            System.err.println("Failed to connect to Neo4j: " + e.getMessage());
        }
    }

    @Override
    public void disconnect() {
        // Implement disconnect logic
        driver.close();
        System.out.println("Disconnected from Neo4j database.");
    }

    @Override
    public boolean isConnected() {
        // Implement logic to check if connected
        return true;
    }
}
