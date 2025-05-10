package com.joshualeepenn.healthtracker.tests.integration;

import com.joshualeepenn.healthtracker.model.Weight;
import com.joshualeepenn.healthtracker.repository.WeightRepository;
import com.joshualeepenn.healthtracker.service.impl.WeightServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class WeightIntegrationTest {

    private final ZonedDateTime testTime = ZonedDateTime.now();

    @Mock
    private WeightRepository weightRepository;

    @InjectMocks
    private WeightServiceImpl weightService;

    Weight weight1 = new Weight(1L, 120.0, "Starting weight", testTime.minusDays(2));
    Weight weight2 = new Weight(2L, 121.0, "Ate some cake", testTime.minusDays(1));
    Weight weight3 = new Weight(2L, 130.0, "Ate 3 pizzas", testTime);

    @Test
    public void getAllWeights_success() throws Exception {
        List<Weight> weights = List.of(weight1, weight2, weight3);
        for (Weight weight : weights) {
            Mockito.when(weightRepository.save(weight)).thenReturn(weight);
            Weight savedWeight = weightService.saveWeight(weight);
            Assertions.assertEquals(weight, savedWeight);
        }
    }
}
