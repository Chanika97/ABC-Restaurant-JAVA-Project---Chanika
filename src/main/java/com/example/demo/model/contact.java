package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class contact {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contact_id;

    @Column(name = "contact_name")
    private String contact_name;

    @Column(name = "contact_email")
    private String contact_email;

    @Column(name = "contact_number")
    private String contact_number;

    @Column(name = "contact_subject")
    private String contact_subject;
    
    @Column(name = "contact_message")
    private String contact_message;

    // Getters and Setters

    public Long getcontact_Id() {
        return contact_id;
    }

    public void setcontact_Id(Long id) {
        this.contact_id = id;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getContact_subject() {
        return contact_subject;
    }

    public void setContact_subject(String contact_subject) {
        this.contact_subject = contact_subject;
    }

    public String getContact_message() {
        return contact_message;
    }

    public void setContact_message(String contact_message) {
        this.contact_message = contact_message;
    }
}
