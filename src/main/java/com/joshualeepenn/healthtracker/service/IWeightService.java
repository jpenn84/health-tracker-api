package com.joshualeepenn.healthtracker.service;

import com.joshualeepenn.healthtracker.model.Weight;

import java.util.List;

public interface IWeightService {

    List<Weight> getAllWeights();

    Weight saveWeight(Weight weight);
}
