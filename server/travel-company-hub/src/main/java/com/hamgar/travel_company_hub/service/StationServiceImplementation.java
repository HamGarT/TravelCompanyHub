package com.hamgar.travel_company_hub.service;

import com.hamgar.travel_company_hub.model.Station;
import com.hamgar.travel_company_hub.repository.StationRepository;
import com.hamgar.travel_company_hub.request.CreateStationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationServiceImplementation implements StationService {
    @Autowired
    private StationRepository stationRepository;

    @Override
    public Station createStation(CreateStationRequest request) {
        Station station = Station.builder()
                .name(request.getName())
                .address(request.getAddress())
                .contact(request.getContact())
                .company(request.getCompany())
                .build();
        return stationRepository.save(station);
    }
}
