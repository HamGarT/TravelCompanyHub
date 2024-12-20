package com.hamgar.travel_company_hub.service;

import com.hamgar.travel_company_hub.error.exception.CompanyException;
import com.hamgar.travel_company_hub.model.Company;
import com.hamgar.travel_company_hub.model.User;
import com.hamgar.travel_company_hub.repository.CompanyRepository;
import com.hamgar.travel_company_hub.repository.UserRepository;
import com.hamgar.travel_company_hub.request.CreateCompanyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImplementation implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Company createCompany(CreateCompanyRequest req) {
        Company company = Company.builder()
                .name(req.getName())
                .closingHour(req.getClosingHour())
                .openingHour(req.getOpeningHour())
                .owner(req.getOwner())
                .build();
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Long companyId, CreateCompanyRequest updatedCompany) throws CompanyException {
        return null;
    }

    @Override
    public List<Company> getAllCompany() {
        return List.of();
    }

    @Override
    public void deleteCompany(Long companyId) throws CompanyException {

    }

    @Override
    public Company findCompanyById(Long companyId) throws CompanyException {
        return null;
    }

    @Override
    public List<Company> searchCompany(String keyword) {
        return List.of();
    }
}
