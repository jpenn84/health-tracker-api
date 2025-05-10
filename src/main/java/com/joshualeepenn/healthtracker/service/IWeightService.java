package com.joshualeepenn.healthtracker.service;

import com.joshualeepenn.healthtracker.model.Weight;

import java.time.ZonedDateTime;
import java.util.List;

public interface IWeightService {

    Weight findById(Long id);

    Weight update(Weight weight);

    List<Weight> getAllWeights();

    Weight saveWeight(Weight weight);

    List<Weight> findByDateBetween(ZonedDateTime startDate, ZonedDateTime endDate);
}
