package com.example.demo.event_type.application.service;

import org.springframework.stereotype.Service;

import com.example.demo.event_type.application.ports.in.GetEventTypeUseCase;
import com.example.demo.event_type.application.ports.out.EventTypeRepositoryPort;
import com.example.demo.event_type.domain.EventType;


@Service
public class EventTypeService implements GetEventTypeUseCase {

    private final EventTypeRepositoryPort eventtypeRepositoryPort;

    public EventTypeService(EventTypeRepositoryPort eventtypeRepositoryPort) {
        this.eventtypeRepositoryPort = eventtypeRepositoryPort;
    }

    @Override
    public EventType getEventTypeById(Long eventtypeId) {
        return eventtypeRepositoryPort.findById(eventtypeId)
                .orElseThrow(() -> new RuntimeException("EventType not found"));
    }

    @Override
    public EventType getEventTypeByName(String eventTypeName) {
        return eventtypeRepositoryPort.findByEventType(eventTypeName)
                .orElseThrow(() -> new RuntimeException("EventType not found"));
    }

}
