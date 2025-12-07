package com.project.endpoints.repositories;

import com.project.endpoints.models.Biography;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BiographyRepository extends JpaRepository<Biography,Integer> {
    
    
}
