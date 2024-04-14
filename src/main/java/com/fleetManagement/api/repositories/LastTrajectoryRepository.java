package com.fleetManagement.api.repositories;

import com.fleetManagement.api.models.LastTrajectory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LastTrajectoryRepository extends JpaRepository<LastTrajectory, Integer> {
    @Query(value = "SELECT ID, TAXI_ID, date, LONGITUDE, LATITUDE\n" +
            "FROM (SELECT ID, TAXI_ID, date, LONGITUDE, LATITUDE,\n" +
            "ROW_NUMBER() OVER (PARTITION BY TAXI_ID ORDER BY date DESC) as row_num\n" +
            "FROM  trajectories) AS ranked\n" +
            "WHERE row_num = 1", nativeQuery = true)
    List<LastTrajectory> findLastTrajectory (Pageable pageable);
}
