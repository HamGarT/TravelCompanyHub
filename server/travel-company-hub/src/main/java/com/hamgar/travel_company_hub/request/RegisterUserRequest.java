package com.hamgar.travel_company_hub.request;

import com.hamgar.travel_company_hub.model.USERROLE;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotBlank
    @Size(min = 3, max = 52)
    private String email;

    @NotBlank
    @Size(min = 6, max = 52)
    private String password;

    private USERROLE role;
}
