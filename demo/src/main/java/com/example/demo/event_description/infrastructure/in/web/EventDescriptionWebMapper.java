package com.example.demo.event_description.infrastructure.in.web;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.event.infrastructure.in.web.EventWebMapper;
import com.example.demo.event_description.domain.EventDescription;

@Mapper(componentModel = "spring")
public abstract class EventDescriptionWebMapper {

    @Autowired
    protected EventWebMapper eventWebMapper;

    public EventDescriptionResponse toResponse(EventDescription ed) {
        return new EventDescriptionResponse(
                ed.getImageUrl(),
                Long.valueOf(ed.getEventId()),
                ed.getObjectivesText(),
                ed.getEventName(),
                ed.getLocationSrc(),
                ed.getEventDescription(),
                ed.getEvent() != null ? eventWebMapper.toResponse(ed.getEvent()) : null
        );
    }
}
