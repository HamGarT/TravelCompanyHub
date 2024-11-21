package com.hamgar.travel_company_hub.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class QuickStop {
    private String placeName;
    private Float disacount;
}
