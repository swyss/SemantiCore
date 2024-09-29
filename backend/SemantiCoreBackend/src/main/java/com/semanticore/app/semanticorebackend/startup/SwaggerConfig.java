package com.semanticore.app.semanticorebackend.startup;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.web.bind.annotation.RestController;

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
