package com.example.demo.event_type.application.ports.in;

import com.example.demo.event_type.domain.EventType;

public interface GetEventTypeUseCase {
    
    EventType getEventTypeById(Long eventTypeId);

    EventType getEventTypeByName(String eventTypeName);

}
