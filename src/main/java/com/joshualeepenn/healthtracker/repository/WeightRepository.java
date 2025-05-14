package com.joshualeepenn.healthtracker.repository;

import com.joshualeepenn.healthtracker.model.Weight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface WeightRepository extends JpaRepository<Weight, Long> {

    List<Weight> findAllByReadingTimeBetweenOrderByReadingTimeAsc(ZonedDateTime startZdt, ZonedDateTime endZdt);

    Integer deleteWeightById(Long id);
}
