package com.semanticore.app.semanticorebackend.modules.data.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataStorageModuleDataSourceConfig {

    @Bean(name = "dataStorageDataSource")
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5432/datastorage_db")
                .username("datastorage_user")
                .password("datastorage_password")
                .driverClassName("org.postgresql.Driver")
                .build();
    }

    @Bean(name = "dataStorageJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("dataStorageDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
