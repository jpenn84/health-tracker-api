package com.joshualeepenn.healthtracker.controller;

import com.joshualeepenn.bucket.time.TimeZones;
import com.joshualeepenn.healthtracker.dto.AppStatusDto;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {

    private final AppStatusDto status;

    public AppController(AppStatusDto status) {
        this.status = status;
    }

    @GetMapping("/status")
    public HttpEntity<AppStatusDto> getStatus() {
        return new HttpEntity<>(status);
    }

    @GetMapping("/timezones")
    public HttpEntity<List<TimeZones.TimeZoneRegionAndOffset>> getTimezones() {
        return new HttpEntity<>(TimeZones.getRegionAndOffsetList());
    }
}
