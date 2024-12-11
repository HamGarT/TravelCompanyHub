package com.hamgar.travel_company_hub.service;

import com.hamgar.travel_company_hub.error.exception.TravelNotFoundException;
import com.hamgar.travel_company_hub.model.TRAVELSTATUS;
import com.hamgar.travel_company_hub.model.Travel;
import com.hamgar.travel_company_hub.model.User;
import com.hamgar.travel_company_hub.request.CreateTravelRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface TravelService {
 public List<Travel> getAllTravels();
 public Travel updateTravel(Long id, CreateTravelRequest request) throws TravelNotFoundException;
 public Travel updateOnlyTravelStatus(Long id, TRAVELSTATUS travelstatus) throws TravelNotFoundException;
 public Travel createTravel(CreateTravelRequest request);
 public void deleteTravel(Long id);
 public List<Travel> getTravelsByCompanyId(Long id);
 public List<Travel> searchTravels(String startStation, String endStation, LocalDateTime currentDateTime);
 public Travel getTravelById(Long id);

}
