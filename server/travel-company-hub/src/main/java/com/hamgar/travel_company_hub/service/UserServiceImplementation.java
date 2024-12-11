package com.hamgar.travel_company_hub.service;

import com.hamgar.travel_company_hub.model.User;
import com.hamgar.travel_company_hub.repository.UserRepository;
import com.hamgar.travel_company_hub.request.RegisterUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return List.of();
    }

    @Override
    public User createUser(RegisterUserRequest request) {
            User user = User.builder()
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .role(request.getRole())
                    .build();

        return userRepository.save(user);
    }

}
