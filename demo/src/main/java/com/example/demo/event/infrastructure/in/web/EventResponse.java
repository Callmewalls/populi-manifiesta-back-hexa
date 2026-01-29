package com.example.demo.event.infrastructure.in.web;

import com.example.demo.organizer.infrastructure.in.web.OrganizerResponse;

public record EventResponse(
    Long id,
    String dateTime,    
    Long organizerId,    
    Long signs,    
    Long eventId,    
    Long locationId,
    OrganizerResponse organizer
){}

