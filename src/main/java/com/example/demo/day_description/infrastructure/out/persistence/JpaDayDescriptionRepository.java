package com.example.demo.day_description.infrastructure.out.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaDayDescriptionRepository
        extends JpaRepository<DayDescriptionEntity, Long> {

    @Query("Select e from DayDescriptionEntity e where e.eventId=:id")
    public Optional<DayDescriptionEntity> findByEventId(Long id);
}
