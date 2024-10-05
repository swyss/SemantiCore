package com.semanticore.app.semanticorebackend.core;

import com.semanticore.app.semanticorebackend.core.starter.CoreServiceStarter;
import com.semanticore.app.semanticorebackend.core.starter.ModuleStarter;
import com.semanticore.app.semanticorebackend.core.utilities.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class CoreApp {

    private final CoreServiceStarter coreServiceStarter;
    private final ModuleStarter moduleStarter;
    private final ConsoleService consoleService;

    @Value("${server.port}")
    private int serverPort;

    @Autowired
    public CoreApp(CoreServiceStarter coreServiceStarter,
                   ModuleStarter moduleStarter,
                   ConsoleService consoleService) throws Exception {
        this.coreServiceStarter = coreServiceStarter;
        this.moduleStarter = moduleStarter;
        this.consoleService = consoleService;
    }

    // Start both core and module services
    public void start() {
        try {
            consoleService.displayWithSpinner("Starting Core Services...", "yellow");
            coreServiceStarter.startCoreServices();
            consoleService.displaySuccess("Core Services started successfully", "green");

            consoleService.displayWithSpinner("Starting Module Services...", "yellow");
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
        coreServiceStarter.stopCoreServices();
        moduleStarter.stopAllModules();
    }

    private void displayEndpoints() {
        System.out.println("\n[INFO] Available Endpoints:");
        System.out.println(" - Home: http://localhost:" + serverPort + "/");
        System.out.println(" - API Docs: http://localhost:" + serverPort + "/swagger-ui.html");
        System.out.println(" - Health Check: http://localhost:" + serverPort + "/api/health");
    }
}