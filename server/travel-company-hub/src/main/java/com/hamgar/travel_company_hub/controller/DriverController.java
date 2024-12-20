package com.hamgar.travel_company_hub.controller;

import com.hamgar.travel_company_hub.model.Driver;
import com.hamgar.travel_company_hub.request.CreateDriverRequest;
import com.hamgar.travel_company_hub.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/api/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody CreateDriverRequest request) throws Exception{
        Driver driver = driverService.createDriver(request);
        return new ResponseEntity<>(driver, HttpStatus.CREATED);
    }
}
