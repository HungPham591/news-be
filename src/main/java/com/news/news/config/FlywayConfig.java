package com.news.news.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {
    @Autowired
    private DataSource dataSource;
    @Value("${flyway.locations}") // Read the value from application.properties or application.yml
    private String[] locations;

    @Bean
    public Flyway flyway(){
        Flyway flyway = Flyway
                .configure()
                .dataSource(dataSource)
                .locations(locations)
                .baselineOnMigrate(true)
                .baselineVersion("0")
                .load();
        System.out.println("migrating ...");
        flyway.migrate();
        return flyway;
    }
}
