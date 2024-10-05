package com.semanticore.app.semanticorebackend.telemetry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TelemetryConfiguration implements WebMvcConfigurer {

    private final RequestTelemetryInterceptor requestTelemetryInterceptor;

    @Autowired
    public TelemetryConfiguration(RequestTelemetryInterceptor requestTelemetryInterceptor) {
        this.requestTelemetryInterceptor = requestTelemetryInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestTelemetryInterceptor);
    }
}
