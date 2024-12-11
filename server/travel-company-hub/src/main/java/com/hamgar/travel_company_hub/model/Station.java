package com.hamgar.travel_company_hub.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;
    @Embedded
    private Address address;

    @Embedded
    private Contact contact;
}
