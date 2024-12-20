package com.hamgar.travel_company_hub.service;

import com.hamgar.travel_company_hub.error.exception.TravelNotFoundException;
import com.hamgar.travel_company_hub.model.*;
import com.hamgar.travel_company_hub.repository.*;
import com.hamgar.travel_company_hub.request.CreateTravelRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TravelServiceImplementation implements TravelService{
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private VanRepository vanRepository;
    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private TravelRepository travelRepository;

    @Override
    public List<Travel> getAllTravels() {
        return travelRepository.findAll();
    }

    @Override
    public Travel updateTravel(Long id, CreateTravelRequest request) throws TravelNotFoundException {
        Travel travel = travelRepository.findTravelById(id);
        if (travel == null) {
            throw new TravelNotFoundException("Travel with id " + id + " not found");
        }
        updateFieldIfPresent(request.getCompany(), travel::setCompany);
        updateFieldIfPresent(request.getPrice(), travel::setPrice);
        updateFieldIfPresent(request.getVan(), travel::setVan);
        updateFieldIfPresent(request.getTravelstatus(), travel::setTravelstatus);
        updateFieldIfPresent(request.getDriver(), travel::setDriver);
        //updateFieldIfPresent(request.getSchedule(), travel::setSchedule);
        updateFieldIfPresent(request.getFinalStation(), travel::setFinalStation);
        updateFieldIfPresent(request.getStartingStation(), travel::setStartingStation);
        return travelRepository.save(travel);
    }

    @Override
    public Travel updateOnlyTravelStatus(Long id, TRAVELSTATUS travelstatus) throws TravelNotFoundException {
        Travel travel = travelRepository.findTravelById(id);
        if (travel == null) {
            throw new TravelNotFoundException("Travel with id " + id + " not found");
        }
        updateFieldIfPresent(travelstatus, travel::setTravelstatus);
        return travelRepository.save(travel);
    }

    @Override
    public Travel createTravel(CreateTravelRequest request) {
        Travel newTravel = Travel.from(request);
        //Travel newTravel = request;
        Optional<Van> vanOptional = vanRepository.findById(newTravel.getVan().getId());
        Van van = vanOptional.orElseThrow(()-> new EntityNotFoundException(String.format("No Van found with Id %s", request.getVan().getId())));
        Optional<Driver> driverOptional = driverRepository.findById(newTravel.getDriver().getId());
        Driver driver = driverOptional.orElseThrow(()-> new EntityNotFoundException(String.format("No Driver found with Id %s",request.getDriver().getId())));
        Optional<Station> startingStationOptional = stationRepository.findById(newTravel.getStartingStation().getId());
        Station startingStation = startingStationOptional.orElseThrow(()-> new EntityNotFoundException(String.format("No Station found with Id %s", request.getStartingStation().getId())));
        Optional<Station> finalStationOptional = stationRepository.findById(newTravel.getFinalStation().getId());
        Station finalStation = finalStationOptional.orElseThrow(()-> new EntityNotFoundException(String.format("No Station found with Id %s", request.getFinalStation().getId())));
        Optional<Company> companyOptional = companyRepository.findById(newTravel.getCompany().getId());
        Company company = companyOptional.orElseThrow(()-> new EntityNotFoundException(String.format("No Company found with Id %s", request.getDriver().getId())));
        newTravel.setVan(van);
        newTravel.setDriver(driver);
        newTravel.setCompany(company);
        newTravel.setStartingStation(startingStation);
        newTravel.setFinalStation(finalStation);
        //Travel savedTravel = travelRepository.save(newTravel);

        return travelRepository.save(newTravel);
    }

    @Override
    public void deleteTravel(Long id) { travelRepository.deleteById(id);}

    @Override
    public List<Travel> getTravelsByCompanyId(Long id) {
        return List.of();
    }

    @Override
    public List<Travel> searchTravels(String startStation, String endStation, LocalDateTime currentDateTime) {
        return travelRepository.findTravelsFromToAfterDateTime(startStation, endStation, currentDateTime);
    }

    @Override
    public Travel getTravelById(Long id) {return travelRepository.findTravelById(id);}

    private <T> void updateFieldIfPresent(T field, Consumer<T> updater) {
        if (field != null) {
            updater.accept(field);
        }
    }
}
