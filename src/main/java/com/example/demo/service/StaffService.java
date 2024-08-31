package com.example.demo.service;

import com.example.demo.model.Staff;
import com.example.demo.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> getAllStaffs() {
        return staffRepository.findAll();
    }

    public void saveStaff(Staff staff) {
        staffRepository.save(staff);
    }

    public Staff getStaffById(Long id) {
        return staffRepository.findById(id).orElse(null);
    }
}
