package com.example.demo.repository;

import com.example.demo.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffAuthRepository extends JpaRepository<Staff, Long> {
    Optional<Staff> findByEmailAddress(String emailAddress);
}
