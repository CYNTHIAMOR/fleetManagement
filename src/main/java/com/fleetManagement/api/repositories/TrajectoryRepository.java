package com.fleetManagement.api.repositories;

import com.fleetManagement.api.models.Trajectory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface TrajectoryRepository extends JpaRepository<Trajectory, Integer> {
    Page<Trajectory> findByTaxiIdAndDateBetweenOrderByDateDesc(Integer taxiId, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
}
