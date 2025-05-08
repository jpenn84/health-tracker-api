package com.joshualeepenn.healthtracker.controller;

import com.joshualeepenn.healthtracker.model.Weight;
import com.joshualeepenn.healthtracker.service.impl.WeightServiceImpl;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeightController {

    private final WeightServiceImpl weightService;

    public WeightController(WeightServiceImpl weightService) {
        this.weightService = weightService;
    }

    @GetMapping("/weight/all")
    public HttpEntity<List<Weight>> getAll() {
        return new HttpEntity<>(weightService.getAllWeights());
    }

    @PostMapping("/weight")
    public HttpEntity<Weight> create(@RequestBody Weight weight) {
        return new HttpEntity<>(weightService.saveWeight(weight));
    }

}
