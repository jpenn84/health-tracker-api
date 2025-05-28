package com.joshualeepenn.healthtracker.service;

import com.joshualeepenn.healthtracker.dto.MessageDto;
import com.joshualeepenn.healthtracker.exceptions.ResourceNotFoundException;
import com.joshualeepenn.healthtracker.exceptions.TransactionException;
import com.joshualeepenn.healthtracker.model.Weight;
import com.joshualeepenn.healthtracker.repository.WeightRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class WeightService {

    private final WeightRepository weightRepository;

    public WeightService(WeightRepository weightRepository) {
        this.weightRepository = weightRepository;
    }

    @Transactional
    public Weight saveWeight(Weight weight) {
        return weightRepository.save(weight);
    }

    public List<Weight> getAllWeights() {
        return weightRepository.findAll();
    }

    public List<Weight> findByDateBetween(ZonedDateTime startZdt, ZonedDateTime endZdt) {
        // TODO: May want to pass String dates (and time zone) and process from there
        // TODO: Test for DST: https://stackoverflow.com/questions/29143910/java-8-date-time-get-start-of-day-from-zoneddatetime

        // Get the earliest point of the start date
        ZonedDateTime queryStartZdt = startZdt.truncatedTo(ChronoUnit.DAYS);

        // Get the latest point in the intended query (midnight the day after the end date.
        // TODO: Test what actually happens if record exists exactly at midnight
        ZonedDateTime queryEndZdt = endZdt.truncatedTo(ChronoUnit.DAYS).plusDays(1);

        return weightRepository.findAllByReadingTimeBetweenOrderByReadingTimeAsc(queryStartZdt, queryEndZdt);
    }

    public Weight findById(Long id) {
        Weight weight =  weightRepository.findById(id).orElse(null);

        if (null == weight)
            throw new ResourceNotFoundException("Weight with id " + id + " not found");

        return weight;
    }

    @Transactional
    public Weight update(Weight weight) {
        return weightRepository.saveAndFlush(weight);
    }

    @Transactional
    public MessageDto deleteWeightById(Long id) {
        Weight weight = findById(id);

        weightRepository.delete(weight);

        if (!weightRepository.existsById(id))
            return MessageDto.success("deleted weight with ID " + id);
        else throw new TransactionException("Problem deleting weight with ID " + id);
    }

}
