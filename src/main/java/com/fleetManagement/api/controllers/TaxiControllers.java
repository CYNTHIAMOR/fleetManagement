package com.fleetManagement.api.controllers;

import com.fleetManagement.api.models.Taxi;
import com.fleetManagement.api.services.TaxiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/taxis")

public class TaxiControllers {
    private final TaxiServices taxiServices;
    @Autowired
    public TaxiControllers(TaxiServices taxiServices){
        this.taxiServices = taxiServices;
    }
    @GetMapping
    public Page<Taxi> getAll(@RequestParam(defaultValue = "0")int page,
                             @RequestParam(defaultValue = "10")int size){
        return taxiServices.getAll(page, size);
    }


}
