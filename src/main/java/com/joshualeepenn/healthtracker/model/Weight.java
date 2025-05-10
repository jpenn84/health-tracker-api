package com.joshualeepenn.healthtracker.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Positive(message = "Weight must be a positive number")
    private double weight;

    private String remarks;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "Time is required")
    @PastOrPresent(message = "Time cannot be in the future")
    private ZonedDateTime readingTime;
}
