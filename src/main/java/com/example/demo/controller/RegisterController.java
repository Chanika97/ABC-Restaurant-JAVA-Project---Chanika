package com.example.demo.controller;

import com.example.demo.model.Register;
import com.example.demo.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterRepository registerRepository;

    @PostMapping("/submit")
    public String submitRegister(@RequestParam String name,
                                    @RequestParam String email,
                                    @RequestParam String password)
                                    {

        Register register = new Register();
        register.setName(name);
        register.setEmail(email);
        register.setPassword(password);
        

        registerRepository.save(register);

        return "Thanks for signing up with us! From now on, you will receive all our special offers and news!";
    }
}