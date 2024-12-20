package com.hamgar.travel_company_hub.request;

import com.hamgar.travel_company_hub.model.*;
import lombok.Data;
import java.time.LocalDateTime;
@Data
public class CreateTravelRequest {
    private  Double price;
    private TRAVELSTATUS travelstatus;
    //private LocalDateTime schedule;
    private Van van;
    private Driver driver;
    private Station startingStation;
    private Station finalStation;
    private Company company;
}
