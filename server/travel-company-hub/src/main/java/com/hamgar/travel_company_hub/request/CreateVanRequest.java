package com.hamgar.travel_company_hub.request;

import com.hamgar.travel_company_hub.model.Company;
import com.hamgar.travel_company_hub.model.SeatMapVan;
import lombok.Data;


import java.time.Year;
import java.util.List;

@Data
public class CreateVanRequest {
    private String model;
    //private List<String> images;
    private int seats;
    private String plateNumber;
    private Year year;
    private Company company;
}
