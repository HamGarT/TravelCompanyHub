package com.hamgar.travel_company_hub.controller;

import com.hamgar.travel_company_hub.model.Station;
import com.hamgar.travel_company_hub.request.CreateStationRequest;
import com.hamgar.travel_company_hub.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/station")
public class StationController {
    @Autowired
    private StationService stationService;

    @PostMapping
    public ResponseEntity<Station> createStation(@RequestBody CreateStationRequest request){
        Station station = stationService.createStation(request);
        return ResponseEntity.ok(station);
    }
}
