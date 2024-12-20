package com.hamgar.travel_company_hub.request;

import com.hamgar.travel_company_hub.model.Address;
import com.hamgar.travel_company_hub.model.Company;
import com.hamgar.travel_company_hub.model.Contact;
import lombok.Data;

@Data
public class CreateStationRequest {
    private String name;
    private Address address;
    private Contact contact;
    private Company company;
}
