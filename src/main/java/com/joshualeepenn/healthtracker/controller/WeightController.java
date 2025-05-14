package com.joshualeepenn.healthtracker.controller;

import com.joshualeepenn.healthtracker.dto.MessageDto;
import com.joshualeepenn.healthtracker.dto.ZonedDateTimeRangeDto;
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

    @PutMapping
    public HttpEntity<Weight> update(@RequestBody Weight weight) {
        return new HttpEntity<>(weightService.update(weight));
    }

    // TODO: May want to pass String dates (and time zone) and process from there
    @GetMapping("/date/range")
    public HttpEntity<List<Weight>> getRange(@RequestBody ZonedDateTimeRangeDto zdtRange) {
        return new HttpEntity<>(weightService.findByDateBetween(zdtRange.getStartZdt(), zdtRange.getEndZdt()));
    }

    @PostMapping
    public HttpEntity<Weight> create(@RequestBody Weight weight) {
        return new HttpEntity<>(weightService.saveWeight(weight));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<MessageDto> delete(@PathVariable Long id) {
        return new HttpEntity<>(weightService.deleteWeightById(id));
    }

}
