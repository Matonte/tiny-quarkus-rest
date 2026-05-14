package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {

    @Test
    void testHelloEndpoint_defaultName() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("message", is("Hello, Quarkus"))
                .body("environment", is("local"));
    }

    @Test
    void testHelloEndpoint_withNameQuery() {
        given()
                .queryParam("name", "Ada")
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body("message", is("Hello, Ada"))
                .body("environment", is("local"));
    }
}
