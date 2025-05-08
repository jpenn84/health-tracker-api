package com.joshualeepenn.healthtracker.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity
@Data
public class Weight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Positive(message = "Weight must be a positive number")
    private double weight;

    private String remarks;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "Time is required")
    @PastOrPresent(message = "Time cannot be in the future")
    private ZonedDateTime readingTime;
}
