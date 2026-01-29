package com.example.demo.day_description.infrastructure.in.web;

import com.example.demo.event.infrastructure.in.web.EventResponse;

public record DayDescriptionResponse(
    Long id,
    String description,
    String imageUrl,
    Long eventId,
    EventResponse event
){}