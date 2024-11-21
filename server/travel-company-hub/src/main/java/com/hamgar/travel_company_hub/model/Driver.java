package com.hamgar.travel_company_hub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String names;
    private String lastNames;
    private String dni;
    @Embedded
    private Contact contact;
    private String photo;
    private float stars;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


}
