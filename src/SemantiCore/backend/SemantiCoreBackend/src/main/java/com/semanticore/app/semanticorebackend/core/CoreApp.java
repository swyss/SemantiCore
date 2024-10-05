package com.semanticore.app.semanticorebackend.core;

import com.semanticore.app.semanticorebackend.core.services.utilities.CommonUtilities;
import com.semanticore.app.semanticorebackend.core.services.utilities.ConsoleService;
import com.semanticore.app.semanticorebackend.modules.ModuleStarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class CoreApp {

    private final ModuleStarter moduleStarter;
    private final ConsoleService consoleService;

    @Value("${server.port}")
    private int serverPort;

    @Autowired
    public CoreApp(ModuleStarter moduleStarter, ConsoleService consoleService) {
        this.moduleStarter = moduleStarter;
        this.consoleService = consoleService;
    }

    public void start() {
        try {
            // Display startup information with UUID and timestamp using CommonUtilities
            String timestamp = CommonUtilities.getCurrentDate("yyyy-MM-dd HH:mm:ss");
            String uuid = CommonUtilities.generateUUID();
            System.out.println("Starting CoreApp at: " + timestamp + " with UUID: " + uuid);

            consoleService.displayWithSpinner("Initializing CoreApp...", "yellow");

            // Start all modules
            moduleStarter.startAllModules();

            // Stop the spinner after the modules are started
            consoleService.stopSpinner();

            // Log final status after the modules have started
            consoleService.displaySuccess("CoreApp and all Modules started successfully!", "green");

            // Display the list of available endpoints
            displayEndpoints();
        } catch (Exception e) {
            consoleService.displayError("Error during CoreApp startup: " + e.getMessage(), "red");
            throw e;
        }
    }

    public void stop() {
        // Display stop information with timestamp using CommonUtilities
        String timestamp = CommonUtilities.getCurrentDate("yyyy-MM-dd HH:mm:ss");
        System.out.println("Stopping CoreApp at: " + timestamp);

        consoleService.displayWithSpinner("Stopping CoreApp services...", "yellow");

        // Stop all modules
        moduleStarter.stopAllModules();

        // Stop the spinner after modules stop
        consoleService.stopSpinner();

        // Log final stop status
        consoleService.displaySuccess("CoreApp and all Modules stopped successfully!", "green");
    }

    private void displayEndpoints() {
        System.out.println("\n[INFO] Available Endpoints:");
        System.out.println(" - Home: http://localhost:" + serverPort + "/");
        System.out.println(" - API Docs: http://localhost:" + serverPort + "/swagger-ui.html");
        System.out.println(" - Health Check: http://localhost:" + serverPort + "/api/health");
    }
}