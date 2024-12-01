package com.hamgar.travel_company_hub.repository;

import com.hamgar.travel_company_hub.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
}
