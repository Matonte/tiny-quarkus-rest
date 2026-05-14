package com.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    private final GreetingService greetingService;

    @Inject
    public GreetingResource(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    /**
     * Example: GET /hello?name=Ada → JSON with message + environment (from config).
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting hello(@QueryParam("name") @DefaultValue("Quarkus") String name) {
        return greetingService.buildGreeting(name);
    }
}
