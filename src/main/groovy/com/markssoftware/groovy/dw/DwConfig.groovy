package com.markssoftware.groovy.dw

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import org.hibernate.validator.constraints.NotEmpty

class DwConfig extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @JsonProperty
    String getTemplate() {
        return template;
    }

    @JsonProperty
    void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    void setDefaultName(String name) {
        this.defaultName = name;
    }
}