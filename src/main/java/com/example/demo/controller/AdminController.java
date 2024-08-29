package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public String addNewAdmin(@RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam String emailAddress,
                              @RequestParam String joinedDate,
                              @RequestParam String defaultPassword) {

        Admin admin = new Admin();
        admin.setFirstName(firstName);
        admin.setLastName(lastName);
        admin.setEmailAddress(emailAddress);
        admin.setJoinedDate(LocalDate.parse(joinedDate));
        admin.setDefaultPassword(defaultPassword);
        admin.setStatus("active");

        adminService.saveAdmin(admin);

        return "New admin has been added successfully!";
    }

    @GetMapping("/list")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

   
}
