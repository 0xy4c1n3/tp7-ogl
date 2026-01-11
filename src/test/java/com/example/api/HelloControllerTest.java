package com.example.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloControllerTest {

    @Test
    public void testSayHello() {
        HelloController controller = new HelloController();
        assertEquals("Hello, Jenkins!", controller.sayHello("Jenkins"));
    }

    @Test
    public void testSayHelloDefault() {
        HelloController controller = new HelloController();
        assertEquals("Hello, World!", controller.sayHello(null));
    }
}
