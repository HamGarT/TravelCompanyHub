package com.hamgar.travel_company_hub.service;

import com.hamgar.travel_company_hub.model.Station;
import com.hamgar.travel_company_hub.repository.StationRepository;
import com.hamgar.travel_company_hub.request.CreateStationRequest;

public interface StationService {
    public Station createStation(CreateStationRequest request);
}
