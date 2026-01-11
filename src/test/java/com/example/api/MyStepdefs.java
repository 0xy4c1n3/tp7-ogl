package com.example.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStepdefs {
    private HelloController controller;
    private String response;

    @Given("I have a HelloController")
    public void iHaveAHelloController() {
        controller = new HelloController();
    }

    @When("I ask it to say hello to {string}")
    public void iAskItToSayHelloTo(String name) {
        response = controller.sayHello(name);
    }

    @Then("it should answer {string}")
    public void itShouldAnswer(String expected) {
        assertEquals(expected, response);
    }
}
