package com.hamgar.travel_company_hub.request;

import com.hamgar.travel_company_hub.model.Company;
import lombok.Data;

@Data
public class CreateDriverRequest {
    private String names;
    private String lastNames;
    private String dni;
    private Company company;

}
