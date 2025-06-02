package de.stadtherne.stadtserver.controller;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TestController {

    @GetMapping("/test")
    public String testEndpoint() {
        return "Stadtserver Project";
    }
}