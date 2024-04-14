package com.fleetManagement.api.repositories;

import com.fleetManagement.api.models.Taxi;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository es un metodo
public interface TaxiRepository extends JpaRepository<Taxi, Integer> {
}
