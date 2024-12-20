package com.hamgar.travel_company_hub.controller;

import com.hamgar.travel_company_hub.model.Company;
import com.hamgar.travel_company_hub.request.CreateCompanyRequest;
import com.hamgar.travel_company_hub.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> createCompany(
            @RequestBody CreateCompanyRequest req
            ){
        Company company = companyService.createCompany(req);
        return ResponseEntity.ok(company);
    }
}
