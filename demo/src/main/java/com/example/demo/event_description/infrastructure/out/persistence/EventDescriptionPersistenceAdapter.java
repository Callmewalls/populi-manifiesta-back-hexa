package com.example.demo.event_description.infrastructure.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.event_description.application.ports.out.EventDescriptionRepositoryPort;
import com.example.demo.event_description.domain.EventDescription;


@Component
public class EventDescriptionPersistenceAdapter implements EventDescriptionRepositoryPort{

    JpaEventDescriptionRepository repository;
    EventDescriptionMapper mapper;

    public EventDescriptionPersistenceAdapter(JpaEventDescriptionRepository repository, EventDescriptionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<EventDescription> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<EventDescription> findByEventId(Long eventId) {
        return repository.findByEventId(eventId)
                .map(mapper::toDomain);
    }

    @Override
    public List<EventDescription> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
    
}
