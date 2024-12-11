package com.hamgar.travel_company_hub.service;

import com.hamgar.travel_company_hub.model.User;
import com.hamgar.travel_company_hub.request.RegisterUserRequest;

import java.util.List;

public interface UserService {
    public User getUserByEmail(String email);
    public List<User> getAllUser();
    public User createUser(RegisterUserRequest request); //for testing

}
