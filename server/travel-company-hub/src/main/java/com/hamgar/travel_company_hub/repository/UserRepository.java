package com.hamgar.travel_company_hub.repository;

import com.hamgar.travel_company_hub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String username);
}
