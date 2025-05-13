package com.joshualeepenn.healthtracker.service.impl;

import com.joshualeepenn.healthtracker.dto.MessageDto;
import com.joshualeepenn.healthtracker.exceptions.ResourceNotFoundException;
import com.joshualeepenn.healthtracker.exceptions.TransactionException;
import com.joshualeepenn.healthtracker.model.Weight;
import com.joshualeepenn.healthtracker.repository.WeightRepository;
import com.joshualeepenn.healthtracker.service.IWeightService;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class WeightServiceImpl implements IWeightService {

    private final WeightRepository weightRepository;

    public WeightServiceImpl(WeightRepository weightRepository) {
        this.weightRepository = weightRepository;
    }

    @Override
    public Weight findById(Long id) {
        Weight weight =  weightRepository.findById(id).orElse(null);

        if (null == weight)
            throw new ResourceNotFoundException("Weight with id " + id + " not found");

        return weight;
    }

    @Override
    public Weight update(Weight weight) {
        return weightRepository.saveAndFlush(weight);
    }

    @Override
    public List<Weight> getAllWeights() {
        return weightRepository.findAll();
    }

    @Override
    public Weight saveWeight(Weight weight) {
        return weightRepository.save(weight);
    }

    @Override
    public List<Weight> findByDateBetween(ZonedDateTime startDate, ZonedDateTime endDate) {
        return weightRepository.findAllByReadingTimeBetweenOrderByReadingTimeAsc(startDate, endDate);
    }

    @Override
    public MessageDto deleteWeightById(Long id) {
        Weight weight = findById(id);

        weightRepository.delete(weight);

        if (!weightRepository.existsById(id))
            return MessageDto.success("deleted weight with ID " + id);

        else throw new TransactionException("Problem deleting weight with ID " + id);
    }

}
