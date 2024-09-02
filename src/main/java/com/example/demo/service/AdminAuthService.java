package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminAuthService {

    @Autowired
    private AdminAuthRepository adminAuthRepository;

    public boolean authenticate(String emailAddress, String password) {
        Optional<Admin> adminOpt = adminAuthRepository.findByEmailAddress(emailAddress);
        if (adminOpt.isPresent()) {
            Admin admin = adminOpt.get();
            // Directly compare the provided password with the stored plain text password
            return password.equals(admin.getDefaultPassword());
        }
        return false;
    }
}
