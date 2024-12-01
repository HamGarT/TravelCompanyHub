package com.hamgar.travel_company_hub.repository;

import com.hamgar.travel_company_hub.model.Company;
import com.hamgar.travel_company_hub.model.Travel;
import com.hamgar.travel_company_hub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TravelRepository extends JpaRepository<User, Long> {

    @Query("SELECT t FROM Travel t WHERE lower")
    List<Travel> findBySearchingQuery(String query);
    Travel findTravelBySearchingEndingStation(String keyword);
    List<Travel> findAllByCompany(Company company);

}
