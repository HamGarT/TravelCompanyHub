package com.hamgar.travel_company_hub.controller;

import com.hamgar.travel_company_hub.model.Travel;
import com.hamgar.travel_company_hub.request.CreateTravelRequest;
import com.hamgar.travel_company_hub.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/travels")
public class TravelController {
    @Autowired
    private TravelService travelService;

    @GetMapping
    public ResponseEntity<List<Travel>> getAllTravels(){
        List<Travel> travels = travelService.getAllTravels();
        return ResponseEntity.ok(travels);
    }

    @PostMapping
    public ResponseEntity<Travel> createTravel(@RequestBody CreateTravelRequest request){
        Travel travel = travelService.createTravel(request);
        return ResponseEntity.ok(travel);
    }

}
