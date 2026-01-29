package com.example.demo.event_description.infrastructure.out.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaEventDescriptionRepository
        extends JpaRepository<EventDescriptionEntity, Long> {

    @Query("Select e from EventDescriptionEntity e where e.eventId=:id")
    public Optional<EventDescriptionEntity> findByEventId(Long id);
}
