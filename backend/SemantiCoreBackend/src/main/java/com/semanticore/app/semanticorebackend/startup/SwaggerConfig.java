package com.semanticore.app.semanticorebackend.startup;


import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    // Define API documentation group
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("semanticore-api")
                .packagesToScan("com.semanticore.app")
                .pathsToMatch("/**")
                .build();
    }
}
