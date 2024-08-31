package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String role;
    private LocalDate joinedDate;
    private String status;
    private String defaultPassword;
    
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public LocalDate getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(LocalDate joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDefaultPassword() {
		return defaultPassword;
	}
	public void setDefaultPassword(String defaultPassword) {
		this.defaultPassword = defaultPassword;
	}
    

    // Getters and Setters
    
}
