package com.example.demo.event_description.application.ports.in;

import java.util.List;
import java.util.Optional;

import com.example.demo.event_description.domain.EventDescription;

public interface GetEventDescriptionUseCase {
    
    Optional<EventDescription> getEventDescriptionById(Long id);

    Optional<EventDescription> getEventDescriptionByEventId(Long eventId);
    
    List<EventDescription> getAllEventDescription();
}
