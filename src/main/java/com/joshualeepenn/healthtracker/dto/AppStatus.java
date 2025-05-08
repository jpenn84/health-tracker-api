package com.joshualeepenn.healthtracker.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class AppStatus {
    @Value("${}")
    private String appName;
    private String appVersion;
}
