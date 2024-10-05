package com.semanticore.app.semanticorebackend;

import com.semanticore.app.semanticorebackend.core.CoreApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SemantiCoreBackendApplication implements CommandLineRunner {

    private final CoreApp coreApp;

    @Autowired
    public SemantiCoreBackendApplication(CoreApp coreApp) {
        this.coreApp = coreApp;
    }

    public static void main(String[] args) {
        SpringApplication.run(SemantiCoreBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        coreApp.start();
    }
}
