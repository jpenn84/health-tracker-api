package com.joshualeepenn.healthtracker.controller;

import com.joshualeepenn.healthtracker.dto.ZonedDateTimeRange;
import com.joshualeepenn.healthtracker.model.Weight;
import com.joshualeepenn.healthtracker.service.impl.WeightServiceImpl;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weight")
public class WeightController {

    private final WeightServiceImpl weightService;

    public WeightController(WeightServiceImpl weightService) {
        this.weightService = weightService;
    }

    @GetMapping("/all")
    public HttpEntity<List<Weight>> getAll() {
        return new HttpEntity<>(weightService.getAllWeights());
    }

    @GetMapping("/{id}")
    public HttpEntity<Weight> getById(@PathVariable Long id) {
        return new HttpEntity<>(weightService.findById(id));
    }

    @PutMapping("/{id}")
    public HttpEntity<Weight> update(@PathVariable Long id, @RequestBody Weight weight) {
        return new HttpEntity<>(weightService.update(weight));
    }

    @GetMapping("/date")
    public HttpEntity<List<Weight>> getRange(@RequestBody ZonedDateTimeRange dateRange) {
        return new HttpEntity<>(weightService.findByDateBetween(dateRange.getStartDate(), dateRange.getEndDate()));
    }

    @PostMapping
    public HttpEntity<Weight> create(@RequestBody Weight weight) {
        return new HttpEntity<>(weightService.saveWeight(weight));
    }

}
