package com.joshualeepenn.healthtracker.service.impl;

import com.joshualeepenn.healthtracker.model.Weight;
import com.joshualeepenn.healthtracker.repository.WeightRepository;
import com.joshualeepenn.healthtracker.service.IWeightService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeightServiceImpl implements IWeightService {

    private final WeightRepository weightRepository;

    public WeightServiceImpl(WeightRepository weightRepository, WeightRepository weightRepository1) {
        this.weightRepository = weightRepository1;
    }


    @Override
    public List<Weight> getAllWeights() {
        return weightRepository.findAll();
    }

    @Override
    public Weight saveWeight(Weight weight) {
        return weightRepository.save(weight);
    }
}
