package com.joshualeepenn.healthtracker.repository;

import com.joshualeepenn.healthtracker.model.Weight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightRepository extends JpaRepository<Weight, Long> {
}
