package com.fleetManagement.api.services;

import com.fleetManagement.api.models.Trajectory;
import com.fleetManagement.api.repositories.TrajectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TrajectoryService {
    private final TrajectoryRepository trajectoryRepository;

    @Autowired
    public TrajectoryService(TrajectoryRepository trajectoryRepository){
        this.trajectoryRepository = trajectoryRepository;
    }
    public Page<Trajectory> getTrajectory(Integer taxiId, LocalDateTime startDate, int pageNumber, int quantitySize){
        LocalDateTime endDateTime = startDate.plusDays(1).minusSeconds(1);
        Pageable page = PageRequest.of(pageNumber, quantitySize);
        return trajectoryRepository.findByTaxiIdAndDateBetweenOrderByDateDesc(taxiId,startDate, endDateTime,page);
    }
}
