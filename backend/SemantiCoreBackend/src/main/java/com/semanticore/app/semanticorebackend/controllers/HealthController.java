package com.semanticore.app.semanticorebackend.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HealthController {

    // GET /api/v1/health
    @GetMapping("/health")
    public ResponseEntity<String> checkHealth() {
        // Return HTTP 200 OK with a message
        return new ResponseEntity<>("Backend server is running", HttpStatus.OK);
    }
}
