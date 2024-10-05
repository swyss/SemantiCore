package com.semanticore.app.semanticorebackend.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        // Setting the data source properties (can be adapted based on the service)
        dataSource.setDriverClassName("org.h2.Driver"); // H2 driver (for testing)
        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1"); // H2 in-memory URL
        dataSource.setUsername("sa"); // Default username for H2
        dataSource.setPassword(""); // Default password for H2 (none)

        return dataSource;
    }
}
