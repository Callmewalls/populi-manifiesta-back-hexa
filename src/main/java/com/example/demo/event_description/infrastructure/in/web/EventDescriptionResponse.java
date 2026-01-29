package com.example.demo.event_description.infrastructure.in.web;

import com.example.demo.event.infrastructure.in.web.EventResponse;

public record EventDescriptionResponse(
    String imageUrl,
    Long eventId,
    String objectivesText,
    String eventName,
    String locationSrc,
    String eventDescription,
    EventResponse event
){}