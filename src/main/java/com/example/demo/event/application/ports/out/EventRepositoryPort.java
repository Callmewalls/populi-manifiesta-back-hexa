package com.example.demo.event.application.ports.out;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.demo.event.domain.Event;


public interface EventRepositoryPort {
    
    Optional<Event> findById(Long eventId);
    
    List<Event> findByMonth(Integer monthNumber);

    List<Event> findEventsForDate(LocalDate date);

    Event createEvent(Event event);
}
