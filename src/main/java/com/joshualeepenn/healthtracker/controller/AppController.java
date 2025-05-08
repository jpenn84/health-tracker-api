package com.joshualeepenn.healthtracker.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/alive")
    public HttpEntity<String> getAlive() {
        return new HttpEntity<>("Alive");
    }
}
