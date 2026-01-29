package com.example.demo.event_type.infrastructure.out.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaEventTypeRepository
                extends JpaRepository<EventTypeEntity, Long> {

        @Query("SELECT e FROM EventTypeEntity e WHERE e.name = :eventType")
        public Optional<EventTypeEntity> findByEventTypeName(String eventType);
}
