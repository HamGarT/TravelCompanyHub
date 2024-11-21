package com.hamgar.travel_company_hub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Travel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Schedule schedule;
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
    @ElementCollection
    private List<QuickStop> quickStops;
}
