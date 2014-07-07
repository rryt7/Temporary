package com.maven;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
//import com.yammer.dropwizard.db.DatabaseConfiguration;

public class ExampleConfiguration extends Configuration {
    @Valid
    @NotNull
    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
    
	/*
    @NotBlank
    @JsonProperty
    private final String password;

    @Valid
    @NotNull
    @JsonProperty("database")
    private final io.dropwizard.db.DatabaseConfiguration databaseConfiguration;

    public ExampleConfiguration(@JsonProperty("password") String password, @JsonProperty("database") io.dropwizard.db.DatabaseConfiguration databaseConfiguration) {
        this.password = password;
        this.databaseConfiguration = databaseConfiguration;
    }

    public String getPassword() {
        return password;
    }

    public io.dropwizard.db.DatabaseConfiguration getDatabaseConfiguration() {
        return databaseConfiguration;
    }*/
}
