package com.example.demo.service;

import com.example.demo.model.Staff;
import com.example.demo.repository.StaffAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffAuthService {

    @Autowired
    private StaffAuthRepository staffAuthRepository;

    public boolean authenticate(String emailAddress, String password) {
        Optional<Staff> staffOpt = staffAuthRepository.findByEmailAddress(emailAddress);
        if (staffOpt.isPresent()) {
            Staff staff = staffOpt.get();
            // Directly compare the provided password with the stored plain text password
            return password.equals(staff.getDefaultPassword());
        }
        return false;
    }
}
