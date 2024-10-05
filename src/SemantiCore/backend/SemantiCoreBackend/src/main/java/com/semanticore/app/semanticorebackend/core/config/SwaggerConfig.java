package com.semanticore.app.semanticorebackend.core.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    /**
     * Configures the general information for the Swagger UI.
     * The OpenAPI object represents the API documentation for the project.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SemantiCore Backend API")
                        .version("1.0.0")
                        .description("API documentation for the SemantiCore Backend system.")
                        .contact(new Contact()
                                .name("Support Team")
                                .email("support@semanticore.com")
                                .url("https://www.semanticore.com")));
    }

    /**
     * Group the API endpoints for the public access to be displayed in the Swagger UI.
     */
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/api/**") // Expose only the APIs that match the path
                .build();
    }
}
