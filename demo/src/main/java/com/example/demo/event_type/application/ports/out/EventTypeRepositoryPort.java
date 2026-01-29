package com.example.demo.event_type.application.ports.out;

import java.util.Optional;

import com.example.demo.event_type.domain.EventType;


public interface EventTypeRepositoryPort {
    
    Optional<EventType> findById(Long eventtypeId);
    
    Optional<EventType> findByEventType(String eventtype);
}
