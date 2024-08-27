package com.example.demo.repository;

import com.example.demo.model.contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<contact, Long> {
}
