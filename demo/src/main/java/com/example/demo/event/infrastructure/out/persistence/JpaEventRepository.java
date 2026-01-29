package com.example.demo.event.infrastructure.out.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaEventRepository
                extends JpaRepository<EventEntity, Long> {

        @Query("select e from EventEntity e where e.dateTime = :dayTime")
        List<EventEntity> getEventsForDateTime(@Param("dayTime") LocalDateTime dayTime);

        @Query("SELECT e FROM EventEntity e WHERE e.dateTime >= :start AND e.dateTime < :end")
        List<EventEntity> getEventsForDate(
                        @Param("start") LocalDateTime start,
                        @Param("end") LocalDateTime end);

        @Query("select e from EventEntity e where MONTH(e.dateTime) = :monthNumber")
        List<EventEntity> getEventsByMonth(@Param("monthNumber") Integer monthNumber);
}
