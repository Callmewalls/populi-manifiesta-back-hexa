package com.example.demo.event_type.infrastructure.in.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.event_type.application.ports.in.GetEventTypeUseCase;
import com.example.demo.event_type.domain.EventType;


@RestController
@RequestMapping("event-types")
public class EventTypeController {
    
    GetEventTypeUseCase getUseCase;
    EventTypeWebMapper mapper;


    public EventTypeController(GetEventTypeUseCase getUseCase, EventTypeWebMapper mapper) {
        this.getUseCase = getUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public EventTypeResponse getEventTypeByEventTypeName(String eventtypeName) {
        EventType eventType = this.getUseCase.getEventTypeByName(eventtypeName);
        return mapper.toResponse(eventType);
    }
    
}
