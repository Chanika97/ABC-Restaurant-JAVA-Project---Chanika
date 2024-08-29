package com.example.demo.controller;

import com.example.demo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/weekly")
    public List<Map<String, Object>> getWeeklyReports() {
        return reportService.getLastWeekReport();
    }

    @GetMapping("/monthly")
    public List<Map<String, Object>> getMonthlyReports() {
        return reportService.getLastMonthReport();
    }

    @GetMapping("/annual")
    public List<Map<String, Object>> getYearlyReports() {
        return reportService.getYearlyReport();
    }
}
