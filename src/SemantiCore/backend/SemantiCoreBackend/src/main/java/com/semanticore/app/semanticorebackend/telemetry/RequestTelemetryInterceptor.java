package com.semanticore.app.semanticorebackend.telemetry;

import com.semanticore.app.semanticorebackend.core.utilities.ConsoleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestTelemetryInterceptor implements HandlerInterceptor {

    private final ConsoleService consoleService;
    private long startTime;

    public RequestTelemetryInterceptor(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        startTime = System.currentTimeMillis();  // Record the start time of the request
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;

        // Get necessary details
        String path = request.getRequestURI();
        int statusCode = response.getStatus();

        // Add a separator between requests
        consoleService.displayWithColor("\n==================== REQUEST LOG ====================\n", "blue");

        // Format the output
        String formattedMessage = String.format("[✔] Endpoint: %s | Response Time: %d ms | HTTP Status: %d", path, responseTime, statusCode);

        // Display the formatted message with colors
        consoleService.displayWithColor(formattedMessage, getColorByStatusCode(statusCode));

        // Display the progress bar for response time (visualization)
        displayProgressBar(responseTime);

        // Add an ending separator
        consoleService.displayWithColor("\n=====================================================\n", "blue");
    }

    private String getColorByStatusCode(int statusCode) {
        if (statusCode >= 200 && statusCode < 300) {
            return "green"; // Success
        } else if (statusCode >= 400 && statusCode < 500) {
            return "yellow"; // Client errors
        } else if (statusCode >= 500) {
            return "red"; // Server errors
        } else {
            return "blue"; // Informational or other statuses
        }
    }

    private void displayProgressBar(long responseTime) {
        StringBuilder progressBar = new StringBuilder("[");
        int progress = Math.min((int) (responseTime / 100), 50);  // Scale the response time to fit the progress bar
        for (int i = 0; i < 50; i++) {
            if (i < progress) {
                progressBar.append("=");
            } else {
                progressBar.append(" ");
            }
        }
        progressBar.append("]");
        consoleService.displayWithColor("Response Time Progress: " + progressBar, "blue");
    }
}
