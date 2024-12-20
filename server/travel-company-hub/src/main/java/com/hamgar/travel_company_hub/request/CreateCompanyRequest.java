package com.hamgar.travel_company_hub.request;

import com.hamgar.travel_company_hub.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class   CreateCompanyRequest {
    private String name;
    private User owner;
    private String  openingHour;
    private String closingHour;
    //private List<LocalTime> availableTravelHours;

}
