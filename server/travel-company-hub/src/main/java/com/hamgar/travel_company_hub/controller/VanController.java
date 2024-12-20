package com.hamgar.travel_company_hub.controller;

import com.hamgar.travel_company_hub.request.CreateVanRequest;
import com.hamgar.travel_company_hub.service.VanService;
import com.hamgar.travel_company_hub.model.Van;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/van")
public class VanController {

    @Autowired
    private VanService vanService;

    @PostMapping
    public ResponseEntity<Van> createVan(@RequestBody CreateVanRequest request){
        Van van = vanService.createVan(request);
        return ResponseEntity.ok(van);
    }
}
