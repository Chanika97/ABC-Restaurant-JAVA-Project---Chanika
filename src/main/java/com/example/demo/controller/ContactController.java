package com.example.demo.controller;

import com.example.demo.model.contact;
import com.example.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/submit")
    public String submitContact(@RequestParam String contact_name,
                                @RequestParam String contact_email,
                                @RequestParam String contact_number,
                                @RequestParam String contact_subject,
                                @RequestParam String contact_message) {

        contact contact = new contact();
        contact.setContact_name(contact_name);
        contact.setContact_email(contact_email);
        contact.setContact_number(contact_number);
        contact.setContact_subject(contact_subject);
        contact.setContact_message(contact_message);

        contactRepository.save(contact);

        return "Your message has been sent successfully!";
    }
}
