package com.example.demo.event.infrastructure.in.web;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.event.domain.Event;


@Mapper(componentModel = "spring")
public interface EventWebMapper {
    @Mapping(target = "eventId", source = "id")
    EventResponse toResponse(Event event);

    @Mapping(target = "eventId", source = "id")
    EventOrganizerResponse toEventOResponse(Event event);

}
