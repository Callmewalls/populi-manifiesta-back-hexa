package com.example.demo.event_type.infrastructure.out.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.event_type.application.ports.out.EventTypeRepositoryPort;
import com.example.demo.event_type.domain.EventType;


@Component
public class EventTypePersistenceAdapter implements EventTypeRepositoryPort{

    JpaEventTypeRepository repository;
    EventTypeMapper mapper;

    public EventTypePersistenceAdapter(JpaEventTypeRepository repository, EventTypeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<EventType> findByEventType(String eventtype) {
        return repository.findByEventTypeName(eventtype).map(mapper::toEventType);
    }

    @Override
    public Optional<EventType> findById(Long eventtypeId) {
        return repository.findById(eventtypeId).map(mapper::toEventType);
    }
    
}
