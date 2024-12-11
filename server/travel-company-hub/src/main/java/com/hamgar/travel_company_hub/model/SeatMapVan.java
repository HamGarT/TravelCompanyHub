package com.hamgar.travel_company_hub.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class SeatMapVan {
    private int rowSeat;
    private  int columnSeat;
    private String mapa;
    private String vanModel;
}
