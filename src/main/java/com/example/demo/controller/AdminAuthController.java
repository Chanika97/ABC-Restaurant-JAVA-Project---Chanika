package com.example.demo.controller;

import com.example.demo.service.AdminAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminAuthController {

    @Autowired
    private AdminAuthService adminAuthService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Return the login page view
    }

    @PostMapping("/login")
    public String login(@RequestParam("emailAddress") String emailAddress,
                        @RequestParam("defaultPassword") String defaultPassword,
                        Model model) {
        if (adminAuthService.authenticate(emailAddress, defaultPassword)) {
            // Redirect to the specific URL after successful login
            return "redirect:/ABC/admin/index.html";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login"; // Return to the login page with an error message
        }
    }
}
