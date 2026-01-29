package com.example.demo.event.infrastructure.in.web;

import com.example.demo.organizer.domain.Organizer;

public record EventOrganizerResponse(
    Long id,
    String dateTime,    
    Organizer organizer,    
    Long signs,    
    Long eventId,    
    Long locationId
){}
