package com.hamgar.travel_company_hub.repository;

import com.hamgar.travel_company_hub.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("SELECT c FROM Company c WHERE lower(c.name) LIKE lower(concat('%', :keyword, '%'))")
    List<Company> findCompanyBySearching(String keyword);
    Company findCompanyByOwnerId(Long userId);

}