package com.hamgar.travel_company_hub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne
    private User owner;
    private String openingHour;
    private String closingHour;
    @ElementCollection
    private List<LocalTime> availableTravelHours;
    @OneToMany(mappedBy = "company", orphanRemoval = true, fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<Driver> drivers;
    @OneToMany(mappedBy = "company", orphanRemoval = true, fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Station> stations;
    @OneToMany(mappedBy = "company", orphanRemoval = true, fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Travel> travels;

    @OneToMany(mappedBy = "company", orphanRemoval = true, fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Van> vans;

}
