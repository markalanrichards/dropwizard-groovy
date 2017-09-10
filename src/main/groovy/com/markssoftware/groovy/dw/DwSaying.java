package com.markssoftware.groovy.dw;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class DwSaying {
    private long id;

    @Length(max = 3)
    private String content;

    public DwSaying() {
        // Jackson deserialization
    }

    public DwSaying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}