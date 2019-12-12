package com.example.mco.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "config")
@Component
public class AppConfig {
    private final Db db = new Db();

    public Db getDb() {
        return db;
    }

    @ConfigurationProperties(prefix = "db")
    @Data
    public class Db {
        private String schema;
        private String schemaDefault;
        private String jooqSqlDialect;

    }

}
