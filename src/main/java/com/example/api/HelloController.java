package com.example.api;

public class HelloController {
    public String sayHello(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Hello, World!";
        }
        return "Hello, " + name + "!";
    }
}
