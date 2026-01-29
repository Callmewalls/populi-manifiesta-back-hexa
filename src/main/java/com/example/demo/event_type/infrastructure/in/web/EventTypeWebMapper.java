package com.example.demo.event_type.infrastructure.in.web;

import org.mapstruct.Mapper;

import com.example.demo.event_type.domain.EventType;


@Mapper(componentModel = "spring")
public interface EventTypeWebMapper {
    
    EventTypeResponse toResponse(EventType eventtype);
}
