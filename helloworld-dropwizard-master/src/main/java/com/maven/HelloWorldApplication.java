package com.maven;

import io.dropwizard.Application;
import io.dropwizard.db.DatabaseConfiguration;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.skife.jdbi.v2.DBI;


public class HelloWorldApplication extends Application<ExampleConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<ExampleConfiguration> bootstrap) {
        // nothing to do yet
    	/*bootstrap.addBundle(new MigrationsBundle<ExampleConfiguration>() {
            public DatabaseConfiguration getDatabaseConfiguration(ExampleConfiguration configuration) {
                return configuration.getDatabaseConfiguration();
            }
        });*/
    	System.out.println("Initialization OK");
    }
    
    @Override
    public void run(ExampleConfiguration config,
                    Environment environment) throws ClassNotFoundException {
    	System.out.println("Started fine");
        final DBIFactory factory = new DBIFactory();
        System.out.println("Factory fine");
        
        final DBI jdbi = factory.build(environment, config.getDataSourceFactory(), "postgresql");
        System.out.println("Postgres looks good");
        final MyDAOInt dao = jdbi.onDemand(MyDAO.class);
        System.out.println("Demand class");
        environment.jersey().register(new UserResource(dao));
        System.out.println("Connection Successful");

    }

    /*@Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
            configuration.getTemplate(),
            configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck =
            new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }*/

}
