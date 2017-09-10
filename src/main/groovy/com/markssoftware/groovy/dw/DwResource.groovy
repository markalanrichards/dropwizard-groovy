package com.markssoftware.groovy.dw

import com.codahale.metrics.annotation.Timed

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType
import java.util.concurrent.atomic.AtomicLong

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
class DwResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    DwResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    DwSaying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        return new DwSaying(counter.incrementAndGet(), value);
    }
}