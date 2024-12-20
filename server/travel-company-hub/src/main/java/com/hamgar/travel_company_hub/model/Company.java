package com.hamgar.travel_company_hub.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private User owner;
    private String openingHour;
    private String closingHour;
    @ElementCollection
     // Match the format in your JSON.
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
