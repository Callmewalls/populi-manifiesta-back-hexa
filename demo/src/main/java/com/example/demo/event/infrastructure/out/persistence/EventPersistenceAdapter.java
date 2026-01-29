package com.example.demo.event.infrastructure.out.persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.event.application.ports.out.EventRepositoryPort;
import com.example.demo.event.domain.Event;

@Component
public class EventPersistenceAdapter implements EventRepositoryPort {

    JpaEventRepository repository;
    EventMapper mapper;

    public EventPersistenceAdapter(JpaEventRepository repository, EventMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Event> findById(Long eventId) {
        return repository.findById(eventId).map(mapper::toDomain);
    }

    @Override
    public List<Event> findEventsForDate(LocalDate date) {

        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.plusDays(1).atStartOfDay();

        return repository.getEventsForDate(start, end)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Event createEvent(Event event) {
        EventEntity entity = mapper.toEntity(event);
        EventEntity savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public List<Event> findByMonth(Integer monthNumber) {
        List<EventEntity> events = repository.getEventsByMonth(monthNumber);

        return events.stream().map(mapper::toDomain).collect(Collectors.toList());
    }

}
