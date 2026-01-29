package com.example.demo.event.application.ports.in;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.event.domain.Event;

public interface GetEventUseCase {
    
    Event getEventById(Long eventId);
    
    List<Event> getEventsByMonth(Integer monthNumber);

    List<Event> getEventsForDate(LocalDate date);
    
    List<Event> getEventsOrganizersForDate(LocalDate date);

}
