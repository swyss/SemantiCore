package com.semanticore.app.semanticorebackend.telemetry;

import org.springframework.stereotype.Component;

@Component
public class TelemetryLogger {

    public void logTelemetryData(String endpoint, long responseTime, int statusCode) {
        System.out.println("Endpoint: " + endpoint);
        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Time: " + responseTime + " ms");
    }
}
