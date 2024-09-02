package com.example.demo.controller;

import com.example.demo.model.Query;
import com.example.demo.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/queries")
public class QueryController {

    @Autowired
    private QueryRepository queryRepository;

    @GetMapping
    public List<Query> getAllQueries() {
        return queryRepository.findAll();
    }
}
