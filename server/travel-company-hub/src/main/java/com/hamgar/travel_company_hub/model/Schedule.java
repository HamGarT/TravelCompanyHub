package com.hamgar.travel_company_hub.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    private LocalTime hour;
    private LocalDate date;
}
