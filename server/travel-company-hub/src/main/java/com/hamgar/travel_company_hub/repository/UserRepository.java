package com.hamgar.travel_company_hub.repository;

import com.hamgar.travel_company_hub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String username);
}
