package com.hamgar.travel_company_hub.controller;

import com.hamgar.travel_company_hub.model.User;
import com.hamgar.travel_company_hub.request.RegisterUserRequest;
import com.hamgar.travel_company_hub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> register(@RequestBody RegisterUserRequest request) {
        User user = userService.createUser(request);
        return  ResponseEntity.ok(user);
    }
}
