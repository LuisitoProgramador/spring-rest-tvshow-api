package com.project.endpoints.repositories;

import com.project.endpoints.models.Actor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    // Derived query methods
    // Find actors by exact name match
    List<Actor> findByName(String name);
    // Find actors whose names contain the given substring
    List<Actor> findByNameContaining(String name);
    
    // Custom query methods
    // Delete actors by name
    @Transactional
    int deleteByName(String name);
    
    // Delete actors by residence country
    @Transactional
    int deleteByResidenceCountry(String country);
    
    // Count actors by residence country
    @Query("SELECT COUNT(a) FROM Actor a WHERE a.residenceCountry = :country ")
    int countByResidenceCountry(String country);
    
//  Alternative native query version
//  @Query(value = "SELECT COUNT(*) FROM actor WHERE residence_country = :country", nativeQuery = true)
//  int countByResidenceCountry(String country);
}
