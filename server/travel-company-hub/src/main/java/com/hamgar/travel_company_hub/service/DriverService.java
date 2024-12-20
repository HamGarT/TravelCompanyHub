package com.hamgar.travel_company_hub.service;

import com.hamgar.travel_company_hub.model.Driver;
import com.hamgar.travel_company_hub.request.CreateDriverRequest;
import com.hamgar.travel_company_hub.request.CreateTravelRequest;

import java.util.List;

public interface DriverService {
    public Driver createDriver(CreateDriverRequest request);
    public List<Driver> getAllByCompanyId(Long id);
}
