package com.example.demo.dto;

public class ReportDTO {

    private Long totalReservations;
    private Double averageReservations;
    private Double comparison;
    private Long totalCustomers;

    // Constructor with parameters matching the query
    public ReportDTO(Long totalReservations, Double averageReservations, Double comparison, Long totalCustomers) {
        this.totalReservations = totalReservations;
        this.averageReservations = averageReservations;
        this.comparison = comparison;
        this.totalCustomers = totalCustomers;
    }

    // Getters and setters
    public Long getTotalReservations() {
        return totalReservations;
    }

    public void setTotalReservations(Long totalReservations) {
        this.totalReservations = totalReservations;
    }

    public Double getAverageReservations() {
        return averageReservations;
    }

    public void setAverageReservations(Double averageReservations) {
        this.averageReservations = averageReservations;
    }

    public Double getComparison() {
        return comparison;
    }

    public void setComparison(Double comparison) {
        this.comparison = comparison;
    }

    public Long getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(Long totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    @Override
    public String toString() {
        return "ReportDTO{" +
               "totalReservations=" + totalReservations +
               ", averageReservations=" + averageReservations +
               ", comparison=" + comparison +
               ", totalCustomers=" + totalCustomers +
               '}';
    }
}
