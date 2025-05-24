package com.joshualeepenn.healthtracker.repository;

import com.joshualeepenn.healthtracker.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findUserByUsername(String username);
}
