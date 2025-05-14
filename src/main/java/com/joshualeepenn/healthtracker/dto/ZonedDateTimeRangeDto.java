package com.joshualeepenn.healthtracker.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class ZonedDateTimeRangeDto {
    private ZonedDateTime startZdt;
    private ZonedDateTime endZdt;
}
