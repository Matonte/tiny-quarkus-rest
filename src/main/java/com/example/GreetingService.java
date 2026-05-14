package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class GreetingService {

    @ConfigProperty(name = "app.environment", defaultValue = "unknown")
    String environment;

    public Greeting buildGreeting(String name) {
        String safe = (name == null || name.isBlank()) ? "Quarkus" : name.trim();
        return new Greeting("Hello, " + safe, environment);
    }
}
