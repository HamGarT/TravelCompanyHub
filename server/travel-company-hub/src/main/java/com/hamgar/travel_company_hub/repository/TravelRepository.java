package com.hamgar.travel_company_hub.repository;

import com.hamgar.travel_company_hub.model.Company;
import com.hamgar.travel_company_hub.model.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {

    @Query("""
                SELECT t FROM Travel t 
                WHERE t.startingStation.address.city = :startStation 
                  AND t.finalStation.address.city = :endStation 
                  AND (t.schedule > :currentDateTime OR t.schedule = :currentDateTime)
            """)
    List<Travel> findTravelsFromToAfterDateTime(
            @Param("startStation") String startStation,
            @Param("endStation") String endStation,
            @Param("currentDateTime") LocalDateTime currentDateTime
    );

    List<Travel> findAllByCompany(Company company);

    Travel findTravelById(Long id);
}
