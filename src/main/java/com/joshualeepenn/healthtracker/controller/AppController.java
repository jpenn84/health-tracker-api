package com.joshualeepenn.healthtracker.controller;

import com.joshualeepenn.healthtracker.dto.AppStatusDto;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/app")
public class AppController {

    private final AppStatusDto status;

    public AppController(AppStatusDto status) {
        this.status = status;
    }

    @GetMapping("/status")
    public HttpEntity<AppStatusDto> getAlive() {
        return new HttpEntity<>(status);
    }
}
