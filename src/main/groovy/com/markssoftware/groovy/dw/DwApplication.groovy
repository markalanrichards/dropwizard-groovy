package com.markssoftware.groovy.dw

import io.dropwizard.Application
import io.dropwizard.configuration.EnvironmentVariableSubstitutor
import io.dropwizard.configuration.SubstitutingSourceProvider
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class DwApplication extends Application<DwConfig> {
    static void main(String[] args) throws Exception {
        new DwApplication().run(args);
    }

    @Override
    String getName() {
        return "hello-world";
    }

    @Override
    void initialize(Bootstrap<DwConfig> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );

    }

    @Override
    public void run(DwConfig configuration,
                    Environment environment) {
        final DwResource resource = new DwResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);
    }
}