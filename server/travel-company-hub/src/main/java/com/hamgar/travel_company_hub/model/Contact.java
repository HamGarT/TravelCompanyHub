package com.hamgar.travel_company_hub.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data

public class Contact {
    private String mobile;
    private String twitter;
    private String instagram;
}
