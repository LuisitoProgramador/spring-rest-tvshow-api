package com.project.endpoints.repositories;

import com.project.endpoints.models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowsRepository extends JpaRepository<Shows, Integer> {
    
}
