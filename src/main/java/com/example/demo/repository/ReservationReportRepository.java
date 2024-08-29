package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.example.demo.entity.ReservationEntity;

@Repository
public interface ReservationReportRepository extends CrudRepository<ReservationEntity, Long> {

    @Query(value = "SELECT " +
                   "YEAR(reservation_date) AS year, " +
                   "MONTH(reservation_date) AS month, " +
                   "COUNT(*) AS total_reservations, " +
                   "AVG(daily_reservations) AS average_reservations " +
                   "FROM ( " +
                   "    SELECT " +
                   "        reservation_date, " +
                   "        COUNT(*) OVER (PARTITION BY YEAR(reservation_date), MONTH(reservation_date), DAY(reservation_date)) AS daily_reservations " +
                   "    FROM " +
                   "        reservation " +
                   "    WHERE " +
                   "        reservation_date BETWEEN DATE_SUB(CURDATE(), INTERVAL 1 MONTH) AND LAST_DAY(DATE_SUB(CURDATE(), INTERVAL 1 MONTH)) " +
                   ") AS monthly_summary " +
                   "GROUP BY " +
                   "    YEAR(reservation_date), " +
                   "    MONTH(reservation_date) " +
                   "ORDER BY " +
                   "    year, " +
                   "    month", nativeQuery = true)
    List<Object[]> findLastMonthReport();

    @Query(value = "SELECT " +
                   "YEAR(reservation_date) AS year, " +
                   "WEEK(reservation_date, 1) AS week_number, " +
                   "COUNT(*) AS total_reservations, " +
                   "AVG(daily_reservations) AS average_reservations " +
                   "FROM ( " +
                   "    SELECT " +
                   "        reservation_date, " +
                   "        COUNT(*) OVER (PARTITION BY YEAR(reservation_date), WEEK(reservation_date, 1), DAY(reservation_date)) AS daily_reservations " +
                   "    FROM " +
                   "        reservation " +
                   "    WHERE " +
                   "        reservation_date BETWEEN DATE_SUB(CURDATE(), INTERVAL (WEEKDAY(CURDATE()) + 7) DAY) AND DATE_SUB(CURDATE(), INTERVAL WEEKDAY(CURDATE()) DAY) " +
                   ") AS weekly_summary " +
                   "GROUP BY " +
                   "    YEAR(reservation_date), " +
                   "    WEEK(reservation_date, 1) " +
                   "ORDER BY " +
                   "    year, " +
                   "    week_number", nativeQuery = true)
    List<Object[]> findLastWeekReport();

    @Query(value = "SELECT " +
                   "YEAR(reservation_date) AS year, " +
                   "COUNT(*) AS total_reservations, " +
                   "AVG(daily_reservations) AS average_reservations " +
                   "FROM ( " +
                   "    SELECT " +
                   "        reservation_date, " +
                   "        COUNT(*) OVER (PARTITION BY YEAR(reservation_date), DAY(reservation_date)) AS daily_reservations " +
                   "    FROM " +
                   "        reservation " +
                   "    WHERE " +
                   "        reservation_date >= DATE_FORMAT(CURDATE(), '%Y-01-01') " +
                   ") AS yearly_summary " +
                   "GROUP BY " +
                   "    YEAR(reservation_date) " +
                   "ORDER BY " +
                   "    year", nativeQuery = true)
    List<Object[]> findYearlyReport();
}
