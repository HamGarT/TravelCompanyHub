package com.hamgar.travel_company_hub.model;

import com.hamgar.travel_company_hub.request.CreateTravelRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Travel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private LocalDateTime schedule;
    private  TRAVELSTATUS travelstatus;
    //@Embedded
    //private Schedule schedule;
    @OneToOne
    @JoinColumn(name = "van_id")
    private Van van;
    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
    @OneToOne
    @JoinColumn(name = "starting_station_id")
    private Station startingStation;
    @OneToOne
    @JoinColumn(name = "final_station_id")
    private Station finalStation;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public static Travel from(CreateTravelRequest request) {
        return Travel.builder()
                .price(request.getPrice())
                //.schedule(request.getSchedule())
                .travelstatus(request.getTravelstatus())
                .van(request.getVan())
                .driver(request.getDriver())
                .startingStation(request.getStartingStation())
                .finalStation(request.getFinalStation())
                .company(request.getCompany())
                .build();
    }
}
