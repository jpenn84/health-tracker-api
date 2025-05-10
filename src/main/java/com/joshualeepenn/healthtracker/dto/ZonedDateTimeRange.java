package com.joshualeepenn.healthtracker.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class ZonedDateTimeRange {
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
}
