package com.hamgar.travel_company_hub.service;

import com.hamgar.travel_company_hub.model.Van;
import com.hamgar.travel_company_hub.request.CreateVanRequest;

public interface VanService {
    public Van createVan(CreateVanRequest request);
}
