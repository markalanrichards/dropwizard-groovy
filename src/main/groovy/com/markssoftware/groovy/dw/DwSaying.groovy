package com.markssoftware.groovy.dw

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length

class DwSaying {
    private long id;

    @Length(max = 3)
    private String content;

    DwSaying() {
        // Jackson deserialization
    }

    DwSaying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    long getId() {
        return id;
    }

    @JsonProperty
    String getContent() {
        return content;
    }
}