package com.example.demo.event.application.ports.in;

import com.example.demo.event.domain.Event;

public interface PostEventUseCase {
    
    Event createEvent( String dateTime, Long organizerId, Long cityId);

}
