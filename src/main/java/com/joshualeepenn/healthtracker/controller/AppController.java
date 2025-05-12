package com.joshualeepenn.healthtracker.controller;

import com.joshualeepenn.healthtracker.dto.AppStatus;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/app")
public class AppController {

    private final AppStatus status;

    public AppController(AppStatus status) {
        this.status = status;
    }

    @GetMapping("/status")
    public HttpEntity<AppStatus> getAlive() {
        return new HttpEntity<>(status);
    }
}
