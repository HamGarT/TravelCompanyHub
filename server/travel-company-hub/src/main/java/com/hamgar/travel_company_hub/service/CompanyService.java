package com.hamgar.travel_company_hub.service;

import com.hamgar.travel_company_hub.error.exception.CompanyException;
import com.hamgar.travel_company_hub.model.Company;
import com.hamgar.travel_company_hub.model.User;
import com.hamgar.travel_company_hub.request.CreateCompanyRequest;

import java.util.List;

public interface CompanyService {
    public Company createCompany(CreateCompanyRequest req, User user);
    public Company updateCompany(Long companyId, CreateCompanyRequest updatedCompany) throws CompanyException;
    public List<Company> getAllCompany();
    public void deleteCompany(Long companyId) throws CompanyException;
    public Company findCompanyById(Long companyId) throws CompanyException;
    public List<Company> searchCompany(String keyword);
}
