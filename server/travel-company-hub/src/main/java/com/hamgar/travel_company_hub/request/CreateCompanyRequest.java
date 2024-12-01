package com.hamgar.travel_company_hub.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;
import java.util.List;

public class   CreateCompanyRequest {
    @NotBlank
    private String name;
    private String  openingHour;
    private String closingHour;
    private List<LocalTime> availableTravelHours;

}
