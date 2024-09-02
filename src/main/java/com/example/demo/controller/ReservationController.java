package com.example.demo.controller;

import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @PostMapping("/submit")
    public String submitReservation(@RequestParam String full_name,
                                    @RequestParam String email,
                                    @RequestParam String phone_number,
                                    @RequestParam int count_of_people,
                                    @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date reservation_date,
                                    @RequestParam(required = false) String message) {

        Reservation reservation = new Reservation();
        reservation.setFullName(full_name);
        reservation.setEmail(email);
        reservation.setPhoneNumber(phone_number);
        reservation.setCountOfPeople(count_of_people);
        reservation.setReservationDate(reservation_date);
        reservation.setMessage(message);
        

        reservationRepository.save(reservation);

        return "Reservation successful!";
    }
}