package com.example.demo.service;

import com.example.demo.repository.ReservationReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private ReservationReportRepository reportRepository;

    public List<Map<String, Object>> getLastMonthReport() {
        return reportRepository.findLastMonthReport().stream()
            .map(result -> Map.of(
                "year", result[0],
                "month", result[1],
                "total_reservations", result[2],
                "average_reservations", result[3]
            ))
            .collect(Collectors.toList());
    }

    public List<Map<String, Object>> getLastWeekReport() {
        return reportRepository.findLastWeekReport().stream()
            .map(result -> Map.of(
                "year", result[0],
                "week_number", result[1],
                "total_reservations", result[2],
                "average_reservations", result[3]
            ))
            .collect(Collectors.toList());
    }

    public List<Map<String, Object>> getYearlyReport() {
        return reportRepository.findYearlyReport().stream()
            .map(result -> Map.of(
                "year", result[0],
                "total_reservations", result[1],
                "average_reservations", result[2]
            ))
            .collect(Collectors.toList());
    }
}
