package com.example.demo.controller;

import com.example.demo.model.Staff;
import com.example.demo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/add")
    public String addNewStaff(@RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam String emailAddress,
                              @RequestParam String joinedDate,
                              @RequestParam String role,
                              @RequestParam String defaultPassword) {
        try {
            LocalDate date = LocalDate.parse(joinedDate);
            Staff staff = new Staff();
            staff.setFirstName(firstName);
            staff.setLastName(lastName);
            staff.setEmailAddress(emailAddress);
            staff.setJoinedDate(date);
            staff.setRole(role);
            staff.setDefaultPassword(defaultPassword);
            staff.setStatus("active");

            staffService.saveStaff(staff);

            return "New staff has been added successfully!";
        } catch (DateTimeParseException e) {
            return "Invalid date format. Please use YYYY-MM-DD.";
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    @GetMapping("/list")
    public List<Staff> getAllStaffs() {
        return staffService.getAllStaffs();
    }
}
