package com.fleetManagement.api.services;

import com.fleetManagement.api.models.Taxi;
import com.fleetManagement.api.repositories.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaxiServices {
    private final TaxiRepository taxiRepository;

    @Autowired
    public TaxiServices(TaxiRepository taxiRepository){
        this.taxiRepository = taxiRepository;
    }
public Page<Taxi> getAll(int page, int size){
    Pageable pageNumber = PageRequest.of(page, size);
        return taxiRepository.findAll(pageNumber);
    }
        public Taxi saveTaxi(Taxi taxi){
            return taxiRepository.save(taxi);
        }
    }
