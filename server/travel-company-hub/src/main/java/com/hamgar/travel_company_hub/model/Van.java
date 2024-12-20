package com.hamgar.travel_company_hub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Van {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private List<String> images;
    private int seats;
    private String plateNumber;
    private Year year;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @Embedded
    private SeatMapVan map;

}
