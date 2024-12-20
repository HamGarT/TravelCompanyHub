package com.hamgar.travel_company_hub.service;

import com.hamgar.travel_company_hub.model.Van;
import com.hamgar.travel_company_hub.repository.VanRepository;
import com.hamgar.travel_company_hub.request.CreateVanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VanServiceImplementation implements VanService{
    @Autowired
    private VanRepository vanRepository;

    @Override
    public Van createVan(CreateVanRequest request) {
        Van van = Van.builder()
                .model(request.getModel())
                .seats(request.getSeats())
                .plateNumber(request.getPlateNumber())
                .year(request.getYear())
                .company(request.getCompany())
                .build();
        return vanRepository.save(van);
    }
}
