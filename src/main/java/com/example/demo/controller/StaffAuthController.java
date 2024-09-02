package com.example.demo.controller;

import com.example.demo.service.StaffAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class StaffAuthController {

    @Autowired
    private StaffAuthService staffAuthService;

    @GetMapping("/staff/login")
    public String showLoginForm() {
        // Serve the HTML file from /ABC/staff/login.html
        return "ABC/staff/login";
    }

    @PostMapping("/staff/login")
    public RedirectView login(@RequestParam("emailAddress") String emailAddress,
                              @RequestParam("defaultPassword") String defaultPassword) {
        String error = null;

        if (emailAddress.isEmpty() || defaultPassword.isEmpty()) {
            error = "Email and password cannot be empty";
        } else if (!staffAuthService.authenticate(emailAddress, defaultPassword)) {
            error = "Invalid email or password";
        }

        if (error != null) {
            return new RedirectView("/staff/login?error=" + error);
        }

        return new RedirectView("/ABC/staff/index.html");
    }
}
