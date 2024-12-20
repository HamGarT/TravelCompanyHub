package com.hamgar.travel_company_hub.service;

import com.hamgar.travel_company_hub.model.Driver;
import com.hamgar.travel_company_hub.repository.DriverRepository;
import com.hamgar.travel_company_hub.request.CreateDriverRequest;
import com.hamgar.travel_company_hub.request.CreateTravelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImplementation implements DriverService{
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Driver createDriver(CreateDriverRequest request) {
        Driver driver = Driver.builder()
                .names(request.getNames())
                .lastNames(request.getLastNames())
                .dni(request.getDni())
                .company(request.getCompany())
                .build();
        return driverRepository.save(driver);
    }

    @Override
    public List<Driver> getAllByCompanyId(Long id) {
        return List.of();
    }
}
